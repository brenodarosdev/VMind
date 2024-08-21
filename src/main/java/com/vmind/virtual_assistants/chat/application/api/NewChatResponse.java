package com.vmind.virtual_assistants.chat.application.api;

import lombok.Value;

import java.util.UUID;

@Value
public class NewChatResponse {
    UUID idChat;
    String content;
}
