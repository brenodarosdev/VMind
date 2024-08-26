package com.vmind.virtual_assistants.openai.application.api;

import com.vmind.virtual_assistants.chat.application.api.OpenaiTTSSettings;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class OpenaiTTSRequest {
    @NotBlank
    String input;
    @Valid
    OpenaiTTSSettings settings;
}
