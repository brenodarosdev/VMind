package com.vmind.virtual_assistants.messages.application.api;

import com.vmind.virtual_assistants.messages.domain.ChatMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Messages")
@RequestMapping("/public/v1/messages")
public interface MessagesAPI {
    @GetMapping("/get-messages/{idMessages}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get list of messages from a chat by ID Messages")
    List<ChatMessage> getListMessagesById(@PathVariable UUID idMessages);

    @PostMapping("/new-message/{idMessages}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Sends new user message to Openai and saves Messages")
    ChatMessage postNewMessage(@PathVariable UUID idMessages, @RequestBody @Valid NewMessageRequest request);
}
