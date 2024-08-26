package com.vmind.virtual_assistants.openai.application.api;

import com.vmind.virtual_assistants.openai.application.service.OpenaiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class OpenaiController implements OpenaiAPI {
    private final OpenaiService openaiService;

    @Override
    public void callChat(OpenaiChatRequest request) {
        log.debug("[start] OpenaiController - callChat");
        log.debug("[finish] OpenaiController - callChat");
    }

    @Override
    public byte[] textToSpeech(OpenaiTTSRequest request) {
        log.debug("[start] OpenaiController - textToSpeech");
        byte[] response = openaiService.textToSpeech(request);
        log.debug("[finish] OpenaiController - textToSpeech");
        return response;
    }
}
