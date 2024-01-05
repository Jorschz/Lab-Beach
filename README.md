# LabBeach

## REST API developed in JAVA SPRING as an evaluative project for the SENAI course.

## Prerequisites
- Java 8 or higher
- Maven
- Database (e.g., MySQL, PostgreSQL)
- Insomnia (json file in the folder)

## Configuration
- Clone the repository.
- Configure the database in the 'application.properties' file.
- Run the application using the file: 'LabbeachApplication'


## Endpoints

### To Read all neighborhoods/beaches
Send a GET request to localhost:server.port/bairro or localhost:server.port/praia

### To create a new neighborhood
Send a POST request with a Query containing name, description, and visitors

### To create a new beach
Send a POST request with name, inclusiveness, condition, and neighborhood

### To delete a neighborhood/beach
Send a DELETE request with the *id*

### To update a beach
Send a JSON in the request body with the values you want to change

### To read the beach by condition
Send a get request with /fcondition

### To read the beach by inclusiveness
Send a get request with /finclusiveness

### To read by visitors
Send a get request with fvisitors


