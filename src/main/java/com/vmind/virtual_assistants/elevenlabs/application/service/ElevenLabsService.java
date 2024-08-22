package com.vmind.virtual_assistants.elevenlabs.application.service;

import com.vmind.virtual_assistants.elevenlabs.application.api.TTSRequest;

public interface ElevenLabsService {
    byte[] textToSpeech(TTSRequest request);
}
