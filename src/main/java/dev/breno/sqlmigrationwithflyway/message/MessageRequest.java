package dev.breno.sqlmigrationwithflyway.message;

import dev.breno.sqlmigrationwithflyway.person.Person;
import dev.breno.sqlmigrationwithflyway.person.PersonRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

public record MessageRequest(
        @NotNull UUID senderId,
        @NotNull UUID receiverId,
        @NotBlank String message
) {

    public Message toModel(PersonRepository personRepository) {
        Person receiver = personRepository.findById(receiverId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Person sender = personRepository.findById(senderId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new Message(message, receiver, sender);
    }

}
