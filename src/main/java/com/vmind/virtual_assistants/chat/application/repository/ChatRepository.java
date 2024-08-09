package com.vmind.virtual_assistants.chat.application.repository;

import com.vmind.virtual_assistants.chat.application.api.NewVoiceChatResponse;

public interface ChatRepository {
    void save(NewVoiceChatResponse response);
}
