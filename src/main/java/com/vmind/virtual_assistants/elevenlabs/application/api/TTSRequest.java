package com.vmind.virtual_assistants.elevenlabs.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class TTSRequest {
    @NotBlank
    String idChat;
    @NotBlank
    String input;
}
