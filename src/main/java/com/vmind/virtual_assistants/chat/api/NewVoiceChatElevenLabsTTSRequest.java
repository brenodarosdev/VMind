package com.vmind.virtual_assistants.chat.api;

import jakarta.validation.Valid;
import lombok.Value;

@Value
public class NewVoiceChatElevenLabsTTSRequest implements NewVoiceChatRequest {
    @Valid
    OpenaiCallRequest openaiCallRequest;
    @Valid
    ElevenLabsTTSRequest elevenLabsTTSRequest;
}
