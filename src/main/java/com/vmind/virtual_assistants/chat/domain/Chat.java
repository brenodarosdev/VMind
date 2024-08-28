package com.vmind.virtual_assistants.chat.domain;

import com.vmind.virtual_assistants.chat.application.api.ChatRequest;
import com.vmind.virtual_assistants.chat.application.api.ChatSettings;
import com.vmind.virtual_assistants.chat.application.api.ElevenLabsTTSSettings;
import com.vmind.virtual_assistants.chat.application.api.OpenaiTTSSettings;
import com.vmind.virtual_assistants.messages.application.domain.Messages;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Chat {
    @Id
    private UUID idChat;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Messages messages;
    @Embedded
    private ChatSettings chatSettings;
    @Embedded
    private OpenaiTTSSettings openaiTTSSettings;
    @Embedded
    private ElevenLabsTTSSettings elevenLabsTTSSettings;

    public Chat(ChatSettings chatSettings, OpenaiTTSSettings openaiTTSSettings, ElevenLabsTTSSettings elevenLabsTTSSettings) {
        this.idChat = UUID.randomUUID();
        this.messages = new Messages(idChat, new ArrayList<>());
        this.chatSettings = chatSettings;
        this.openaiTTSSettings = openaiTTSSettings;
        this.elevenLabsTTSSettings = elevenLabsTTSSettings;
    }

    public void modifyChatSettings(ChatRequest chatRequest) {
        this.chatSettings = chatRequest.getChatSettings();
        this.openaiTTSSettings = chatRequest.getOpenaiTTSSettings();
        this.elevenLabsTTSSettings = chatRequest.getElevenLabsTTSSettings();
    }
}
