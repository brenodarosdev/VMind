package com.vmind.virtual_assistants.elevenlabs.application.service;

import com.google.gson.Gson;
import com.vmind.virtual_assistants.elevenlabs.application.api.ElevenLabsTTSRequest;
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
    public byte[] textToSpeech(ElevenLabsTTSRequest request) {
        log.debug("[start] ElevenLabsApplicationService - textToSpeech");
        String bodyJsonString = new Gson()
                .toJson(new ElevenLabsTTSRequestDTO(request.getInput(), "eleven_turbo_v2_5", request.getSettings()));
        byte[] speech = elevenLabsClientFeign.textToSpeechStream(apiKey, request.getSettings().getVoiceId(), bodyJsonString);
        log.debug("[finish] ElevenLabsApplicationService - textToSpeech");
        return speech;
    }
}
