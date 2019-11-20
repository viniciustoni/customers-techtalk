# customers-techtalk

Simple example that will be used to show about spring data with specifications and QueryDSL

## Technology

- Spring-boot
- Spring-data
- QueryDsl
- Swagger
- MapStruct
- Lombok
- Maven

## Pre-Steps database

As a pre-step we will need to install the database that we are going to use for this example. 
As a suggestion you can use the docker-compose file, present inside **dbscript** folder to start you local database and use for this example. 
The database that we are using is PostgreSql.

### Start the docker container

First of all we need to start our docker container with postgress.

```
$ cd $CODE_HOME\dbscript
```

```
$ docker-compose up -d
```

### Create our database and adding a sample data

After your container is up, execute these commands.

- Connect to database:

```
$ docker-compose run db psql -h my_local_postgres -U postgres
```

As password use the one that is configured on docker-compose file, that should be: **postgres00**.

- Create new database customer:

```
create user customer password 'customer';
create database customer owner customer ENCODING 'UTF8';
```

- Connect with new database and create the tables:

```
docker-compose run db psql -h my_local_postgres -U customer
```

As a password you you need to insert the one that you used to create the database, as our example should be **customer**.

- Create all tables

Execute the create scripts table present inside *$CODE_HOME\dbscript\CustomerDbSession.sql* on this file contains all tables and some sample data.

## Example

This example has as goal to show/test how to use Spring-Data with specification and QueryDsl, we will have other example only for comparison, for example:

- **CountryDaoImpl.java**: Used to show how to create a query based on JPA/Hibernate language(JPQL/HQL);
- **CountryRepository.java**: On this class contains one example how to create one query based only on spring data method name;
- **AddressService.java**: On this class there is one example to how to use JPA Specification without use QueryDsl;
- **specifications package**: On this package contains some examples of how to create our queries based on QueryDsl framework;
- **ClientRest.java**: Rest controller to show an example of client search using QueryDsl;

### Execute and test it

To execute this sample you will need to:

- Clone it;
- Execute pre-steps;
- Compile the project: mvn clean install
- Start the application, it'll run on port number: *8081*;
- You can access the swagger page via: **http://localhost:8081/swagger-ui.html**;
  

 