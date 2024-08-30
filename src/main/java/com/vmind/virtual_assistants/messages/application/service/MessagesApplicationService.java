package com.vmind.virtual_assistants.messages.application.service;

import com.vmind.virtual_assistants.messages.application.api.AssistantResponse;
import com.vmind.virtual_assistants.messages.application.api.NewMessageRequest;
import com.vmind.virtual_assistants.messages.domain.ChatMessage;
import com.vmind.virtual_assistants.messages.application.repository.MessagesRepository;
import com.vmind.virtual_assistants.messages.domain.Messages;
import com.vmind.virtual_assistants.openai.application.api.OpenaiChatRequest;
import com.vmind.virtual_assistants.openai.application.service.OpenaiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ai.chat.messages.MessageType;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class MessagesApplicationService implements MessagesService {
    private final MessagesRepository messagesRepository;
    private final OpenaiService openaiService;

    @Override
    public List<ChatMessage> listMessagesById(UUID idMessages) {
        log.debug("[start] MessagesApplicationService - listMessagesById");
        Messages messages = messagesRepository.listMessagesById(idMessages);
        log.debug("[finish] MessagesApplicationService - listMessagesById");
        return messages.getListChatMessages();
    }

    @Override
    public AssistantResponse newMessage(UUID idMessages, NewMessageRequest request) {
        log.debug("[start] MessagesApplicationService - newMessage");
        Messages messages = messagesRepository.listMessagesById(idMessages);
        messages.addMessage(request.getUserMessage(), MessageType.USER);
        ChatResponse openaiResponse = openaiService.callChatModel(new OpenaiChatRequest(messages.getListChatMessages(), request.getChatSettings()));
        ChatMessage assistantMessage = messages.addMessage(openaiResponse.getResult().getOutput().getContent(), MessageType.ASSISTANT);
        messagesRepository.save(messages);
        log.debug("[finish] MessagesApplicationService - newMessage");
        return new AssistantResponse(openaiResponse.getResult().getMetadata().getFinishReason(), assistantMessage);
    }
}
