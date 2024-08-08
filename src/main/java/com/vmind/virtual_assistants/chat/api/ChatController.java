package com.vmind.virtual_assistants.chat.api;

import com.vmind.virtual_assistants.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class ChatController implements ChatAPI {
    private final ChatService chatService;

    @Override
    public NewVoiceChatResponse postNewVoiceChat(NewVoiceChatRequest voiceChatRequest) {
        log.debug("[start] ChatController - postNewVoiceChat");
        NewVoiceChatResponse response = chatService.newVoiceChat(voiceChatRequest);
        log.debug("[finish] ChatController - postNewVoiceChat");
        return response;
    }
}
