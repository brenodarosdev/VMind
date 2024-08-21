package com.vmind.virtual_assistants.chat.application.service;

import com.vmind.virtual_assistants.chat.application.api.NewChatResponse;
import com.vmind.virtual_assistants.chat.application.api.NewChatRequest;

public interface ChatService {
    NewChatResponse newChat(NewChatRequest voiceChatRequest);
}
