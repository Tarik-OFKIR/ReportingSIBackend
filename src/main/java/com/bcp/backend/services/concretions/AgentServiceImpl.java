package com.bcp.backend.services.concretions;

import com.bcp.backend.configuration.utils.Mappers;
import com.bcp.backend.dto.AgentDTO;
import com.bcp.backend.exception.AgentNotFoundException;
import com.bcp.backend.model.Agency;
import com.bcp.backend.model.Agent;
import com.bcp.backend.model.Profile;
import com.bcp.backend.repository.AgencyRepository;
import com.bcp.backend.repository.AgentRepository;
import com.bcp.backend.repository.ProfileRepository;
import com.bcp.backend.services.abstractions.AgentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class AgentServiceImpl implements AgentService {
    private AgentRepository agentRepository;
    private AgencyRepository agencyRepository;
    private ProfileRepository profileRepository;

    @Override
    public List<AgentDTO> getAllAgents() {
        List<Agent> agents = agentRepository.findAll();
        return agents.stream().map(Mappers::fromAgent)
                .collect(Collectors.toList());
    }

    @Override
    public AgentDTO getAgentByRegistrationNumber(String registrationNumber) throws AgentNotFoundException {
        Agent agent = agentRepository.findAgentByRegistrationNumber(registrationNumber);
        if (agent == null) throw new AgentNotFoundException("agent not found");
        return Mappers.fromAgent(agent);
    }

    @Override
    public AgentDTO addAgent(AgentDTO agentDTO, Long agencyCode) throws AgentNotFoundException {
        Agency agency = agencyRepository.findById(agencyCode).orElse(null);
        if (agency == null) throw new AgentNotFoundException("agency not found");
        Agent agent = Mappers.fromAgentDTO(agentDTO);
        agent.setAgency(agency);
        Agent saveAgent = agentRepository.save(Mappers.fromAgentDTO(agentDTO));
        return Mappers.fromAgent(saveAgent);
    }

    @Override
    public AgentDTO editAgent(AgentDTO agentDTO) throws AgentNotFoundException {
        Agent agent = agentRepository.findById(agentDTO.getRegistrationNumber()).orElseThrow( () -> new AgentNotFoundException("agent not found"));
        return Mappers.fromAgent(agentRepository.save(Mappers.updateAgent(agent, agentDTO)));
    }

    @Override
    public void deleteAgent(String registrationNumber) throws AgentNotFoundException {
        Agent agent = agentRepository.findAgentByRegistrationNumber(registrationNumber);
        if (agent == null) throw new AgentNotFoundException("agent not found");
        agentRepository.delete(agent);
    }

    @Override
    public void addProfileToAgent(String registrationNumber, Long profileId) throws AgentNotFoundException {
        Agent agent = agentRepository.findAgentByRegistrationNumber(registrationNumber);
        Profile profile = profileRepository.findById(profileId).orElse(null);
        if (agent.getProfiles() != null || profile.getAgents() != null){
            agent.getProfiles().add(profile);
            profile.getAgents().add(agent);
        }
    }
}
