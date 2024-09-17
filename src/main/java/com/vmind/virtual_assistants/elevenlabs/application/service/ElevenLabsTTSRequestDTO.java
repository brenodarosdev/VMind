package com.vmind.virtual_assistants.elevenlabs.application.service;

import com.vmind.virtual_assistants.chat.application.api.ElevenLabsTTSSettings;

public class ElevenLabsTTSRequestDTO {
    private String text;
    private String model_id;
    private String language_code;
    private VoiceSettingsDTO voice_settings;

    public ElevenLabsTTSRequestDTO(String input, String modelId, ElevenLabsTTSSettings request) {
        this.text = input;
        this.model_id = modelId;
        this.language_code = request.getLanguageCode();
        this.voice_settings = new VoiceSettingsDTO(request);
    }

    public static class VoiceSettingsDTO {
        private String similarity_boost;
        private String stability;

        public VoiceSettingsDTO(ElevenLabsTTSSettings settings) {
            this.similarity_boost = settings.getSimilarityBoost().toString();
            this.stability = settings.getStability().toString();
        }
    }
}
