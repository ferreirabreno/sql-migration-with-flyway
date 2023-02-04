# Using flyway migration with a postgresql database

## What is flyway migration?

Flyway is an open-source database migration tool that helps manage changes to a database schema. It allows for version control of database schemas and makes it easy to migrate between versions. The tool supports SQL-based migrations and can be integrated into various build and deployment processes. The goal of Flyway is to make it easy to keep track of changes to the database schema and to ensure that all instances of the database have the same schema.

## Configuring Flyway Migration step-by-step

1. Add the Flyway Gradle plugin to your build.gradle file:
```groovy
plugins {
  id 'org.flywaydb.flyway' version '9.8.1'
}
```

2. Configure the Flyway Gradle plugin by adding the following to your build.gradle file:
```groovy
flyway {
    url = 'jdbc:postgresql://localhost:5432/sql_migration_poc'
    user = 'postgresql'
    password = 'postgresql'
}
```

3. Create a SQL script file for each change you want to make to your database. Each file should be named in the format `V{version}__{description}.sql`. The version number should be incremented with each new change and the description should be a brief summary of the change.
```text
V1.0.0__Schema.sql
V1.0.1__Adds_new_attribute_date.sql
```

4. Place the SQL script files in the `src/main/resources/db/migration` directory.

5. Run the flywayMigrate task to apply the migrations to the database:
```shell
./gradlew flywayMigrate
```

## Configuring Postgresql step-by-step

1. Add the PostgreSQL JDBC driver to your project's dependencies in build.gradle file:
```groovy
dependencies {
  implementation 'org.postgresql:postgresql:42.2.17'
}
```

2. Configure the connection properties for your database in a properties file, for example, `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/sql_migration_poc
spring.datasource.username=postgresql
spring.datasource.password=postgresql
spring.datasource.driver-class-name=org.postgresql.Driver
```

# TO DO

- [x] Include Postgresql dependency
- [x] Include Flyway Migration dependency
- [x] Configure environment variables for Postgresql in application.properties
- [x] Configure environment variables for Flyway Migration in application.properties
- [x] Create docker-compose.yml with Postgresql service
- [ ] Create Schema for db
- [ ] Create model in application
- [ ] Update model in application with Flyway Migration