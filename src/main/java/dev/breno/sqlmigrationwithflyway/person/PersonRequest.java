package dev.breno.sqlmigrationwithflyway.person;

public record PersonRequest(String name, String cpf) {

    public Person toModel() {
        return new Person(name, cpf);
    }

}
