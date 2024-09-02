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
    public ChatSettingsResponse getChatDetailsById(UUID idChat) {
        log.debug("[start] ChatController - getChatDetailsById");
        ChatSettingsResponse response = chatService.chatDetailsById(idChat);
        log.debug("[finish] ChatController - getChatDetailsById");
        return response;
    }

    @Override
    public void patchModifyChatSettings(ChatRequest chatRequest, UUID idChat) {
        log.debug("[start] ChatController - patchModifyChatSettings");
        chatService.modifyChatSettings(chatRequest, idChat);
        log.debug("[finish] ChatController - patchModifyChatSettings");
    }

    @Override
    public void deleteChatById(UUID idChat) {
        log.debug("[start] ChatController - deleteChatById");
        chatService.deleteChatById(idChat);
        log.debug("[finish] ChatController - deleteChatById");
    }
}
