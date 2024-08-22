package com.vmind.virtual_assistants.elevenlabs.application.api;

import com.vmind.virtual_assistants.elevenlabs.application.service.ElevenLabsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class ElevenLabsController implements ElevenLabsAPI {
    private final ElevenLabsService elevenLabsService;

    @Override
    public byte[] textToSpeech(ElevenLabsTTSRequest request) {
        log.debug("[start] ElevenLabsController - textToSpeech");
        byte[] response = elevenLabsService.textToSpeech(request);
        log.debug("[finish] ElevenLabsController - textToSpeech");
        return response;
    }
}
