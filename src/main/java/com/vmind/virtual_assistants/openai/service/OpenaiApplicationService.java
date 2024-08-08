package com.vmind.virtual_assistants.openai.service;

import com.vmind.virtual_assistants.chat.api.OpenaiCallRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class OpenaiApplicationService implements OpenaiService {
    private final OpenAiChatModel openAiChatModel;

    @Override
    public ChatResponse callChatModel(OpenaiCallRequest request) {
        log.debug("[start] OpenaiApplicationService - callChatModel");
        ChatResponse response = openAiChatModel.call(new Prompt(request.getPrompt(), request.getSettings()));
        log.debug("[finish] OpenaiApplicationService - callChatModel");
        return response;
    }
}
