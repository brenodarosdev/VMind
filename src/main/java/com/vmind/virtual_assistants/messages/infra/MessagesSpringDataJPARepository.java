package com.vmind.virtual_assistants.messages.infra;

import com.vmind.virtual_assistants.messages.domain.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessagesSpringDataJPARepository extends JpaRepository<Messages, UUID> {
}
