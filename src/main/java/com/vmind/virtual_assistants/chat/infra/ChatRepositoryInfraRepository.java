package com.vmind.virtual_assistants.chat.infra;

import com.vmind.virtual_assistants.chat.application.api.NewVoiceChatResponse;
import com.vmind.virtual_assistants.chat.application.repository.ChatRepository;
import com.vmind.virtual_assistants.chat.domain.Chat;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
@RequiredArgsConstructor
public class ChatRepositoryInfraRepository implements ChatRepository {
    private final ChatSpringDataJPARepository chatSpringDataJPARepository;

    @Override
    public void salva(NewVoiceChatResponse response) {
       log.debug("[start] ChatRepositoryInfraRepository - salva");
       chatSpringDataJPARepository.save(new Chat(response));
       log.debug("[finish] ChatRepositoryInfraRepository - salva");
    }
}
