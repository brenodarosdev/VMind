package com.vmind.virtual_assistants.chat.service;

import com.vmind.virtual_assistants.chat.api.NewVoiceChatElevenLabsTTSRequest;
import com.vmind.virtual_assistants.chat.api.NewVoiceChatRequest;
import com.vmind.virtual_assistants.chat.api.NewVoiceChatResponse;
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

    @Override
    public NewVoiceChatResponse newVoiceChat(NewVoiceChatRequest voiceChatRequest) {
        log.debug("[start] ChatApplicationService - newVoiceChat");
        NewVoiceChatElevenLabsTTSRequest VoiceChatElevenLabsTTS = (NewVoiceChatElevenLabsTTSRequest) voiceChatRequest;
        ChatResponse openaiResponse = openaiService.callChatModel(VoiceChatElevenLabsTTS.getOpenaiCallRequest());
        NewVoiceChatResponse response = new NewVoiceChatResponse(openaiResponse.getResult().getOutput().getMetadata(),
                openaiResponse.getResult().getOutput().getContent());
        log.debug("[finish] ChatApplicationService - newVoiceChat");
        return response;
    }
}
