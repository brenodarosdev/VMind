package com.vmind.virtual_assistants.chat.application.api;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ElevenLabsTTSSettigs {
    @NotBlank
    private String modelId;
    @NotBlank
    private String voiceId;
    @NotBlank
    private String languageCode;
    @NotNull
    private Float stability;
    @NotNull
    private Float similarityBoost;
}
