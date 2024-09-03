package com.vmind.virtual_assistants.openai.application.api;

import jakarta.validation.constraints.NotNull;
import lombok.Value;
import org.springframework.web.multipart.MultipartFile;

@Value
public class OpenAITranscriptionRequest {
    String model;
    String language;
    Float temperature;
    @NotNull
    MultipartFile file;
}
