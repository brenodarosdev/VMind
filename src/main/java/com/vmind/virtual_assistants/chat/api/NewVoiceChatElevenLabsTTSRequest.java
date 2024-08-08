package com.vmind.virtual_assistants.chat.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class NewVoiceChatElevenLabsTTSRequest implements NewVoiceChatRequest {
    @Valid
    OpenaiCallRequest openaiCallRequest;
    @Valid
    ElevenLabsTTSRequest elevenLabsTTSRequest;
}
