package com.bcp.backend.repository;

import com.bcp.backend.model.Agency;
import com.bcp.backend.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgentRepository extends JpaRepository<Agent, String> {
    Agent findAgentByRegistrationNumber(String agentRegisterNumber);
    List<Agent> findByAgencyCode(Long agencyCode);

}
