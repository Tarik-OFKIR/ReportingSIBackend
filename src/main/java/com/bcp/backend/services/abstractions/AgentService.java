package com.bcp.backend.services.abstractions;

import com.bcp.backend.dto.AgentDTO;
import com.bcp.backend.exception.AgentNotFoundException;
import com.bcp.backend.model.Agent;

import java.util.List;

public interface AgentService {

    List<AgentDTO> getAllAgents();
    AgentDTO getAgentByRegistrationNumber(String registrationNumber)throws AgentNotFoundException;


    /*admin tasks*/


    AgentDTO addAgent(AgentDTO agentDTO, Long agencyCode) throws AgentNotFoundException;

    AgentDTO editAgent(AgentDTO agentDTO)throws AgentNotFoundException;
    void deleteAgent( String registrationNumber) throws AgentNotFoundException;
    void addProfileToAgent(String registrationNumber, Long profileId) throws AgentNotFoundException;
}
