#!/bin/bash

function compileSimulator() {
	echo "Compiling Simulator..."

	cd ~/Downloads/ucef-ieee1451smartsensor/IEEE1451SmartSensorSimulator/IEEE1451SmartSensorFederation_generated/
	mvn clean install

	cd ~/Downloads/ucef-ieee1451smartsensor/IEEE1451SmartSensorSimulator/IEEE1451SmartSensorFederation_deployment/
	mvn clean install

	echo "Done!"
}

function compileTester() {
	echo "Compiling Tester..."

	cd ~/Downloads/ucef-ieee1451smartsensor/IEEE1451SmartSensorTester/IEEE1451SmartSensorFederation_generated/
	mvn clean install

	cd ~/Downloads/ucef-ieee1451smartsensor/IEEE1451SmartSensorTester/IEEE1451SmartSensorFederation_deployment
	mvn clean install

	echo "Done!"
}

function compileFederation() {
	echo "Compiling Tester..."

	cd ~/Downloads/ucef-ieee1451smartsensor/IEEE1451SmartSensorFederation/IEEE1451SmartSensorFederation_generated/
	mvn clean install

	cd ~/Downloads/ucef-ieee1451smartsensor/IEEE1451SmartSensorFederation/IEEE1451SmartSensorFederation_deployment
	mvn clean install

	echo "Done!"
}

PS3="Please choose an option "
select option in "Compile only Simulator" "Compile only Tester" "Compile both"
do
    case $option in
	"Compile only Simulator") 
	    compileSimulator
	    break;;
	"Compile only Tester") 
	    compileTester
	    break;;
	"Compile both")
	    compileSimulator
	    compileTester
	    compileFederation
	    break;;
    esac
done



