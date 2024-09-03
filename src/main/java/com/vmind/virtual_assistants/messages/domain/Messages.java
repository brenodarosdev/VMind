package com.vmind.virtual_assistants.messages.domain;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.ai.chat.messages.MessageType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Messages {
    @Id
    private UUID idMessages;
    @Column(unique = true)
    private UUID idChat;
    @NotNull
    @ElementCollection
    private List<ChatMessage> listChatMessages;

    public Messages(UUID idChat, List<ChatMessage> listChatMessages) {
        this.idMessages = UUID.randomUUID();
        this.idChat = idChat;
        this.listChatMessages = listChatMessages;
    }

    public void addMessage(String content, MessageType messageType) {
        this.listChatMessages.add(new ChatMessage(content, messageType));
    }

    public ChatMessage addMessage(String content, MessageType messageType, String finishReason) {
        ChatMessage chatMessage = new ChatMessage(content, messageType, finishReason);
        this.listChatMessages.add(chatMessage);
        return chatMessage;
    }

    public Optional<ChatMessage> findChatMessageById(UUID idChatMessage) {
        return listChatMessages.stream()
                .filter(message -> message.getId().equals(idChatMessage))
                .findFirst();
    }
}
