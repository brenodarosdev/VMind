package com.vmind.virtual_assistants.openai.application.api;

import com.vmind.virtual_assistants.chat.application.api.OpenaiTTSSettings;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class OpenaiTTSRequest {
    @NotBlank
    String input;
    @Valid
    @NotNull
    OpenaiTTSSettings settings;
}
