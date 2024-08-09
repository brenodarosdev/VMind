package com.vmind.virtual_assistants.chat.application.api;

import jakarta.validation.Valid;
import lombok.Value;
import org.springframework.ai.openai.OpenAiAudioSpeechOptions;

@Value
public class OpenaiTTSRequest {
    @Valid
    OpenAiAudioSpeechOptions speechOptions;
}
