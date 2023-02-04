package dev.breno.sqlmigrationwithflyway.message;

import dev.breno.sqlmigrationwithflyway.person.Person;
import dev.breno.sqlmigrationwithflyway.person.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;

public record MessageRequest(
        UUID senderId,
        UUID receiverId,
        String message
) {

    public Message toModel(PersonRepository personRepository) {
        Person receiver = personRepository.findById(receiverId).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        Person sender = personRepository.findById(senderId).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        return new Message(message, receiver, sender);
    }

}
