package com.vmind.virtual_assistants.elevenlabs.service;

import com.google.gson.JsonElement;
import com.vmind.virtual_assistants.chat.application.api.ElevenLabsTTSRequest;

public class ElevenLabsTTSRequestDTO {
    private String text;
    private String model_id;
    private String language_code;
    private VoiceSettingsDTO voice_settings;

    public ElevenLabsTTSRequestDTO(String content, ElevenLabsTTSRequest request) {
        this.text = content;
        this.model_id = request.getModelId();
        this.language_code = request.getLanguageCode();
        this.voice_settings = new VoiceSettingsDTO(request.getVoiceSettings());
    }

    public static class VoiceSettingsDTO {
        String similarity_boost;
        String stability;

        public VoiceSettingsDTO(ElevenLabsTTSRequest.VoiceSettings settings) {
            this.similarity_boost = settings.getSimilarityBoost();
            this.stability = settings.getStability();
        }
    }
}
