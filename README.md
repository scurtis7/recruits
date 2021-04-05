![Build & Test](https://github.com/scurtis7/recruits/workflows/Build%20&%20Test/badge.svg)

# Recruits

This application is my personal project to keep track of college football recruits and players.  This is a spring boot
angular application using a postgresql database.

## Version 0.8.0
Add `year` & `position` drop downs to the player list

## Version 0.7.0
Upgrade to JDK 11

## Version 0.6.0
Add scraper functionality

## Version 0.5.0
Add Change Password functionality

## Version 0.4.0
Add About information.

## Version 0.3.0
Add Sign out functionality.

## Version 0.2.0
Add Readme and the ability to choose a college preference when creating a user.

## Version 0.1.0
This is the initial version with Spring Boot and Angular working together.  With this version you can create a user
and login with that user.

## Technologies
- Spring Boot - `v2.4.0`
- Java - `v11`
- Angular - `v11.0.0`
- Postgresql - `v12.2`
- Gradle - `v6.7.1`
- Flyway

## How to run locally
I use a Mac and IntelliJ IDEA so these instructions are for that setup.
After you clone the repository then follow the steps below.

### Start Postgresql DB locally or in a docker container
First step is to start the Postgresql database locally or in a docker container.  To start in a docker container run
the following command and of course replace the `<password>` with your own:

`docker run --name fsuroster -e POSTGRES_PASSWORD=<password> -d -p 5432:5432 postgres`

### Build the Angular application
To build the Angular application follow the following steps:
- open a terminal
- navigate to `recruits/src/webapp`
- run the following command only if the first time `npm install`
- run the following command `npm run build`

### Build the spring boot application
Next build the Spring Boot application with these steps:
- open a terminal
- navigate to `recruits/`
- run the following command `./gradlew clean build`

### Start the application
Building the angular application and the spring boot application above is basically to make sure everything builds 
correctly, because the command below will build everything, generate a bootJar and then run it.

First you will need to create a file called `application-dev.yml` in the `src/main/resources` folder.  It needs to 
contain something like the following.  The important parts are the spring configuration values.  Replace `<password>` 
with your password.

```
# application properties

server:
  port: 8080

logging:
  level:
    root: INFO
    com:
      scurtis: TRACE

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/postgres
    username: postgres
    password: <password>
  r2dbc:
    url: r2dbc:postgresql://localhost:5432/postgres
    username: postgres
    password: <password>
```

- In the terminal from the root folder (recruits) you run the following command:

`SPRING_PROFILES_ACTIVE=dev gradle build bootRun`

- navigate to [http://localhost:8080](http://localhost:8080)

**NOTE:** You can also build and run the application from IntelliJ
