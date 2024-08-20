package com.vmind.virtual_assistants.chat.application.api;

import jakarta.validation.Valid;
import lombok.Value;

@Value
public class NewChatOpenaiTTSRequest implements NewChatRequest {
    @Valid
    OpenaiCallRequest openaiCallRequest;
    @Valid
    OpenaiTTSRequest openaiTTSRequest;
}
