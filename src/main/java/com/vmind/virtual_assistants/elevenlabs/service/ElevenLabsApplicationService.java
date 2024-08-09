package com.vmind.virtual_assistants.elevenlabs.service;

import com.google.gson.Gson;
import com.vmind.virtual_assistants.chat.application.api.ElevenLabsTTSRequest;
import com.vmind.virtual_assistants.elevenlabs.infra.client.ElevenLabsClientFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class ElevenLabsApplicationService implements ElevenLabsService {
    private final ElevenLabsClientFeign elevenLabsClientFeign;

    @Value("${elevenlabs.xi-api-key}")
    private String apiKey;

    @Override
    public void textToSpeech(String content, ElevenLabsTTSRequest request) {
        log.debug("[start] ElevenLabsApplicationService - textToSpeech");
        String bodyJsonString = new Gson()
                .toJson(new ElevenLabsTTSRequestDTO(content, request));
        byte[] speech = elevenLabsClientFeign.textToSpeech(apiKey, request.getVoiceId(), bodyJsonString);
        log.debug("[finish] ElevenLabsApplicationService - textToSpeech");
    }
}
