package com.vmind.virtual_assistants.messages.application.api;

import com.vmind.virtual_assistants.chat.application.api.ChatRequest;
import com.vmind.virtual_assistants.messages.domain.ChatMessage;
import com.vmind.virtual_assistants.messages.application.service.MessagesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Log4j2
@RestController
@RequiredArgsConstructor
public class MessagesController implements MessagesAPI {
    private final MessagesService messagesService;

    @Override
    public List<ChatMessage> getListMessagesById(UUID idMessages) {
        log.debug("[start] MessagesController - getListMessagesById");
        List<ChatMessage> messages = messagesService.listMessagesById(idMessages);
        log.debug("[finish] MessagesController - getListMessagesById");
        return messages;
    }

    @Override
    public ChatMessage postNewMessage(UUID idMessages, NewMessageRequest request) {
        log.debug("[start] MessagesController - postNewMessage");
        ChatMessage assistantMessage = messagesService.newMessage(idMessages, request);
        log.debug("[finish] MessagesController - postNewMessage");
        return assistantMessage;
    }
}
