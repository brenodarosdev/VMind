package com.vmind.virtual_assistants.chat.infra;

import com.vmind.virtual_assistants.chat.application.repository.ChatRepository;
import com.vmind.virtual_assistants.chat.domain.Chat;
import com.vmind.virtual_assistants.exception.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Log4j2
@Repository
@RequiredArgsConstructor
public class ChatRepositoryInfraRepository implements ChatRepository {
    private final ChatSpringDataJPARepository chatSpringDataJPARepository;

    @Override
    public void save(Chat chat) {
       log.debug("[start] ChatRepositoryInfraRepository - save");
        chatSpringDataJPARepository.save(chat);
       log.debug("[finish] ChatRepositoryInfraRepository - save");
    }

    @Override
    public Chat chatById(UUID idChat) {
        log.debug("[start] ChatRepositoryInfraRepository - chatById");
        Chat chat = chatSpringDataJPARepository.findByIdChat(idChat)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Chat not found! "));
        log.debug("[finish] ChatRepositoryInfraRepository - chatById");
        return chat;

    }
}
