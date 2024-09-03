package com.vmind.virtual_assistants.openai.application.api;

import lombok.Value;
import org.springframework.web.multipart.MultipartFile;

@Value
public class OpenaiTranscriptionRequest {
    String model;
    String language;
    Float temperature;
    MultipartFile file;
}
