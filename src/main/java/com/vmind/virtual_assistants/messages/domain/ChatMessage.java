package com.vmind.virtual_assistants.messages.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.ai.chat.messages.Media;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.MessageType;

import java.util.*;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChatMessage implements Message {
    private MessageType messageType;
    @Column(length = Integer.MAX_VALUE)
    private String content;
    @JsonIgnore
    private UUID id;
    @JsonIgnore
    private String finishReason;

    public ChatMessage(String content, MessageType messageType) {
        this.id = UUID.randomUUID();
        this.content = content;
        this.messageType = messageType;
    }

    public ChatMessage(String content, MessageType messageType, String finishReason) {
        this.id = UUID.randomUUID();
        this.content = content;
        this.messageType = messageType;
        this.finishReason = finishReason;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public MessageType getMessageType() {
        return this.messageType;
    }

    @Override
    public Map<String, Object> getMetadata() {
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("id", this.id);
        metadata.put("finishReason", this.finishReason);
        return metadata;
    }

    @Override
    public List<Media> getMedia() {
        return Collections.emptyList();
    }

    @Override
    @SuppressWarnings("removal")
    public List<Media> getMedia(String... dummy) {
        return getMedia();
    }
}
