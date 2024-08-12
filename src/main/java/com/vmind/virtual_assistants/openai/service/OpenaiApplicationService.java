package com.vmind.virtual_assistants.openai.service;

import com.vmind.virtual_assistants.audioPlayer.AudioPlayer;
import com.vmind.virtual_assistants.chat.application.api.OpenaiCallRequest;
import com.vmind.virtual_assistants.chat.application.api.OpenaiTTSRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiAudioSpeechModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.audio.speech.SpeechPrompt;
import org.springframework.ai.openai.audio.speech.SpeechResponse;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

@Log4j2
@Service
@RequiredArgsConstructor
public class OpenaiApplicationService implements OpenaiService {
    private final OpenAiChatModel openAiChatModel;
    private final OpenAiAudioSpeechModel openAiAudioSpeechModel;
    private final AudioPlayer audioPlayer;

    @Override
    public ChatResponse callChatModel(OpenaiCallRequest request) {
        log.debug("[start] OpenaiApplicationService - callChatModel");
        ChatResponse response = openAiChatModel.call(new Prompt(request.getPrompt(), request.getSettings()));
        log.debug("[finish] OpenaiApplicationService - callChatModel");
        return response;
    }

    @Override
    public void textToSpeech(String content, OpenaiTTSRequest request) {
        log.debug("[start] OpenaiApplicationService - textToSpeech");
        SpeechResponse responseStream = openAiAudioSpeechModel.call(new SpeechPrompt(content, request.getSpeechOptions()));
        audioPlayer.playAudio(new ByteArrayInputStream(responseStream.getResult().getOutput()));
        log.debug("[finish] OpenaiApplicationService - textToSpeech");
    }
}
