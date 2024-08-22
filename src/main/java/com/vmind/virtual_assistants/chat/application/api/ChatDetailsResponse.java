package com.vmind.virtual_assistants.chat.application.api;

import lombok.Value;

import java.util.UUID;

@Value
public class ChatDetailsResponse {
    private UUID idChat;
    private String content;
    private ChatSettings chatSettings;
    private OpenaiTTSSettings openaiTTSSettings;
    private ElevenLabsTTSSettigs elevenLabsTTSSettigs;
}
