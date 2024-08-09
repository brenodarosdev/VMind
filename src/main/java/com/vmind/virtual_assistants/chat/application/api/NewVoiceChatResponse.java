package com.vmind.virtual_assistants.chat.application.api;

import lombok.Value;

import java.util.Map;
import java.util.UUID;

@Value
public class NewVoiceChatResponse {
    UUID id;
    Map<String, Object> metadata;
    String content;

    public NewVoiceChatResponse(Map<String, Object> metadata, String content) {
        this.id = UUID.randomUUID();
        this.metadata = metadata;
        this.content = content;
    }
}
