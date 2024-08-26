package com.vmind.virtual_assistants.chat.application.api;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChatSettings {
    @NotBlank
    private String model;
    @NotNull
    private Integer maxTokens;
    @NotNull
    private Float temperature;
    @NotNull
    @Column(length = Integer.MAX_VALUE)
    private String prompt;
}
