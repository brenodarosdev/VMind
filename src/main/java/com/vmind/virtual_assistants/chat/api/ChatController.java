package com.vmind.virtual_assistants.chat.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class ChatController implements ChatAPI {
    @Override
    public NewVoiceChatResponse postNewVoiceChat(NewVoiceChatRequest voiceChatRequest) {
        log.debug("[start] ChatController - postNewVoiceChat");
        log.debug("[finish] ChatController - postNewVoiceChat");
        return null;
    }
}
