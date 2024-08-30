package com.vmind.virtual_assistants.messages.application.repository;

import com.vmind.virtual_assistants.messages.domain.Messages;

import java.util.UUID;

public interface MessagesRepository {
    Messages listMessagesById(UUID idMessages);
    void save(Messages messages);
}
