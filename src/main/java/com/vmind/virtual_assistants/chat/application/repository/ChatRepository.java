package com.vmind.virtual_assistants.chat.application.repository;

import com.vmind.virtual_assistants.chat.domain.Chat;

public interface ChatRepository {
    void save(Chat chat);
}
