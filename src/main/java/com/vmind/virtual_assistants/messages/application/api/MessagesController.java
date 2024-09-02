package com.vmind.virtual_assistants.messages.application.api;

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
    public AssistantResponse postNewMessage(UUID idMessages, NewMessageRequest request) {
        log.debug("[start] MessagesController - postNewMessage");
        AssistantResponse response = messagesService.newMessage(idMessages, request);
        log.debug("[finish] MessagesController - postNewMessage");
        return response;
    }

    @Override
    public List<ChatMessage> patchModifyChatMessage(UUID idMessages, UUID idChatMessage, NewMessageRequest request) {
        log.debug("[start] MessagesController - patchModifyChatMessage");
        List<ChatMessage> messages = messagesService.modifyChatMessage(idMessages, idChatMessage, request);
        log.debug("[finish] MessagesController - patchModifyChatMessage");
        return messages;
    }
}
