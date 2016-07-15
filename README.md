# S4 (Super Simple Scheduling System)
S4 microservice provides REST APIs for handling Students and Classes using the Hateoas standard, so it allow us to discover exposed services by browsing
root entry using the embedded [HAL browser](http://http://localhost:8080/actuator/#http://localhost:8080/v1/api/)

## Architecture
Uses Spring boot due to it allows to develop micro-services in quick time using its Code Configuration and its great compatibility with other spring projects such as spring-data. Spring boot's embedded container and flexible configuration help to scale.

Spring data-rest was chosen because it provides a HATEOAS REST services (CRUD, pagination, sorting and searching is easy to implement) enough to manage this project, also flexible to customize business logic, and provide APIs with a simplified view of resources using its *projection* feature.

Spring data-jpa as data access module already provides generic classes to manage the CRUD operations with paging and sorting capabilities.

Search operations usually takes time and impacts in the performance, would suggest to use a search engine like elasticsearch or solr (already manage indexing) and have a mechanism (Have a syncup Scheduler that reads from a table or handle rest data events and publish them to broker service) to sync up S4 database). There is a proof of concept in the 'elasticsearch' branch for this.

In Memory H2 database was chosen for this task, but could be changed for any other database manager such us mysql/postgreSQL changing the properties file and adding the jdbc handler dependency.

## Features to consider in the future
### Searching
Searching might be improved to be faster and with a flexible by a QUERY DSL using search engine like elasticsearch/solr.

/GET   http://localhost:8080/v1/api/students/search/{query}

Query samples:
 * Get active angular classes:  **Angular**
 * Get active students with Skywalker last name:  **lastName:Skwywalker&status:ACTIVE**


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
curl -i -X PUT -H "Content-Type:text/uri-list" -d $'http://localhost:8080/v1/api/students/1\\nhttp://localhost:8080/v1/api/students/2' http://localhost:8080/v1/api/classes/1/students

### List registered students for class
curl http://localhost:8080/v1/api/classes/1/students

### List registered classes for a student
curl http://localhost:8080/v1/api/students/1/classes

## Unregister an student from a class
curl -i -X DELETE http://localhost:8080/v1/api/classes/1/students2

### Minimal View projections
Register some students
curl -i -X PUT -H "Content-Type:text/uri-list" -d $'http://localhost:8080/v1/api/students/1\\nhttp://localhost:8080/v1/api/students/2\\nhttp://localhost:8080/v1/api/students/3\\nhttp://localhost:8080/v1/api/students/4' http://localhost:8080/v1/api/classes/2/students

### Review the projections with minimal data
curl http:://localhost:8080/v1/api/classes/2/students?projection=view
curl http:://localhost:8080/v1/api/classes/2?projection=view

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

