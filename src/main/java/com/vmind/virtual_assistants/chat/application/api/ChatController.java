package com.vmind.virtual_assistants.chat.application.api;

import com.vmind.virtual_assistants.chat.application.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Log4j2
@RestController
@RequiredArgsConstructor
public class ChatController implements ChatAPI {
    private final ChatService chatService;

    @Override
    public NewChatResponse postNewChat(ChatRequest chatRequest) {
        log.debug("[start] ChatController - postNewChat");
        NewChatResponse response = chatService.newChat(chatRequest);
        log.debug("[finish] ChatController - postNewChat");
        return response;
    }

    @Override
    public ChatDetailsResponse getChatDitailsById(UUID idChat) {
        log.debug("[start] ChatController - getChatById");
        ChatDetailsResponse response = chatService.chatDetailsById(idChat);
        log.debug("[finish] ChatController - getChatById");
        return response;
    }
}
