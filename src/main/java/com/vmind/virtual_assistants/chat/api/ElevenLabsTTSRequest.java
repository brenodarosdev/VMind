package com.vmind.virtual_assistants.chat.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class ElevenLabsTTSRequest {
    @NotBlank
    String voiceId;
    @NotBlank
    String modelId;
    @NotBlank
    String languageCode;
    @Valid
    VoiceSettings voiceSettings;

    @Value
    public static class VoiceSettings {
        @NotBlank
        String stability;
        @NotBlank
        String similarityBoost;
    }
}
