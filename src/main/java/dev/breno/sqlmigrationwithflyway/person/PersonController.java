package dev.breno.sqlmigrationwithflyway.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class PersonController {

    @Autowired PersonRepository personRepository;

    @PostMapping("/person")
    public ResponseEntity<?> createPerson(@RequestBody PersonRequest request) {
        Person person = personRepository.save(request.toModel());
        URI location = URI.create("/person/" + person.getId().toString());
        return ResponseEntity.created(location).build();
    }

}
