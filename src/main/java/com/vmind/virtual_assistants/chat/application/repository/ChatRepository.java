package com.vmind.virtual_assistants.chat.application.repository;

import com.vmind.virtual_assistants.chat.domain.Chat;

import java.util.UUID;

public interface ChatRepository {
    void save(Chat chat);
    Chat chatById(UUID idChat);
    void deleteChatById(UUID idChat);
}
