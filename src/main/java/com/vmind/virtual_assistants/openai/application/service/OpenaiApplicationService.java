package com.vmind.virtual_assistants.openai.application.service;

import com.vmind.virtual_assistants.messages.domain.ChatMessage;
import com.vmind.virtual_assistants.openai.application.api.OpenaiChatRequest;
import com.vmind.virtual_assistants.openai.application.api.OpenaiTTSRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiAudioSpeechModel;
import org.springframework.ai.openai.OpenAiAudioSpeechOptions;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.audio.speech.SpeechPrompt;
import org.springframework.ai.openai.audio.speech.SpeechResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class OpenaiApplicationService implements OpenaiService {
    private final OpenAiChatModel openAiChatModel;
    private final OpenAiAudioSpeechModel openAiAudioSpeechModel;

    @Override
    public ChatResponse callChatModel(OpenaiChatRequest request) {
        log.debug("[start] OpenaiApplicationService - callChatModel");
        List<Message> messages = convertToMessageList(request.getMessages());
        OpenAiChatOptions chatOptions = OpenAiChatOptions.builder()
                .withModel(request.getSettings().getModel())
                .withMaxTokens(request.getSettings().getMaxTokens())
                .withTemperature(request.getSettings().getTemperature())
                .build();
        ChatResponse response = openAiChatModel.call(new Prompt(messages, chatOptions));
        log.debug("[finish] OpenaiApplicationService - callChatModel");
        return response;
    }

    public List<Message> convertToMessageList(List<ChatMessage> messages) {
        return messages.stream()
                .map(message -> (Message) message)
                .toList();
    }

    @Override
    public byte[] textToSpeech(OpenaiTTSRequest request) {
        log.debug("[start] OpenaiApplicationService - textToSpeech");
        OpenAiAudioSpeechOptions speechOptions = OpenAiAudioSpeechOptions.builder()
                .withModel(request.getSettings().getTtsModel())
                .withVoice(request.getSettings().getVoice())
                .withResponseFormat(request.getSettings().getResponseFormat())
                .build();
        SpeechResponse responseStream = openAiAudioSpeechModel.call(new SpeechPrompt(request.getInput(), speechOptions));
        log.debug("[finish] OpenaiApplicationService - textToSpeech");
        return responseStream.getResult().getOutput();
    }
}
