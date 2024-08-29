package com.vmind.virtual_assistants.messages.application.service;

import com.vmind.virtual_assistants.messages.application.domain.ChatMessage;

import java.util.List;
import java.util.UUID;

public interface MessagesService {
    List<ChatMessage> messagesById(UUID idMessages);
}
