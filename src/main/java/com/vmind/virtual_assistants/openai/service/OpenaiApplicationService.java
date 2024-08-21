package com.vmind.virtual_assistants.openai.service;

import com.vmind.virtual_assistants.chat.application.api.ChatSettings;
import com.vmind.virtual_assistants.chat.application.api.OpenaiTTSSettings;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiAudioSpeechModel;
import org.springframework.ai.openai.OpenAiAudioSpeechOptions;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.audio.speech.SpeechPrompt;
import org.springframework.ai.openai.audio.speech.SpeechResponse;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class OpenaiApplicationService implements OpenaiService {
    private final OpenAiChatModel openAiChatModel;
    private final OpenAiAudioSpeechModel openAiAudioSpeechModel;

    @Override
    public ChatResponse callChatModel(ChatSettings request) {
        log.debug("[start] OpenaiApplicationService - callChatModel");
        OpenAiChatOptions options = OpenAiChatOptions.builder()
                .withModel(request.getModel())
                .withMaxTokens(request.getMaxTokens())
                .withTemperature(request.getTemperature())
                .build();
        ChatResponse response = openAiChatModel.call(new Prompt(request.getPrompt(), options));
        log.debug("[finish] OpenaiApplicationService - callChatModel");
        return response;
    }

    @Override
    public byte[] textToSpeech(String input, OpenaiTTSSettings request) {
        log.debug("[start] OpenaiApplicationService - textToSpeech");
        OpenAiAudioSpeechOptions speechOptions = OpenAiAudioSpeechOptions.builder()
                .withModel(request.getTtsModel())
                .withVoice(request.getVoice())
                .withResponseFormat(request.getResponseFormat())
                .build();
        SpeechResponse responseStream = openAiAudioSpeechModel.call(new SpeechPrompt(input, speechOptions));
        log.debug("[finish] OpenaiApplicationService - textToSpeech");
        return responseStream.getResult().getOutput();
    }
}
