# spring-data-rest
Spring Data Rest application

## Built With

* 	[Gradle](https://gradle.org/) - Dependency Management
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java Platform, Standard Edition Development Kit 
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
*   [MySQL 8](https://dev.mysql.com/doc/relnotes/mysql/8.0/en/) - MySQL Database Management System
* 	[git](https://git-scm.com/) - Free and Open-Source distributed version control system 

## External Tools Used

* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)

## To-Do

- [ ] Logger (Console, File, Mail)
- [x] RESTful Web Service (CRUD)
- [ ] Security (Basic Authentication)
- [ ] Docker
- [x] HATEOS
- [ ] Spring Boot Admin
- [x] MySQL


## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.sts.SpringDataRestApplication` class from your IDE.

- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing build.gradle
- Open Eclipse 
   - File -> Import -> Existing Gradle Project -> Navigate to the folder where you unzipped the zip
   - Select the project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application

### Application URL

To monitor and manage your application

|  URL 																				|  Method |
|-----------------------------------------------------------------------------------|---------|
|`http://localhost:8080/portal`  													| GET |
|`http://localhost:8080/portal/countries/`             							| GET |
|`http://localhost:8080/portal/states?projection=customState`      		| GET |
|`http://localhost:8080/portal/countries/1`    									| GET |
|`http://localhost:8080/portal/countries/1?projection=customCountry`    	| GET |
|`http://localhost:8080/portal/countries/search/findByName?name=India`	| GET |
|`http://localhost:8080/portal/profile` 											| GET |


### Actuator

To monitor and manage your application

|  URL |  Method |
|----------|--------------|
|`http://localhost:8080/portal`  						| GET |
|`http://localhost:8080/portal/actuator/`             | GET |
|`http://localhost:8080/portal/actuator/health`    	| GET |
|`http://localhost:8080/portal/actuator/info`      	| GET |


## Documentation

* [Swagger](http://localhost:8080/portal/swagger-ui.html) - `http://localhost:8080/portal/swagger-ui.html`- Documentation & Testing


## packages

- `entity` - to hold our entities;
- `repository`- to communicate with the database;
- `resources/` - Contains all the static resources, templates and property files.
- `resources/static` - contains static resources such as css, js and images.
- `resources/templates` - contains server-side templates which are rendered by Spring.
- `resources/application.yml` - It contains application-wide properties. Spring reads the properties defined in this file to configure your application. You can define server's default port, server's context path, database URLs etc, in this file.
- `test/` - contains unit and integration tests
- `build.gradle` - contains all the project dependencies
 

