package com.vmind.virtual_assistants.messages.infra;

import com.vmind.virtual_assistants.exception.APIException;
import com.vmind.virtual_assistants.messages.application.repository.MessagesRepository;
import com.vmind.virtual_assistants.messages.domain.Messages;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Log4j2
@Repository
@RequiredArgsConstructor
public class MessagesInfraRepository implements MessagesRepository {
    private final MessagesSpringDataJPARepository messagesSpringDataJPARepository;

    @Override
    public Messages listMessagesById(UUID idMessages) {
        log.debug("[start] MessagesInfraRepository - listMessagesById");
        Messages messages = messagesSpringDataJPARepository.findById(idMessages)
                        .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Messages not found!"));
        log.debug("[finish] MessagesInfraRepository - listMessagesById");
        return messages;
    }

    @Override
    public void save(Messages messages) {
        log.debug("[start] MessagesInfraRepository - save");
        messagesSpringDataJPARepository.save(messages);
        log.debug("[finish] MessagesInfraRepository - save");
    }
}
