package com.vmind.personal_assistant.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Openai")
@RequestMapping("/assistants")
public interface OpenaiAPI {
    @GetMapping("/tech-recruiter")
    ChatResponse getTechRecruiterAssistantResponse(@Valid TechRecruiterAssistantRequest assistantRequest);
}
