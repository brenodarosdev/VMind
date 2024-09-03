package com.vmind.virtual_assistants.messages.application.service;

import com.vmind.virtual_assistants.exception.APIException;
import com.vmind.virtual_assistants.messages.application.api.NewMessageRequest;
import com.vmind.virtual_assistants.messages.domain.ChatMessage;
import com.vmind.virtual_assistants.messages.application.repository.MessagesRepository;
import com.vmind.virtual_assistants.messages.domain.Messages;
import com.vmind.virtual_assistants.openai.application.api.OpenAIChatRequest;
import com.vmind.virtual_assistants.openai.application.service.OpenAIService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ai.chat.messages.MessageType;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class MessagesApplicationService implements MessagesService {
    private final MessagesRepository messagesRepository;
    private final OpenAIService openaiService;

    @Override
    public List<ChatMessage> listMessagesById(UUID idMessages) {
        log.debug("[start] MessagesApplicationService - listMessagesById");
        Messages messages = messagesRepository.messagesById(idMessages);
        log.debug("[finish] MessagesApplicationService - listMessagesById");
        return messages.getListChatMessages();
    }

    @Override
    public void deleteMessagesById(UUID idMessages) {
        log.debug("[start] MessagesApplicationService - deleteMessagesById");
        messagesRepository.deleteMessagesById(idMessages);
        log.debug("[finish] MessagesApplicationService - deleteMessagesById");
    }

    @Override
    public ChatMessage newMessage(UUID idMessages, NewMessageRequest request) {
        log.debug("[start] MessagesApplicationService - newMessage");
        Messages messages = messagesRepository.messagesById(idMessages);
        messages.addMessage(request.getUserMessage(), MessageType.USER);
        ChatResponse openaiResponse = openaiService.callChatModel(new OpenAIChatRequest(messages.getListChatMessages(), request.getChatSettings()));
        ChatMessage assistantMessage = messages.addMessage(openaiResponse.getResult().getOutput().getContent(),
                MessageType.ASSISTANT, openaiResponse.getResult().getMetadata().getFinishReason());
        messagesRepository.save(messages);
        log.debug("[finish] MessagesApplicationService - newMessage");
        return assistantMessage;
    }

    @Override
    public List<ChatMessage> modifyChatMessage(UUID idMessages, UUID idChatMessage, NewMessageRequest request) {
        log.debug("[start] MessagesApplicationService - modifyChatMessage");
        Messages messages = messagesRepository.messagesById(idMessages);
        ChatMessage chatMessage = messages.findChatMessageById(idChatMessage)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "ChatMessage not found"));
        List<ChatMessage> listChatMessages = messages.getListChatMessages();
        listChatMessages.subList(listChatMessages.indexOf(chatMessage), listChatMessages.size()).clear();
        messages.addMessage(request.getUserMessage(), MessageType.USER);
        ChatResponse openaiResponse = openaiService.callChatModel(new OpenAIChatRequest(listChatMessages, request.getChatSettings()));
        messages.addMessage(openaiResponse.getResult().getOutput().getContent(), MessageType.ASSISTANT,
                openaiResponse.getResult().getMetadata().getFinishReason());
        messagesRepository.save(messages);
        log.debug("[finish] MessagesApplicationService - modifyChatMessage");
        return listChatMessages;
    }

    @Override
    public void deleteChatMessagesById(UUID idMessages) {
        log.debug("[start] MessagesApplicationService - deleteChatMessagesById");
        Messages messages = messagesRepository.messagesById(idMessages);
        List<ChatMessage> listChatMessages = messages.getListChatMessages();
        listChatMessages.subList(1, listChatMessages.size()).clear();
        messagesRepository.save(messages);
        log.debug("[finish] MessagesApplicationService - deleteChatMessagesById");
    }
}
