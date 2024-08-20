package com.vmind.virtual_assistants.chat.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Chat {
    @Id
    private UUID idChat;
    @Column(length = Integer.MAX_VALUE)
    private String content;

    public Chat(String content) {
        this.idChat = UUID.randomUUID();
        this.content = content;
    }
}
