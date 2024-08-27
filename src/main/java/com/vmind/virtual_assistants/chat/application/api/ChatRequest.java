package com.vmind.virtual_assistants.chat.application.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class ChatRequest {
    @Valid
    @NotNull
    ChatSettings chatSettings;
    @Valid
    @NotNull
    OpenaiTTSSettings openaiTTSSettings;
    @Valid
    @NotNull
    ElevenLabsTTSSettings elevenLabsTTSSettings;
}
