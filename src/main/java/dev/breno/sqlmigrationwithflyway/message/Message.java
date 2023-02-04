package dev.breno.sqlmigrationwithflyway.message;

import dev.breno.sqlmigrationwithflyway.person.Person;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Message {

    @Id private final UUID id = UUID.randomUUID();
    private final String message;
    @ManyToOne(cascade = CascadeType.ALL) private final Person receiver;
    @ManyToOne(cascade = CascadeType.ALL) private final Person sender;
    private final LocalDateTime sendDate = LocalDateTime.now();
    private LocalDateTime readDate;

    @Deprecated
    private Message() {
        this.message = "";
        this.receiver = null;
        this.sender = null;
    }

    public Message(String message, Person receiver, Person sender) {
        this.message = message;
        this.receiver = receiver;
        this.sender = sender;
    }

    public UUID getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Person getReceiver() {
        return receiver;
    }

    public Person getSender() {
        return sender;
    }

    public LocalDateTime getSendDate() {
        return sendDate;
    }

    public LocalDateTime getReadDate() {
        return readDate;
    }

    public Message readMessage() {
        this.readDate = LocalDateTime.now();
        return this;
    }

}
