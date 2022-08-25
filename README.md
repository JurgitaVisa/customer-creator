# Customer data creation application

Customer data creation service.

This application consists of two java modules:
1. application
2. person-generator (provides initial customer data upon startup and request)

Person generator module is part of an older project. See https://github.com/JurgitaVisa/person-generator  

Angular front-end application:
1. customer-front

### Screenshots
![ScreenShot](images/main.JPG)
![ScreenShot](images/form.JPG)

#### Technologies used:
- Spring Boot 2.7.1,
- Java 11
- Swagger-UI, Maven
- Angular 14.1.0

## Getting Started
### Prerequisites

- Clone the repository `git clone https://github.com/JurgitaVisa/customer-creator.git`
- Maven, JDK, node, npm, angular cli

### Run backend

- go to project folder `cd {yourPathToFolder}/customer-creator/application`
- Run `mvn spring-boot:run` (application will start on port 8080)

Application documentation is accessible at http://localhost:8080/swagger-ui.html<br/>

### Run frontend 

- go to project folder `cd {yourPathToFolder}/customer-creator/customer-front`
- run `npm install` to install node modules 
- run `ng serve` (customer-front will start on port 4200)

Application is accessible at http://localhost:4200<br/>


### Running the application with executable JAR

The code can also be built into a jar and then executed/run.
Once the jar is built `application.jar` file will appear in the `{yourPathToFolder}/customer-creator/application/target` folder.
Run the jar by double clicking on it or by using the command provided.

```shell
$ cd {yourPathToFolder}/customer-creator/customer-front/
$ npm run build
$ cd ../application/
$ mvn clean package
$ java -jar target/application.jar
```

Application will start on http://localhost:8080/


### Accessing API documentation

http://localhost:8080/swagger-ui.html


## Author

Copyright&copy; 2022, JurgitaVisa
