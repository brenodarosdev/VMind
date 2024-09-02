package com.vmind.virtual_assistants.messages.application.service;

import com.vmind.virtual_assistants.messages.application.api.AssistantResponse;
import com.vmind.virtual_assistants.messages.application.api.NewMessageRequest;
import com.vmind.virtual_assistants.messages.domain.ChatMessage;

import java.util.List;
import java.util.UUID;

public interface MessagesService {
    List<ChatMessage> listMessagesById(UUID idMessages);
    AssistantResponse newMessage(UUID idMessages, NewMessageRequest request);
    List<ChatMessage> modifyChatMessage(UUID idMessages, UUID idChatMessage, NewMessageRequest request);
}
