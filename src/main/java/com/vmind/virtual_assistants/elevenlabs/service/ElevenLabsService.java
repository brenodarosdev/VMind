package com.vmind.virtual_assistants.elevenlabs.service;

import com.vmind.virtual_assistants.chat.application.api.ElevenLabsTTSSettigs;

public interface ElevenLabsService {
    byte[] textToSpeech(String input, ElevenLabsTTSSettigs request);
}
