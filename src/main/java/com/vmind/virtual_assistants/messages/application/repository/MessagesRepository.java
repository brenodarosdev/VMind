package com.vmind.virtual_assistants.messages.application.repository;

import com.vmind.virtual_assistants.messages.domain.ChatMessage;

import java.util.List;
import java.util.UUID;

public interface MessagesRepository {
    List<ChatMessage> messagesById(UUID idMessages);
}
