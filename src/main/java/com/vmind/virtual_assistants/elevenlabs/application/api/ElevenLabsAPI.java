package com.vmind.virtual_assistants.elevenlabs.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "ElevenLabs")
@RequestMapping("/public/v1/elevenlabs")
public interface ElevenLabsAPI {
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Text to speech")
    @PostMapping("/text-to-speech")
    byte[] textToSpeech(@RequestBody @Valid ElevenLabsTTSRequest request);
}
