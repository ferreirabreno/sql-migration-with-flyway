package dev.breno.sqlmigrationwithflyway.person;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Person {

    @Id private final UUID id = UUID.randomUUID();
    private final String name;
    private final String cpf;

    @Deprecated
    private Person() {
        this.cpf = "";
        this.name = "";
    }

    public Person(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

}
