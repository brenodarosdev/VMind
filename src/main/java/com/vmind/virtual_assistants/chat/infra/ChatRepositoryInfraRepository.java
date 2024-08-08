package com.vmind.virtual_assistants.chat.infra;

import com.vmind.virtual_assistants.chat.api.NewVoiceChatResponse;
import com.vmind.virtual_assistants.chat.repository.ChatRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
public class ChatRepositoryInfraRepository implements ChatRepository {
    @Override
    public void salva(NewVoiceChatResponse response) {
       log.debug("[start] ChatRepositoryInfraRepository - salva");
       log.debug("[finish] ChatRepositoryInfraRepository - salva");
    }
}
