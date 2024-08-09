package com.vmind.virtual_assistants.openai.service;

import com.vmind.virtual_assistants.chat.application.api.OpenaiCallRequest;
import org.springframework.ai.chat.model.ChatResponse;

public interface OpenaiService {
    ChatResponse callChatModel(OpenaiCallRequest request);
}
