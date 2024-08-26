package com.vmind.virtual_assistants.openai.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Openai")
@RequestMapping("/public/v1/openai")
public interface OpenaiAPI {
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Call Chat")
    @PostMapping("/call-chat")
    void callChat(@RequestBody @Valid OpenaiChatRequest request);

    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Text to speech")
    @PostMapping("/text-to-speech")
    byte[] textToSpeech(@RequestBody @Valid OpenaiTTSRequest request);
}
