package com.vmind.virtual_assistants.chat.application.service;

import com.vmind.virtual_assistants.chat.application.api.NewVoiceChatRequest;
import com.vmind.virtual_assistants.chat.application.api.NewVoiceChatResponse;

public interface ChatService {
    NewVoiceChatResponse newVoiceChat(NewVoiceChatRequest voiceChatRequest);
}
