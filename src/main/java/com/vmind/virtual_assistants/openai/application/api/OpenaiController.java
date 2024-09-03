package com.vmind.virtual_assistants.openai.application.api;

import com.vmind.virtual_assistants.openai.application.service.OpenaiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.openai.audio.transcription.AudioTranscriptionResponse;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class OpenaiController implements OpenaiAPI {
    private final OpenaiService openaiService;

    @Override
    public ChatResponse callChatModel(OpenaiChatRequest request) {
        log.debug("[start] OpenaiController - callChatModel");
        ChatResponse response = openaiService.callChatModel(request);
        log.debug("[finish] OpenaiController - callChatModel");
        return response;
    }

    @Override
    public byte[] textToSpeech(OpenaiTTSRequest request) {
        log.debug("[start] OpenaiController - textToSpeech");
        byte[] response = openaiService.textToSpeech(request);
        log.debug("[finish] OpenaiController - textToSpeech");
        return response;
    }

    @Override
    public AudioTranscriptionResponse callTranscriptionModel(OpenaiTranscriptionRequest request) {
        log.debug("[start] OpenaiController - callTranscriptionModel");
        AudioTranscriptionResponse response = openaiService.callTranscriptionModel(request);
        log.debug("[finish] OpenaiController - callTranscriptionModel");
        return response;
    }
}
