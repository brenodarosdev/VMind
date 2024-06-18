package com.vmind.personal_assistant.service;

import com.vmind.personal_assistant.api.TechRecruiterAssistantRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class OpenaiServiceApplication implements OpenaiService {
    @Override
    public ChatResponse techRecruiterAssistantResponse(TechRecruiterAssistantRequest assistantRequest) {
        log.info("[start] OpenaiServiceApplication - techRecruiterAssistantResponse");
        log.info("[finish] OpenaiServiceApplication - techRecruiterAssistantResponse");
        return null;
    }
}
