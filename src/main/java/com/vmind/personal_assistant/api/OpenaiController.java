package com.vmind.personal_assistant.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.ai.chat.model.ChatResponse;

@Log4j2
public class OpenaiController implements OpenaiAPI {
    @Override
    public ChatResponse getTechRecruiterAssistantResponse(TechRecruiterAssistantRequest assistantRequest) {
        log.info("[start] OpenaiController - getTechRecruiterAssistantResponse");
        log.info("[finish] OpenaiController - getTechRecruiterAssistantResponse");
        return null;
    }
}
