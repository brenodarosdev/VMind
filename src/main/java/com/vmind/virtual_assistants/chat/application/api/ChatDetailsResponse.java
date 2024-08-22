package com.vmind.virtual_assistants.chat.application.api;

import com.vmind.virtual_assistants.chat.domain.Chat;
import lombok.Value;

import java.util.UUID;

@Value
public class ChatDetailsResponse {
    private UUID idChat;
    private String content;
    private ChatSettings chatSettings;
    private OpenaiTTSSettings openaiTTSSettings;
    private ElevenLabsTTSSettigs elevenLabsTTSSettigs;

    public ChatDetailsResponse(Chat chat) {
        this.idChat = chat.getIdChat();
        this.content = chat.getContent();
        this.chatSettings = chat.getChatSettings();
        this.openaiTTSSettings = chat.getOpenaiTTSSettings();
        this.elevenLabsTTSSettigs = chat.getElevenLabsTTSSettigs();
    }
}
