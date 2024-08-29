package com.vmind.virtual_assistants.messages.infra;

import com.vmind.virtual_assistants.messages.domain.ChatMessage;
import com.vmind.virtual_assistants.messages.application.repository.MessagesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Log4j2
@Repository
@RequiredArgsConstructor
public class MessagesInfraRepository implements MessagesRepository {
    @Override
    public List<ChatMessage> messagesById(UUID idMessages) {
        log.debug("[start] MessagesInfraRepository - messagesById");
        log.debug("[finish] MessagesInfraRepository - messagesById");
        return null;
    }
}
