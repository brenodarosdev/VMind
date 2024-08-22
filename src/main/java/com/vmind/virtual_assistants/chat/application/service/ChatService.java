package com.vmind.virtual_assistants.chat.application.service;

import com.vmind.virtual_assistants.chat.application.api.ChatDetailsResponse;
import com.vmind.virtual_assistants.chat.application.api.NewChatResponse;
import com.vmind.virtual_assistants.chat.application.api.ChatRequest;

import java.util.UUID;

public interface ChatService {
    NewChatResponse newChat(ChatRequest voiceChatRequest);
    ChatDetailsResponse chatById(UUID idChat);
}
