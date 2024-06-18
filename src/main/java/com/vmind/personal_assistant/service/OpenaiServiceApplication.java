package com.vmind.personal_assistant.service;

import com.vmind.personal_assistant.api.TechRecruiterAssistantRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class OpenaiServiceApplication implements OpenaiService {
    private final OpenAiChatModel chatModel;

    @Override
    public ChatResponse techRecruiterAssistantResponse(TechRecruiterAssistantRequest assistantRequest) {
        log.info("[start] OpenaiServiceApplication - techRecruiterAssistantResponse");
            ChatResponse response = chatModel.call(new Prompt(assistantRequest.getPrompt(), assistantRequest.getSettings()));
        log.info("[finish] OpenaiServiceApplication - techRecruiterAssistantResponse");
        return response;
    }
}
