package com.vmind.virtual_assistants.messages.application.api;

import com.vmind.virtual_assistants.messages.application.domain.ChatMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    List<ChatMessage> getMessagesById(@PathVariable UUID idMessages);
}
