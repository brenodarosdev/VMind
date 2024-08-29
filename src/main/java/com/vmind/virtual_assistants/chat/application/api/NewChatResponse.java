package com.vmind.virtual_assistants.chat.application.api;

import com.vmind.virtual_assistants.messages.domain.ChatMessage;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
public class NewChatResponse {
    UUID idChat;
    UUID idMessage;
    List<ChatMessage> output;
}
