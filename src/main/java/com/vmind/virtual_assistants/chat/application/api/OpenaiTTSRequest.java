package com.vmind.virtual_assistants.chat.application.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.ai.openai.OpenAiAudioSpeechOptions;

@Value
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class OpenaiTTSRequest {
    OpenAiAudioSpeechOptions speechOptions;
}
