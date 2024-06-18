package com.vmind.personal_assistant.api;

import com.vmind.personal_assistant.service.OpenaiService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ai.chat.model.ChatResponse;

@Log4j2
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class OpenaiController implements OpenaiAPI {
    private final OpenaiService openaiService;

    @Override
    public ChatResponse getTechRecruiterAssistantResponse(TechRecruiterAssistantRequest assistantRequest) {
        log.info("[start] OpenaiController - getTechRecruiterAssistantResponse");
        ChatResponse response = openaiService.techRecruiterAssistantResponse(assistantRequest);
        log.info("[finish] OpenaiController - getTechRecruiterAssistantResponse");
        return response;
    }
}
