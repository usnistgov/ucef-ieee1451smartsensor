#!/bin/bash

cd ~/Downloads/ucef-ieee1451smartsensor/IEEE1451SmartSensorSimulator/IEEE1451SmartSensorFederation_generated/
mvn clean install

cd ~/Downloads/ucef-ieee1451smartsensor/IEEE1451SmartSensorSimulator/IEEE1451SmartSensorFederation_deployment/
mvn clean install

cd ~/Downloads/ucef-ieee1451smartsensor/IEEE1451SmartSensorTester/IEEE1451SmartSensorFederation_generated/
mvn clean install

cd ~/Downloads/ucef-ieee1451smartsensor/IEEE1451SmartSensorTester/IEEE1451SmartSensorFederation_deployment
mvn clean install

