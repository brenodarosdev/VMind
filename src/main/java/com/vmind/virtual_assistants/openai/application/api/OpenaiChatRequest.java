package com.vmind.virtual_assistants.openai.application.api;

import com.vmind.virtual_assistants.chat.application.api.ChatSettings;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class OpenaiChatRequest {
    @NotNull
    String userMessage;
    @Valid
    ChatSettings settings;

    public OpenaiChatRequest(ChatSettings settings) {
        this.userMessage = "";
        this.settings = settings;
    }

    public OpenaiChatRequest(String userMessage, ChatSettings settings) {
        this.userMessage = userMessage;
        this.settings = settings;
    }
}
