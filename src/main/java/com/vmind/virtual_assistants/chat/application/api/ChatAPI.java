package com.vmind.virtual_assistants.chat.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Chat")
@RequestMapping("/public/v1/assistants")
public interface ChatAPI {
    @PostMapping("/new-chat")
    @Operation(summary = "Save a new chat")
    ChatIdResponse postNewChat(@RequestBody @Valid NewChatRequest voiceChatRequest);
}
