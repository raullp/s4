# S4 (Super Simple Scheduling System)

## Requirements
  * Java 8
  * Maven

## Build & Run
Please execute bellow command to build and execute the S4 application. It runs in port 8080 by default.
 mvn spring-boot:run

With a Rest Client of your preference go to http://localhost:8080/v1/api

## HAL Actuactor-ui browser
This is a [web client](http://http://localhost:8080/actuator/#http://localhost:8080/v1/api/) to browse HAL resources.
## Some usage samples:

### Create a Student
curl -i -X POST -H "Content-Type:application/json" -d $'{"firstName": "Frodo", "lastName": "Baggings"}' http://localhost:8080/v1/api/students

### Create a Class
curl -i -X POST -H "Content-Type:application/json" -d $'{"code": "angular-2-on-code-school", "title": "Angular 2 on Code School", "description": "Learn Angular 2 with video lessons and coding challenges."}' http://localhost:8080/v1/api/classes


## Register some students into a class
curl -i -X PUT -H "Content-Type:text/uri-list" -d $'http://localhost:8080/v1/api/students/1\nhttp://localhost:8080/v1/api/students/2' http://localhost:8080/v1/api/classes/1/students

### List registered students for class
curl http://localhost:8080/v1/api/classes/1/students

### List registered classes for a student
curl http://localhost:8080/v1/api/students/1/classes

## Unregister an student from a class
curl -i -X DELETE http://localhost:8080/v1/api/classes/1/students2

# Searching APIs
## Searching APIs for Classes resource:
### Search classes
curl http://localhost:8080/v1/api/classes/search/search?pattern=zombies

### Search classes by its code
curl http://localhost:8080/v1/api/classes/search/findByCode?code=angular

### Search classes by title
curl http://localhost:8080/v1/api/classes/search/findByTitle?title=angular

### Search classes by description
curl http://localhost:8080/v1/api/classes/search/findByDescription?description=Learn

## Searching APIs for Students resource:
### Search students
curl http://localhost:8080/v1/api/students/search/search?query=Fett
curl http://localhost:8080/v1/api/students/search/search?query=walker

### Search students by its first name
curl http://localhost:8080/v1/api/students/search/findByFirstName?firstName=an

### Search students by Last Name
curl http://localhost:8080/v1/api/students/search/findByLastName?lastName=ett

