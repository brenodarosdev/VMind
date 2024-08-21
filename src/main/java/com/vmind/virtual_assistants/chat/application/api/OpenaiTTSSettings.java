package com.vmind.virtual_assistants.chat.application.api;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.ai.openai.api.OpenAiAudioApi;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OpenaiTTSSettings {
    @NotBlank
    private String ttsModel;
    @NotNull
    private OpenAiAudioApi.SpeechRequest.Voice voice;
    @NotNull
    private OpenAiAudioApi.SpeechRequest.AudioResponseFormat responseFormat;
}
