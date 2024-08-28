package com.vmind.virtual_assistants.chat.application.api;

import com.vmind.virtual_assistants.chat.domain.Chat;
import lombok.Value;

import java.util.UUID;

@Value
public class ChatSettingsResponse {
    private UUID idChat;
    private ChatSettings chatSettings;
    private OpenaiTTSSettings openaiTTSSettings;
    private ElevenLabsTTSSettings elevenLabsTTSSettings;

    public ChatSettingsResponse(Chat chat) {
        this.idChat = chat.getIdChat();
        this.chatSettings = chat.getChatSettings();
        this.openaiTTSSettings = chat.getOpenaiTTSSettings();
        this.elevenLabsTTSSettings = chat.getElevenLabsTTSSettings();
    }
}
