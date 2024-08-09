package com.vmind.virtual_assistants.chat.domain;

import com.vmind.virtual_assistants.chat.application.api.NewVoiceChatResponse;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Chat {
    @Id
    private UUID id;
    @Column(length = Integer.MAX_VALUE)
    private String content;

    public Chat(NewVoiceChatResponse response) {
        this.id = response.getId();
        this.content = response.getContent();
    }
}
