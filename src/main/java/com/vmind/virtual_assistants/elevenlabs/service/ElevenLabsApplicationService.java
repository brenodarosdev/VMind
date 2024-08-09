package com.vmind.virtual_assistants.elevenlabs.service;

import com.vmind.virtual_assistants.chat.application.api.ElevenLabsTTSRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ElevenLabsApplicationService implements ElevenLabsService {
    @Override
    public void textToSpeech(String content, ElevenLabsTTSRequest request) {
        log.debug("[start] ElevenLabsApplicationService - textToSpeech");
        log.debug("[finish] ElevenLabsApplicationService - textToSpeech");
    }
}
