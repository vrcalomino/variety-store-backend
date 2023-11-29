# Variety Store Backend

This project was made as a conclusion for the APIs development with [Spring Boot](https://todocodeacademy.com/course/desarrollo-de-apis-con-spring-boot/) course from TodoCode.
The asignment can be seen in the following PDF:
<embed src="./asignment-final-project.pdf" type="application/pdf" width="100%" height="600px" />

I used the following tecnologies for this project:
- Java 17
- Spring Boot 3.2.0
- MySQL
- Hibernate as a JPA provider

I also followed the layered architecture where each part of the application has one functionality and I used dependency injection applying inversion of control and assuring the single instance of objects.

The application was deployed with [Google Cloud Platform](https://cloud.google.com/) (GCP).
The link is [this one]()

#### App usage:

To run it locally you have to:
- Clone the repo
- Run `mvn compile`
- Run `java -jar .\target\bazar-0.0.1-SNAPSHOT.jar`

The app meets the requirement of the asignment so here's what you can do:
- CRUD operations of clients
- CRUD operations of products
- CRUD operations of sales
- GET products where stock is lesser than 5
- GET products from a certain sale
- GET the total amount of money made and the total amount of sales in a specific day
- GET the data of the largest sale made
