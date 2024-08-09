package com.vmind.virtual_assistants.elevenlabs.infra.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "elevenLabsClientFeign", url = "https://api.elevenlabs.io")
public interface ElevenLabsClientFeign {
    @PostMapping(value = "/v1/text-to-speech/{voiceId}/stream", consumes = "application/json")
    byte[] textToSpeech(
            @RequestHeader("xi-api-key") String apiKey,
            @PathVariable String voiceId,
            @RequestBody String body);
}