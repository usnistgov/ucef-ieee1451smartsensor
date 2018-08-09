#!/bin/bash
root_directory=`pwd`
logs_directory=$root_directory/logs

fedmgr_host=127.0.0.1
fedmgr_port=8083

timestamp=`date +"%F_%T"`

function getNumberJoined {
    if (( $# != 1 ))
    then
        echo bad syntax: getNumberJoined federateType
        exit 1
    fi
    federateList=$(curl -s X GET http://$fedmgr_host:$fedmgr_port/federates -H "Content-Type: application/json")
    # JSON Query:
    #   .[] = process all values in the input object
    #   select(...) = exclude entries for resigned federates (resignTime defined) and federates that are not the desired TYPE
    #   enclosing [ ] = combine the result from the above queries into a single JSON array
    #   length = count the number of elements in the combined array
    echo $federateList | jq --arg TYPE "$1" '[.[] | select(.resignTime == null and .federateType == $TYPE)] | length'
}

function waitUntilJoined {
    if (( $# != 2 ))
    then
        echo bad syntax: waitUntilJoined federateType expectedNumber
        exit 1
    fi
    federateType=$1
    expectedNumber=$2

    if (( $expectedNumber < 1 ))
    then
        echo "illegal argument: expectedNumber of federates cannot be $expectedNumber"
        exit 1
    fi

    printf "Waiting for $expectedNumber instances of $federateType to join.."
    while (( $(getNumberJoined $federateType) != $expectedNumber))
    do
        printf "."
        sleep 5
    done
    printf "\n"
}

nc -z $fedmgr_host $fedmgr_port
if [ $? -eq 0 ]; then
    echo Cannot start the federation manager on port $fedmgr_port
    exit 1
fi

if [ ! -d $logs_directory ]; then
    echo Creating the $logs_directory directory
    mkdir $logs_directory
fi

# build the project
#echo "Press 0 to run, 1 to build and run and hit [ENTER]: "
#read response

# run the federation manager
cd ~/Downloads/ucef-ieee1451smartsensor/IEEE1451SmartSensorFederation/IEEE1451SmartSensorFederation_deployment
xterm -fg white -bg black -l -lf $logs_directory/federation-manager-${timestamp}.log -T "Federation Manager" -geometry 100x20+0+0 -e "export CPSWT_ROOT=`pwd` && mvn exec:java -P FederationManagerExecJava" &

printf "Waiting for the federation manager to come online.."
until $(curl -o /dev/null -s -f -X GET http://$fedmgr_host:$fedmgr_port/fedmgr); do
    printf "."
    sleep 5
done
printf "\n"

curl -o /dev/null -s -X POST http://$fedmgr_host:$fedmgr_port/fedmgr --data '{"action": "START"}' -H "Content-Type: application/json"

# run the other federates
cd /home/vagrant/Downloads/ucef-ieee1451smartsensor/IEEE1451SmartSensorSimulator/IEEE1451SmartSensorFederation_generated/IEEE1451SmartSensorFederation-java-federates/IEEE1451SmartSensorFederation-impl-java/IEEE1451SmartSensorSimulator
xterm -fg green -bg black -l -lf $logs_directory/tester-${timestamp}.log -T "IEEE1451SmartSensor" -geometry 100x30+650+0 -e "java -Dlog4j.configurationFile=conf/log4j2.xml -jar target/IEEE1451SmartSensorSimulator-0.1.0-SNAPSHOT.jar  -federationId=IEEE1451SmartSensorFederation -configFile=conf/IEEE1451SmartSensorSimulatorConfig.json -name=sensor1" &
sleep 2s

cd ~/Downloads/ucef-ieee1451smartsensor/IEEE1451SmartSensorSimulator/IEEE1451SmartSensorFederation_deployment
xterm -fg yellow -bg black -l -lf $logs_directory/smart-sensor-${timestamp}.log -T "IEEE1451SmartSensorSimulator" -geometry 100x30+0+325 -e "mvn exec:java -P ExecJava,IEEE1451SmartSensorSimulator -Dexecargs='name=sensor2'" &
sleep 10s

cd ~/Downloads/ucef-ieee1451smartsensor/IEEE1451SmartSensorTester/IEEE1451SmartSensorFederation_deployment
xterm -fg green -bg black -l -lf $logs_directory/tester-${timestamp}.log -T "IEEE1451SmartSensorTester" -geometry 100x30+650+0 -e "mvn exec:java -P ExecJava,IEEE1451SmartSensorTester" &
sleep 10s

# terminate the simulation
read -n 1 -r -s -p "Press any key to terminate the federation execution..."
printf "\n"

curl -o /dev/null -s -X POST http://$fedmgr_host:$fedmgr_port/fedmgr --data '{"action": "TERMINATE"}' -H "Content-Type: application/json"

printf "Waiting for the federation manager to terminate.."
while $(curl -o /dev/null -s -f -X GET http://$fedmgr_host:$fedmgr_port/fedmgr); do
    printf "."
    sleep 5
done
printf "\n"
