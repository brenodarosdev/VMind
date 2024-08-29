package com.vmind.virtual_assistants.messages.application.api;

import com.vmind.virtual_assistants.messages.application.domain.ChatMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Log4j2
@RestController
@RequiredArgsConstructor
public class MessagesController implements MessagesAPI {
    @Override
    public List<ChatMessage> getMessagesById(UUID idMessages) {
        log.debug("[start] MessagesController - getMessagesById");
        log.debug("[finish] MessagesController - getMessagesById");
        return null;
    }
}
