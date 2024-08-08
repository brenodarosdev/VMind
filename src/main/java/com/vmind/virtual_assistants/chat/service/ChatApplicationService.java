package com.vmind.virtual_assistants.chat.service;

import com.vmind.virtual_assistants.chat.api.NewVoiceChatRequest;
import com.vmind.virtual_assistants.chat.api.NewVoiceChatResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ChatApplicationService implements ChatService {
    @Override
    public NewVoiceChatResponse newVoiceChat(NewVoiceChatRequest voiceChatRequest) {
        log.debug("[start] ChatApplicationService - newVoiceChat");
        log.debug("[finish] ChatApplicationService - newVoiceChat");
        return null;
    }
}
