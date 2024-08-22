package com.vmind.virtual_assistants.elevenlabs.application.service;

import com.google.gson.Gson;
import com.vmind.virtual_assistants.chat.application.api.ChatDetailsResponse;
import com.vmind.virtual_assistants.chat.application.service.ChatService;
import com.vmind.virtual_assistants.elevenlabs.application.api.TTSRequest;
import com.vmind.virtual_assistants.elevenlabs.infra.client.ElevenLabsClientFeign;
import com.vmind.virtual_assistants.exception.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class ElevenLabsApplicationService implements ElevenLabsService {
    private final ElevenLabsClientFeign elevenLabsClientFeign;
    private final ChatService chatService;

    @Value("${elevenlabs.xi-api-key}")
    private String apiKey;

    @Override
    public byte[] textToSpeech(TTSRequest request) {
        log.debug("[start] ElevenLabsApplicationService - textToSpeech");
        UUID idChat;
        try {
            idChat = UUID.fromString(request.getIdChat());
        } catch (IllegalArgumentException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        ChatDetailsResponse chatDetails = chatService.chatDetailsById(idChat);
        String bodyJsonString = new Gson()
                .toJson(new ElevenLabsTTSRequestDTO(request.getInput(), chatDetails.getElevenLabsTTSSettigs()));
        byte[] speech = elevenLabsClientFeign.textToSpeechStream(apiKey, chatDetails.getElevenLabsTTSSettigs().getVoiceId(), bodyJsonString);
        log.debug("[finish] ElevenLabsApplicationService - textToSpeech");
        return speech;
    }
}
