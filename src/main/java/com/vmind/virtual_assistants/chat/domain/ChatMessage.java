package com.vmind.virtual_assistants.chat.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.ai.chat.messages.Media;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.MessageType;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class ChatMessage implements Message {

    @Column(length = Integer.MAX_VALUE)
    private final String content;
    private final MessageType messageType;

    public ChatMessage(String content, MessageType messageType) {
        this.content = content;
        this.messageType = messageType;
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
        return Collections.emptyMap();
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
