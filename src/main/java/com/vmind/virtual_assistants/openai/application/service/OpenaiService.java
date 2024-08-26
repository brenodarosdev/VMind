package com.vmind.virtual_assistants.openai.application.service;

import com.vmind.virtual_assistants.chat.application.api.ChatSettings;
import com.vmind.virtual_assistants.openai.application.api.OpenaiTTSRequest;
import org.springframework.ai.chat.model.ChatResponse;

public interface OpenaiService {
    ChatResponse callChatModel(ChatSettings request);
    byte[] textToSpeech(OpenaiTTSRequest request);
}
