package com.vmind.virtual_assistants.chat.application.service;

import com.vmind.virtual_assistants.chat.application.api.*;
import com.vmind.virtual_assistants.chat.application.repository.ChatRepository;
import com.vmind.virtual_assistants.chat.domain.Chat;
import com.vmind.virtual_assistants.messages.application.service.MessagesService;
import com.vmind.virtual_assistants.openai.application.api.OpenAIChatRequest;
import com.vmind.virtual_assistants.openai.application.service.OpenAIService;
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
    private final OpenAIService openaiService;
    private final ChatRepository chatRepository;
    private final MessagesService messagesService;

    @Override
    public NewChatResponse newChat(ChatRequest chatRequest) {
        log.debug("[start] ChatApplicationService - newChat");
        Chat chat = new Chat(chatRequest.getChatName(), chatRequest.getChatSettings(), chatRequest.getOpenaiTTSSettings(),
                chatRequest.getElevenLabsTTSSettings());
        chat.getMessages().addMessage(chatRequest.getChatSettings().getPrompt(), MessageType.SYSTEM);
        ChatResponse openaiResponse = openaiService.callChatModel(new OpenAIChatRequest(chat.getMessages()
                .getListChatMessages(), chatRequest.getChatSettings()));
        chat.getMessages().addMessage(openaiResponse.getResult().getOutput().getContent(), MessageType.ASSISTANT,
                openaiResponse.getResult().getMetadata().getFinishReason());
        chatRepository.save(chat);
        log.debug("[finish] ChatApplicationService - newChat");
        return new NewChatResponse(chat.getName(), chat.getIdChat(), chat.getMessages().getIdMessages(), chat.getMessages().getListChatMessages());
    }

    @Override
    public ChatDetailsResponse chatDetailsById(UUID idChat) {
        log.debug("[start] ChatApplicationService - chatDetailsById");
        Chat chat = chatRepository.chatById(idChat);
        ChatDetailsResponse response = new ChatDetailsResponse(chat);
        log.debug("[finish] ChatApplicationService - chatDetailsById");
        return response;
    }

    @Override
    public void modifyChatSettings(ChatRequest chatRequest, UUID idChat) {
        log.debug("[start] ChatApplicationService - modifyChatSettings");
        Chat chat = chatRepository.chatById(idChat);
        chat.modifyChatSettings(chatRequest);
        chatRepository.save(chat);
        log.debug("[finish] ChatApplicationService - modifyChatSettings");
    }

    @Override
    public void deleteChatById(UUID idChat) {
        log.debug("[start] ChatApplicationService - deleteChatById");
        Chat chat = chatRepository.chatById(idChat);
        chatRepository.deleteChatById(idChat);
        messagesService.deleteMessagesById(chat.getMessages().getIdMessages());
        log.debug("[finish] ChatApplicationService - deleteChatById");
    }
}
