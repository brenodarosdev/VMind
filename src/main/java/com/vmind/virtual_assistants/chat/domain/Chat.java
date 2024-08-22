package com.vmind.virtual_assistants.chat.domain;

import com.vmind.virtual_assistants.chat.application.api.ChatRequest;
import com.vmind.virtual_assistants.chat.application.api.ChatSettings;
import com.vmind.virtual_assistants.chat.application.api.ElevenLabsTTSSettigs;
import com.vmind.virtual_assistants.chat.application.api.OpenaiTTSSettings;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Chat {
    @Id
    private UUID idChat;
    @Column(length = Integer.MAX_VALUE)
    private String content;
    @Embedded
    private ChatSettings chatSettings;
    @Embedded
    private OpenaiTTSSettings openaiTTSSettings;
    @Embedded
    private ElevenLabsTTSSettigs elevenLabsTTSSettigs;

    public Chat(String content, ChatSettings chatSettings, OpenaiTTSSettings openaiTTSSettings, ElevenLabsTTSSettigs elevenLabsTTSSettigs) {
        this.idChat = UUID.randomUUID();
        this.content = content;
        this.chatSettings = chatSettings;
        this.openaiTTSSettings = openaiTTSSettings;
        this.elevenLabsTTSSettigs = elevenLabsTTSSettigs;
    }

    public void modifyChatSettings(ChatRequest chatRequest) {
        this.chatSettings = chatRequest.getChatSettings();
        this.openaiTTSSettings = chatRequest.getOpenaiTTSSettings();
        this.elevenLabsTTSSettigs = chatRequest.getElevenLabsTTSSettigs();
    }
}
