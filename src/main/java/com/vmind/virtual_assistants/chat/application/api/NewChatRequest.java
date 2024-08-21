package com.vmind.virtual_assistants.chat.application.api;

import jakarta.validation.Valid;
import lombok.Value;

@Value
public class NewChatRequest {
    @Valid
    ChatSettings chatSettings;
    @Valid
    OpenaiTTSSettings openaiTTSSettings;
    @Valid
    ElevenLabsTTSSettigs elevenLabsTTSSettigs;
}
