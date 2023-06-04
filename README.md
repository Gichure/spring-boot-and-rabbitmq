# Spring Boot and RabbitMQ
This sample demonstrates messaging using RabbitMQ.

## Setting Up
-  Ensure RabbitMQ is running. You can run a docker image
- Clone this repository
- cd to the root folder for the project
- Run the command mvn clean spring-boot:run

```

docker run -d --name rabbitmq-on-docker -p 5672:5672 rabbitmq
cd working_directory
git clone https://gitlab.com/pgichure/spring-boot-and-rabbitmq.git
cd spring-boot-and-rabbitmq
mvn clean spring-boot:run
```
