package com.vmind.virtual_assistants.elevenlabs.service;

import com.vmind.virtual_assistants.chat.application.api.ElevenLabsTTSRequest;

public interface ElevenLabsService {
    void textToSpeech(String content, ElevenLabsTTSRequest request);
}
