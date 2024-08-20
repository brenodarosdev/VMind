package com.vmind.virtual_assistants.chat.application.service;

import com.vmind.virtual_assistants.chat.application.api.NewVoiceChatElevenLabsTTSRequest;
import com.vmind.virtual_assistants.chat.application.api.NewVoiceChatOpenaiTTSRequest;
import com.vmind.virtual_assistants.chat.application.api.NewVoiceChatRequest;
import com.vmind.virtual_assistants.chat.application.api.NewVoiceChatResponse;
import com.vmind.virtual_assistants.chat.application.repository.ChatRepository;
import com.vmind.virtual_assistants.chat.domain.Chat;
import com.vmind.virtual_assistants.elevenlabs.service.ElevenLabsService;
import com.vmind.virtual_assistants.exception.APIException;
import com.vmind.virtual_assistants.openai.service.OpenaiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.http.HttpStatus;
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
        String openaiResponseContent = openaiResponse.getResult().getOutput().getContent();
        byte[] speech = textToSpeech(voiceChatRequest, openaiResponseContent);
        NewVoiceChatResponse response = new NewVoiceChatResponse(openaiResponse.getResult().getOutput().getMetadata(),
                openaiResponseContent, speech);
        chatRepository.save(new Chat(response.getId(),response.getContent()));
        log.debug("[finish] ChatApplicationService - newVoiceChat");
        return response;
    }

    private byte[] textToSpeech(NewVoiceChatRequest voiceChatRequest, String openaiResponseContent) {
        log.debug("[start] ChatApplicationService - textToSpeech");
        byte[] speech;
        if (voiceChatRequest instanceof NewVoiceChatElevenLabsTTSRequest voiceChatElevenLabsTTS) {
            speech = elevenLabsService.textToSpeech(openaiResponseContent, voiceChatElevenLabsTTS.getElevenLabsTTSRequest());
        } else if (voiceChatRequest instanceof NewVoiceChatOpenaiTTSRequest voiceChatOpenaiTTSRequest) {
            speech = openaiService.textToSpeech(openaiResponseContent, voiceChatOpenaiTTSRequest.getOpenaiTTSRequest());
        } else {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Unknown request type: " + voiceChatRequest.getClass().getName());
        }
        log.debug("[finish] ChatApplicationService - textToSpeech");
        return speech;
    }
}
