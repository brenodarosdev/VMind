package com.vmind.virtual_assistants.chat.application.api;

import jakarta.validation.Valid;
import lombok.Value;

@Value
public class NewVoiceChatOpenaiTTSRequest implements NewVoiceChatRequest {
    @Valid
    OpenaiCallRequest openaiCallRequest;
    @Valid
    OpenaiTTSRequest openaiTTSRequest;
}
