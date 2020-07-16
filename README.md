Coverage: 63.6%
# Inventory Management System (IMS)- Arbab Ahmed

It is an IMS application that lets the user perform CRUD operations on all four of the tables: Customers, Products, Orders and Orderlines.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

You will require git to clone the project from github and a Java IDE such as Eclipse.

### Installing

A step by step series of examples that tell you how to get a development env running

Step 1: Clone the porject on your machine using github.
Step 2: Use eclipse or any other Java IDE (that support Maven projects) to locate and open the project.
Step 3: Run the runner.class from ims-starting-point/src/main/java/com.qa.ims/runner.java
Step 4: Enter the username and password in console when asked to access the database.


```
Example.
INFO - What is your username
****
INFO - What is your password
****
INFO - Which entity would you like to use?
INFO - CUSTOMER: Information about customers
INFO - ITEM: Individual Items
INFO - ORDER: Purchases of items
INFO - STOP: To close the application
Customer
INFO - What would you like to do with customer:
INFO - CREATE: To save a new item into the database
INFO - READ: To read an item from the database
INFO - UPDATE: To change an item already in the database
INFO - DELETE: To remove an item from the database
INFO - RETURN: To return to domain selection
read
INFO - id:1 first name:Arbab surname:Ahmed
INFO - id:2 first name:Vinesh surname:Ghela
INFO - id:3 first name:Alan surname:idk
INFO - id:4 first name:Nicholas surname:idk
INFO - id:5 first name:angelica surname:idk
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Running all tests
Step 1: Locate using Java IDE ims-starting-point/src/test/java
Step 2: Right click on the folder and click jUnit Test under the run as option.

## Deployment
In order to deploy this application firstly the GCP (Google Cloud Computing) SQL instance that is connected to by the application, needs to be running.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

I used [GitHub](https://github.com/kakarotss/ims-starting-point) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Nick Johnson** - *Refinements* - [nickrstewarttds](https://github.com/nickrstewarttds)
* **Arbab Ahmed** - *Implementation+Testing* - [nickrstewarttds](https://github.com/kakarotss)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments
* Greatful for all the help given by Vinesh Ghela, Nick Johnson and Alan Davis.
* Inspiration
* etc.