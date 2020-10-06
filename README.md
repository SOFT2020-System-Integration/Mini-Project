# Mini-Project

System Integration fall 2020

Thomas Stevns Nielsen Ebsen  
Andreas Duelund Jørgensen  
Jonas Björk Hein  
Jonatan Magnus Bakke  

# Objectives
The task is to create an application which makes use of web services.
The application must have as a minumum a client and a restful service.


# Technical Features
## Summary
This project consists of a REST Service and Client witten in JAVA and a SOAP Application, also written in JAVA.
Our REST is a simple Item / Cart Service, that allow you to add items to a cart in the database.

The backend is developed using spring hateoas. After running the restapplication, go to http://localhost:8080 and you should be directed to the HAL Explorer where you can explore the data


## Business Case
Our business case is to create a REST service where you can put items in a cart using rest. This can be used for e.g. a webstore or even in a storage managment system.

## Execution
Open `RestBackendAndClient` in your favorite IDE, we used intelliJ.
* To start the rest service, run the `RestApplication.java` class. This will start a local database through spring.  
* To start the client, run the `ClientApplication.java` class. This will run in your terminal and show some simple crud functions on our api.