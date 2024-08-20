package com.vmind.virtual_assistants.chat.application.service;

import com.vmind.virtual_assistants.chat.application.api.ChatIdResponse;
import com.vmind.virtual_assistants.chat.application.api.NewChatRequest;

public interface ChatService {
    ChatIdResponse newChat(NewChatRequest voiceChatRequest);
}
