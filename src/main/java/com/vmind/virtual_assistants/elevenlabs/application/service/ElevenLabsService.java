package com.vmind.virtual_assistants.elevenlabs.application.service;

import com.vmind.virtual_assistants.elevenlabs.application.api.ElevenLabsTTSRequest;

public interface ElevenLabsService {
    byte[] textToSpeech(ElevenLabsTTSRequest request);
}
