package com.vmind.virtual_assistants.elevenlabs.application.service;

import com.vmind.virtual_assistants.chat.application.api.ElevenLabsTTSSettigs;

public interface ElevenLabsService {
    byte[] textToSpeech(String input, ElevenLabsTTSSettigs request);
}
