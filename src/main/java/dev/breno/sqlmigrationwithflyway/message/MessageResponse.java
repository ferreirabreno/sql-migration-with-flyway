package dev.breno.sqlmigrationwithflyway.message;

import java.time.LocalDateTime;

public record MessageResponse(String senderName, String receiverName, String message, LocalDateTime sendDate) {

    public static MessageResponse from(Message message) {
        return new MessageResponse(
                message.getSender().getName(),
                message.getReceiver().getName(),
                message.getMessage(),
                message.getSendDate()
        );
    }

}
