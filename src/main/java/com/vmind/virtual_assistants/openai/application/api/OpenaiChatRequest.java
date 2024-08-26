package com.vmind.virtual_assistants.openai.application.api;

import com.vmind.virtual_assistants.chat.application.api.ChatSettings;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class OpenaiChatRequest {
    @NotNull
    String userMessage;
    @Valid
    ChatSettings settings;
}
