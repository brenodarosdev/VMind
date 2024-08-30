package com.vmind.virtual_assistants.messages.application.api;

import com.vmind.virtual_assistants.messages.domain.ChatMessage;
import lombok.Value;

@Value
public class AssistantResponse {
    String finishReason;
    ChatMessage assistantMessage;
}
