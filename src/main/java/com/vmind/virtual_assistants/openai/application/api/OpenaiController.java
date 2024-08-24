package com.vmind.virtual_assistants.openai.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class OpenaiController implements OpenaiAPI {
    @Override
    public byte[] textToSpeech(OpenaiTTSRequest request) {
        log.debug("[start] OpenaiController - textToSpeech");
        log.debug("[finish] OpenaiController - textToSpeech");
        return null;
    }
}
