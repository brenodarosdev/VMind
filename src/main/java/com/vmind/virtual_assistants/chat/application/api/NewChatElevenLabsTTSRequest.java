package com.vmind.virtual_assistants.chat.application.api;

import jakarta.validation.Valid;
import lombok.Value;

@Value
public class NewChatElevenLabsTTSRequest implements NewChatRequest {
    @Valid
    OpenaiCallRequest openaiCallRequest;
    @Valid
    ElevenLabsTTSRequest elevenLabsTTSRequest;
}
