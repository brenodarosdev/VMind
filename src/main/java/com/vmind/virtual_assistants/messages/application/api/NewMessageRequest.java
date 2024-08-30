package com.vmind.virtual_assistants.messages.application.api;

import com.vmind.virtual_assistants.chat.application.api.ChatSettings;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NewMessageRequest {
    @NotBlank
    private String userMessage;
    @Valid
    @NotNull
    private ChatSettings chatSettings;
}
