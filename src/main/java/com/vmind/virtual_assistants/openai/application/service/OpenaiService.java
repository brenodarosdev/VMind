package com.vmind.virtual_assistants.openai.application.service;

import com.vmind.virtual_assistants.openai.application.api.OpenaiChatRequest;
import com.vmind.virtual_assistants.openai.application.api.OpenaiTTSRequest;
import org.springframework.ai.chat.model.ChatResponse;

public interface OpenaiService {
    ChatResponse callChatModel(OpenaiChatRequest request);
    byte[] textToSpeech(OpenaiTTSRequest request);
}
