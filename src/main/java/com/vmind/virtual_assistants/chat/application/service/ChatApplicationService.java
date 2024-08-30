package com.vmind.virtual_assistants.chat.application.service;

import com.vmind.virtual_assistants.chat.application.api.*;
import com.vmind.virtual_assistants.chat.application.repository.ChatRepository;
import com.vmind.virtual_assistants.chat.domain.Chat;
import com.vmind.virtual_assistants.openai.application.api.OpenaiChatRequest;
import com.vmind.virtual_assistants.openai.application.service.OpenaiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ai.chat.messages.MessageType;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class ChatApplicationService implements ChatService {
    private final OpenaiService openaiService;
    private final ChatRepository chatRepository;

    @Override
    public NewChatResponse newChat(ChatRequest chatRequest) {
        log.debug("[start] ChatApplicationService - newChat");
        Chat chat = new Chat(chatRequest.getChatSettings(), chatRequest.getOpenaiTTSSettings(),
                chatRequest.getElevenLabsTTSSettings());
        chat.getMessages().addMessage(chatRequest.getChatSettings().getPrompt(), MessageType.SYSTEM);
        ChatResponse openaiResponse = openaiService.callChatModel(new OpenaiChatRequest(chat.getMessages()
                .getListChatMessages(), chatRequest.getChatSettings()));
        chat.getMessages().addMessage(openaiResponse.getResult().getOutput().getContent(), MessageType.ASSISTANT);
        chatRepository.save(chat);
        log.debug("[finish] ChatApplicationService - newChat");
        return new NewChatResponse(chat.getIdChat(), chat.getMessages().getIdMessages(), chat.getMessages().getListChatMessages());
    }

    @Override
    public ChatSettingsResponse chatDetailsById(UUID idChat) {
        log.debug("[start] ChatApplicationService - chatById");
        Chat chat = chatRepository.chatById(idChat);
        ChatSettingsResponse response = new ChatSettingsResponse(chat);
        log.debug("[finish] ChatApplicationService - chatById");
        return response;
    }

    @Override
    public void modifyChatSettings(ChatRequest chatRequest, UUID idChat) {
        log.debug("[start] ChatApplicationService - modifyChat");
        Chat chat = chatRepository.chatById(idChat);
        chat.modifyChatSettings(chatRequest);
        chatRepository.save(chat);
        log.debug("[finish] ChatApplicationService - modifyChat");
    }

    @Override
    public void deleteChat(UUID idChat) {
        log.debug("[start] ChatApplicationService - deleteChat");
        chatRepository.deleteChat(idChat);
        log.debug("[finish] ChatApplicationService - deleteChat");
    }
}
