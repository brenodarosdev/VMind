package com.vmind.personal_assistant.service;

import com.vmind.personal_assistant.api.TechRecruiterAssistantRequest;
import org.springframework.ai.chat.model.ChatResponse;

public interface OpenaiService {
    ChatResponse techRecruiterAssistantResponse(TechRecruiterAssistantRequest assistantRequest);
}
