package dev.breno.sqlmigrationwithflyway.message;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Person {

    @Id private final UUID id = UUID.randomUUID();
    private String name;
    private String cpf;

}
