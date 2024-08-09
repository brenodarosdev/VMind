package com.vmind.virtual_assistants.chat.application.api;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assistants")
public interface ChatAPI {
    @PostMapping("/v1/new-voice-chat")
    NewVoiceChatResponse postNewVoiceChat(@RequestBody @Valid NewVoiceChatRequest voiceChatRequest);
}
