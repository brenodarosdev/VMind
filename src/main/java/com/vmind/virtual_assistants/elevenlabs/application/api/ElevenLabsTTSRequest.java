package com.vmind.virtual_assistants.elevenlabs.application.api;

import com.vmind.virtual_assistants.chat.application.api.ElevenLabsTTSSettings;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class ElevenLabsTTSRequest {
    @NotBlank
    String input;
    @Valid
    ElevenLabsTTSSettings settings;
}
