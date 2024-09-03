package com.vmind.virtual_assistants.openai.application.service;

import com.vmind.virtual_assistants.openai.application.api.OpenAIChatRequest;
import com.vmind.virtual_assistants.openai.application.api.OpenAITTSRequest;
import com.vmind.virtual_assistants.openai.application.api.OpenAITranscriptionRequest;
import org.springframework.ai.chat.model.ChatResponse;

public interface OpenAIService {
    ChatResponse callChatModel(OpenAIChatRequest request);
    byte[] textToSpeech(OpenAITTSRequest request);
    String callTranscriptionModel(OpenAITranscriptionRequest request);
}
