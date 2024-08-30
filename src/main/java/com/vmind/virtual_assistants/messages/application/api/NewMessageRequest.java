package com.vmind.virtual_assistants.messages.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NewMessageRequest {
    @NotBlank
    private String userMessage;
}
