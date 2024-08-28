package com.vmind.virtual_assistants.chat.application.service;

import com.vmind.virtual_assistants.chat.application.api.ChatSettingsResponse;
import com.vmind.virtual_assistants.chat.application.api.NewChatResponse;
import com.vmind.virtual_assistants.chat.application.api.ChatRequest;

import java.util.UUID;

public interface ChatService {
    NewChatResponse newChat(ChatRequest voiceChatRequest);
    ChatSettingsResponse chatDetailsById(UUID idChat);
    void modifyChatSettings(ChatRequest chatRequest, UUID idChat);
    void deleteChat(UUID idChat);
}
