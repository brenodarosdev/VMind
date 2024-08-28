package com.vmind.virtual_assistants.chat.domain;

import com.vmind.virtual_assistants.chat.application.api.ChatRequest;
import com.vmind.virtual_assistants.chat.application.api.ChatSettings;
import com.vmind.virtual_assistants.chat.application.api.ElevenLabsTTSSettings;
import com.vmind.virtual_assistants.chat.application.api.OpenaiTTSSettings;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.ai.chat.messages.MessageType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Chat {
    @Id
    private UUID idChat;
    @ElementCollection
    private List<ChatMessage> messages;
    @Embedded
    private ChatSettings chatSettings;
    @Embedded
    private OpenaiTTSSettings openaiTTSSettings;
    @Embedded
    private ElevenLabsTTSSettings elevenLabsTTSSettings;

    public Chat(ChatSettings chatSettings, OpenaiTTSSettings openaiTTSSettings, ElevenLabsTTSSettings elevenLabsTTSSettings) {
        this.idChat = UUID.randomUUID();
        this.messages = new ArrayList<>();
        this.chatSettings = chatSettings;
        this.openaiTTSSettings = openaiTTSSettings;
        this.elevenLabsTTSSettings = elevenLabsTTSSettings;
    }

    public void addMessage(String content, MessageType messageType) {
        this.messages.add(new ChatMessage(content, messageType));
    }

    public void modifyChatSettings(ChatRequest chatRequest) {
        this.chatSettings = chatRequest.getChatSettings();
        this.openaiTTSSettings = chatRequest.getOpenaiTTSSettings();
        this.elevenLabsTTSSettings = chatRequest.getElevenLabsTTSSettings();
    }
}
