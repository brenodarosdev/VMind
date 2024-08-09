package com.vmind.virtual_assistants.chat.infra;

import com.vmind.virtual_assistants.chat.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatSpringDataJPARepository extends JpaRepository<Chat, UUID> {
}
