package com.vmind.virtual_assistants.chat.application.service;

import com.vmind.virtual_assistants.chat.application.api.ChatIdResponse;
import com.vmind.virtual_assistants.chat.application.api.NewChatRequest;
import com.vmind.virtual_assistants.chat.application.repository.ChatRepository;
import com.vmind.virtual_assistants.chat.domain.Chat;
import com.vmind.virtual_assistants.openai.service.OpenaiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class ChatApplicationService implements ChatService {
    private final OpenaiService openaiService;
    private final ChatRepository chatRepository;

    @Override
    public ChatIdResponse newChat(NewChatRequest chatRequest) {
        log.debug("[start] ChatApplicationService - newChat");
        ChatResponse openaiResponse = openaiService.callChatModel(chatRequest.getOpenaiCallRequest());
        Chat chat = new Chat(openaiResponse.getResult().getOutput().getContent());
        chatRepository.save(chat);
        log.debug("[finish] ChatApplicationService - newChat");
        return new ChatIdResponse(chat.getIdChat());
    }
}
