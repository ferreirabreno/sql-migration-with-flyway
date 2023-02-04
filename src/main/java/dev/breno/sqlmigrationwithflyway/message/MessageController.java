package dev.breno.sqlmigrationwithflyway.message;

import dev.breno.sqlmigrationwithflyway.person.PersonRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.net.URI;
import java.util.UUID;

@RestController
public class MessageController {

    @Autowired MessageRepository messageRepository;
    @Autowired PersonRepository personRepository;

    @PostMapping("/message")
    public ResponseEntity<?> sendMessage(@RequestBody @Valid MessageRequest request) {
        Message message = request.toModel(personRepository);
        messageRepository.save(message);
        URI location = URI.create("/message/" + message.getId().toString());
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/message/{id}")
    public ResponseEntity<?> readMessage(@PathVariable UUID id) {
        Message message = messageRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        MessageResponse messageResponse = MessageResponse.from(message);
        return ResponseEntity.ok(messageResponse);
    }

}
