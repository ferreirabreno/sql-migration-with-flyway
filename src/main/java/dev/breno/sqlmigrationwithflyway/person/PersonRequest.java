package dev.breno.sqlmigrationwithflyway.person;

import jakarta.validation.constraints.NotBlank;

public record PersonRequest(
        @NotBlank String name,
        @NotBlank String cpf
) {

    public Person toModel() {
        return new Person(name, cpf);
    }

}
