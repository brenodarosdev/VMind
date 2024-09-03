package com.vmind.virtual_assistants.openai.application.api;

import com.vmind.virtual_assistants.openai.application.service.OpenAIService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class OpenAIController implements OpenAIAPI {
    private final OpenAIService openaiService;

    @Override
    public ChatResponse callChatModel(OpenAIChatRequest request) {
        log.debug("[start] OpenaiController - callChatModel");
        ChatResponse response = openaiService.callChatModel(request);
        log.debug("[finish] OpenaiController - callChatModel");
        return response;
    }

    @Override
    public byte[] textToSpeech(OpenAITTSRequest request) {
        log.debug("[start] OpenaiController - textToSpeech");
        byte[] response = openaiService.textToSpeech(request);
        log.debug("[finish] OpenaiController - textToSpeech");
        return response;
    }

    @Override
    public String callTranscriptionModel(OpenAITranscriptionRequest request) {
        log.debug("[start] OpenaiController - callTranscriptionModel");
        String response = openaiService.callTranscriptionModel(request);
        log.debug("[finish] OpenaiController - callTranscriptionModel");
        return response;
    }
}
