# Terraforming Mars Forum

This project is part of Terraforming Mars Forum Application which implements League Posts with League data coming from [Terraforming Mars Leagues](https://terraforming-mars-leagues.herokuapp.com/).

> [Terraforming Mars Leagues Github Repository](https://github.com/Zsezsu/terraforming-mars)

## Technologies

The project is the API part of Terraforming Mars Forum Application, which is built in Java Springboot. We use JPA, Hibernate, PostgreSQL, H2 for the database. We use **Spring MVC** architecture.

Tech stack:
- Java 17
- Springboot
- JPA
- Hibernate
- PostgreSQL
- H2
- Lombok
- JUnit 5
- Mockito

## Usage

Run the application through `src.main.java.com.codecool.terraformingmarsforum.TerraformingMarsForumApplication`.

To run the application, you need to configure environment variables to connect to PostgreSQL database:

- `PSQL_DB_NAME`: the name of your psql database
- `PSQL_USERNAME`: your psql username
- `PSQL_PASSWORD`: your psql password
