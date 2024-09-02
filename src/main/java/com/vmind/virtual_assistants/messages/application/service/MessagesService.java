package com.vmind.virtual_assistants.messages.application.service;

import com.vmind.virtual_assistants.messages.application.api.NewMessageRequest;
import com.vmind.virtual_assistants.messages.domain.ChatMessage;

import java.util.List;
import java.util.UUID;

public interface MessagesService {
    List<ChatMessage> listMessagesById(UUID idMessages);
    void deleteMessagesById(UUID idMessages);
    ChatMessage newMessage(UUID idMessages, NewMessageRequest request);
    List<ChatMessage> modifyChatMessage(UUID idMessages, UUID idChatMessage, NewMessageRequest request);
    void deleteChatMessagesById(UUID idMessages);
}
