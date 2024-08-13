package com.vmind.virtual_assistants.chat.application.service;

import com.vmind.virtual_assistants.chat.application.api.NewVoiceChatElevenLabsTTSRequest;
import com.vmind.virtual_assistants.chat.application.api.NewVoiceChatOpenaiTTSRequest;
import com.vmind.virtual_assistants.chat.application.api.NewVoiceChatRequest;
import com.vmind.virtual_assistants.chat.application.api.NewVoiceChatResponse;
import com.vmind.virtual_assistants.chat.application.repository.ChatRepository;
import com.vmind.virtual_assistants.elevenlabs.service.ElevenLabsService;
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
    private final ElevenLabsService elevenLabsService;

    @Override
    public NewVoiceChatResponse newVoiceChat(NewVoiceChatRequest voiceChatRequest) {
        log.debug("[start] ChatApplicationService - newVoiceChat");
        ChatResponse openaiResponse = openaiService.callChatModel(voiceChatRequest.getOpenaiCallRequest());
        NewVoiceChatResponse response = new NewVoiceChatResponse(openaiResponse.getResult().getOutput().getMetadata(),
                openaiResponse.getResult().getOutput().getContent());
        chatRepository.save(response);
        if (voiceChatRequest instanceof NewVoiceChatElevenLabsTTSRequest voiceChatElevenLabsTTS) {
            elevenLabsService.textToSpeech(response.getContent(), voiceChatElevenLabsTTS.getElevenLabsTTSRequest());
        } else if (voiceChatRequest instanceof NewVoiceChatOpenaiTTSRequest voiceChatOpenaiTTSRequest) {
            openaiService.textToSpeech(response.getContent(), voiceChatOpenaiTTSRequest.getOpenaiTTSRequest());
        }
        log.debug("[finish] ChatApplicationService - newVoiceChat");
        return response;
    }
}
