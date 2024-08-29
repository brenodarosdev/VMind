package com.vmind.virtual_assistants.messages.application.service;

import com.vmind.virtual_assistants.messages.application.domain.ChatMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class MessagesApplicationService implements MessagesService {
    @Override
    public List<ChatMessage> messagesById(UUID idMessages) {
        log.debug("[start] MessagesApplicationService - messagesById");
        log.debug("[finish] MessagesApplicationService - messagesById");
        return null;
    }
}
