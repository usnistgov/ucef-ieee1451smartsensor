# ucef-ieee1451smartsensor

# Introduction

Cyber-Physical Systems (CPS) are integrations of physical and cyber components connected in a network that use computation to monitor and control the physical world using feedback loops of sensing and actuation. This project utilizes the Universal CPS Environment for Federation (UCEF), a toolkit to build co-simulations, and, the Institute of Electrical and Electronics Engineers (IEEE) 1451 standard, a network interface standard for smart sensors. IEEE 1451 network interface allows applications to remotely communicate with the sensors, such as, reading sensor data, as well as reading its Transducer Electronic Data Sheets (TEDS). The purpose of this project is to simulate a IEEE 1451 based smart temperature sensor in Java code effectively making it a “digital twin” of the real sensor. Different faults can be injected in this “digital twin” and its behavior and the responses it sends back can be analyzed to model how the sensor reacts to it including if it causes the simulated sensor to fail. These faults include setting the operating temperature outside the sensor’s rated limit, setting the sensor’s input voltage outside the rated limit, and disconnecting the sensor from the network. The long-term goal is to have hundreds of these sensors running in a co-simulation and analyzing what the side effects of one malfunctioning unit will have on the rest of the sensors and what will be some of the ways of minimizing these side effects. These results could then be effectively used to integrate these smart sensors in CPS/IoT.

# Authors
Dr. Martin Burns
Dr. Eugene Song
Abhinav Pandey
