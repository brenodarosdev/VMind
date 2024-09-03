package com.vmind.virtual_assistants.openai.application.api;

import com.vmind.virtual_assistants.chat.application.api.ChatSettings;
import com.vmind.virtual_assistants.messages.domain.ChatMessage;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.List;

@Value
public class OpenAIChatRequest {
    @NotNull
    List<ChatMessage> messages;
    @Valid
    @NotNull
    ChatSettings settings;

    public OpenAIChatRequest(List<ChatMessage> messages, ChatSettings settings) {
        this.messages = messages;
        this.settings = settings;
    }
}
