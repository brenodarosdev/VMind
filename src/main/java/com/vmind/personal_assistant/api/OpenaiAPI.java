package com.vmind.personal_assistant.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Openai")
@RestController
public interface OpenaiAPI {
    @GetMapping("/tech-recruiter")
    ChatResponse getTechRecruiterAssistantResponse(@Valid TechRecruiterAssistantRequest assistantRequest);
}
