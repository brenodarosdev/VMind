package com.vmind.virtual_assistants.chat.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Tag(name = "Chat")
@RequestMapping("/public/v1/chat")
public interface ChatAPI {
    @PostMapping("/new-chat")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Save a new Chat")
    NewChatResponse postNewChat(@RequestBody @Valid ChatRequest chatRequest);

    @GetMapping("/find-chat/{idChat}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Find Chat by ID")
    ChatDetailsResponse getChatDitailsById(@PathVariable UUID idChat);
}
