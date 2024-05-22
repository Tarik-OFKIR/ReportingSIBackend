package com.bcp.backend.services.concretions;

import com.bcp.backend.configuration.enums.Preference;
import com.bcp.backend.configuration.utils.Mappers;
import com.bcp.backend.dto.ProfileDTO;
import com.bcp.backend.exception.ProfileFoundException;
import com.bcp.backend.exception.ProfileNotFoundException;
import com.bcp.backend.model.Agent;
import com.bcp.backend.model.Profile;
import com.bcp.backend.model.State;
import com.bcp.backend.repository.AgentRepository;
import com.bcp.backend.repository.ProfileRepository;
import com.bcp.backend.repository.StateRepository;
import com.bcp.backend.services.abstractions.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ProfileServiceImpl implements ProfileService {
    private ProfileRepository profileRepository;
    private AgentRepository agentRepository;
    private StateRepository stateRepository;

    @Override
    public List<ProfileDTO> getAllProfiles() {
        return profileRepository.findAll().stream().map(Mappers::fromProfile).toList();
    }

    @Override
    public List<ProfileDTO> getAgentProfiles(String AgentRegistrationNumber) {
        Agent agent = agentRepository.findAgentByRegistrationNumber(AgentRegistrationNumber);
        List<Agent> agents = List.of(agent);
        return profileRepository.findAllByAgentsIn(agents).stream().map(Mappers::fromProfile).toList();
    }

    @Override
    public ProfileDTO addProfile(ProfileDTO profileDTO) throws ProfileFoundException {
        if (profileRepository.findByName(profileDTO.getName())!=null)
            throw new ProfileFoundException("Profile already exist");
        Profile savedProfile = profileRepository.save(Mappers.fromProfileDTO(profileDTO));
        return Mappers.fromProfile(savedProfile);
    }

    @Override
    public ProfileDTO editProfile(ProfileDTO profileDTO) throws ProfileNotFoundException {
        Profile profile = profileRepository.findById(profileDTO.getId()).orElseThrow(() -> new ProfileNotFoundException("Profile not found"));
        return Mappers.fromProfile(profileRepository.save(Mappers.updateProfile(profile, profileDTO)));
    }


    @Override
    public void deleteProfile(Long profileId) throws ProfileNotFoundException {
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new ProfileNotFoundException("Profile not found"));
        profileRepository.delete(profile);
    }

    @Override
    public void addStateToProfile(Long profileId, Long stateId) {
        Profile profile = profileRepository.findById(profileId).orElseThrow();
        State state = stateRepository.findById(stateId).orElseThrow();
        if (profile.getStates() != null && state.getProfiles() != null) {
            profile.getStates().add(state);
            state.getProfiles().add(profile);
        }
    }
}
