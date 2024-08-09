package com.vmind.virtual_assistants.chat.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import org.springframework.ai.openai.OpenAiChatOptions;

@Value
public class OpenaiCallRequest {
    @NotBlank
    String prompt;
    @NotNull
    OpenAiChatOptions settings;
}
