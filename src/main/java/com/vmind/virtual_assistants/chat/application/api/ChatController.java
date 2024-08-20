package com.vmind.virtual_assistants.chat.application.api;

import com.vmind.virtual_assistants.chat.application.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class ChatController implements ChatAPI {
    private final ChatService chatService;

    @Override
    public ChatIdResponse postNewChat(NewChatRequest voiceChatRequest) {
        log.debug("[start] ChatController - postNewChat");
        ChatIdResponse response = chatService.newChat(voiceChatRequest);
        log.debug("[finish] ChatController - postNewChat");
        return response;
    }
}
