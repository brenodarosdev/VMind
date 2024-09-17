package com.vmind.virtual_assistants.chat.application.api;

import com.vmind.virtual_assistants.chat.domain.Chat;
import lombok.Value;

import java.util.UUID;

@Value
public class ChatDetailsResponse {
    UUID idChat;
    String chatName;
    ChatSettings chatSettings;
    OpenaiTTSSettings openaiTTSSettings;
    ElevenLabsTTSSettings elevenLabsTTSSettings;

    public ChatDetailsResponse(Chat chat) {
        this.idChat = chat.getIdChat();
        this.chatName = chat.getName();
        this.chatSettings = chat.getChatSettings();
        this.openaiTTSSettings = chat.getOpenaiTTSSettings();
        this.elevenLabsTTSSettings = chat.getElevenLabsTTSSettings();
    }
}
