package com.vmind.virtual_assistants.openai.service;

import com.vmind.virtual_assistants.chat.application.api.ChatSettings;
import com.vmind.virtual_assistants.chat.application.api.OpenaiTTSSettings;
import org.springframework.ai.chat.model.ChatResponse;

public interface OpenaiService {
    ChatResponse callChatModel(ChatSettings request);
    byte[] textToSpeech(String input, OpenaiTTSSettings request);
}
