package com.vmind.virtual_assistants.chat.service;

import com.vmind.virtual_assistants.chat.api.NewVoiceChatRequest;
import com.vmind.virtual_assistants.chat.api.NewVoiceChatResponse;

public interface ChatService {
    NewVoiceChatResponse newVoiceChat(NewVoiceChatRequest voiceChatRequest);
}
