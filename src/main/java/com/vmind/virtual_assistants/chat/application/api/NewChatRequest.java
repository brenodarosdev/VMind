package com.vmind.virtual_assistants.chat.application.api;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = NewChatElevenLabsTTSRequest.class, name = "elevenlabsTTS"),
        @JsonSubTypes.Type(value = NewChatOpenaiTTSRequest.class, name = "openaiTTS")
})
public interface NewChatRequest {
    public OpenaiCallRequest getOpenaiCallRequest();
}
