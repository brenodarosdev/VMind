package com.vmind.virtual_assistants.chat.repository;

import com.vmind.virtual_assistants.chat.api.NewVoiceChatResponse;

public interface ChatRepository {
    void salva(NewVoiceChatResponse response);
}
