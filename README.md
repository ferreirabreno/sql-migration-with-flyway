# Using flyway migration with a postgresql database

## What is flyway migration?

Flyway is an open-source database migration tool that helps manage changes to a database schema. It allows for version control of database schemas and makes it easy to migrate between versions. The tool supports SQL-based migrations and can be integrated into various build and deployment processes. The goal of Flyway is to make it easy to keep track of changes to the database schema and to ensure that all instances of the database have the same schema.

## Configuring Flyway Migration step-by-step


1. Add the Flyway and Spring Data JPA dependencies to your build.gradle file:
```groovy
dependencies {
    implementation 'org.postgresql:postgresql:42.2.17'
    implementation 'org.flywaydb:flyway-core'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
}
```

2. Create a SQL script file for each change you want to make to your database. Each file should be named in the format `V{version}__{description}.sql`. The version number should be incremented with each new change and the description should be a brief summary of the change.
```text
V1.0.0__Schema.sql
V1.0.1__Adds_new_attribute_date.sql
```

3. Place the SQL script files in the `src/main/resources/db/migration` directory.

4. Configure the connection properties for your database in a properties file, for example, `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/sql_migration_poc
spring.datasource.username=postgresql
spring.datasource.password=postgresql
spring.datasource.driver-class-name=org.postgresql.Driver
```

5. Run the application to apply the migrations to the database:
```shell
./gradlew bootRun
```

# TO DO

- [x] Include Postgresql dependency
- [x] Include Flyway Migration dependency
- [x] Configure environment variables for Postgresql in application.properties
- [x] Configure environment variables for Flyway Migration in application.properties
- [x] Create docker-compose.yml with Postgresql service
- [x] Create Schema for db
- [x] Create model in application
- [x] Update model in application with Flyway Migration