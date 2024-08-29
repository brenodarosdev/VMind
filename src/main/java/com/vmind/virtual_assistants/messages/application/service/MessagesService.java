package com.vmind.virtual_assistants.messages.application.service;

import com.vmind.virtual_assistants.messages.domain.ChatMessage;

import java.util.List;
import java.util.UUID;

public interface MessagesService {
    List<ChatMessage> listMessagesById(UUID idMessages);
}
