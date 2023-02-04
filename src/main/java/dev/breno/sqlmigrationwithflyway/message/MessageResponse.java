package dev.breno.sqlmigrationwithflyway.message;

public record MessageResponse(String senderName, String receiverName, String message) {

    public static MessageResponse from(Message message) {
        return new MessageResponse(
                message.getSender().getName(),
                message.getReceiver().getName(),
                message.getMessage()
        );
    }
}
