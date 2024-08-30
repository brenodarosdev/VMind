package com.vmind.virtual_assistants.messages.application.service;

import com.vmind.virtual_assistants.messages.domain.ChatMessage;
import com.vmind.virtual_assistants.messages.application.repository.MessagesRepository;
import com.vmind.virtual_assistants.messages.domain.Messages;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class MessagesApplicationService implements MessagesService {
    private final MessagesRepository messagesRepository;

    @Override
    public List<ChatMessage> listMessagesById(UUID idMessages) {
        log.debug("[start] MessagesApplicationService - listMessagesById");
        Messages messages = messagesRepository.listMessagesById(idMessages);
        log.debug("[finish] MessagesApplicationService - listMessagesById");
        return messages.getListChatMessages();
    }
}
