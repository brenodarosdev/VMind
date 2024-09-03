package com.vmind.virtual_assistants.openai.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Openai")
@RequestMapping("/public/v1/openai")
public interface OpenaiAPI {
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Call Chat Model")
    @PostMapping("/call-chat")
    ChatResponse callChatModel(@RequestBody @Valid OpenaiChatRequest request);

    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Text to speech")
    @PostMapping("/text-to-speech")
    byte[] textToSpeech(@RequestBody @Valid OpenaiTTSRequest request);

    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Call Transcription Model")
    @PostMapping("/transcription")
    String callTranscriptionModel(@ModelAttribute @Valid OpenaiTranscriptionRequest request);
}
