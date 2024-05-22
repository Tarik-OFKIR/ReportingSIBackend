package com.bcp.backend.services.concretions;

import com.bcp.backend.configuration.utils.Mappers;
import com.bcp.backend.dto.StateDTO;
import com.bcp.backend.exception.ApplicationNotFoundException;
import com.bcp.backend.exception.ProfileNotFoundException;
import com.bcp.backend.exception.StateNotFondeException;
import com.bcp.backend.model.Application;
import com.bcp.backend.model.Profile;
import com.bcp.backend.model.State;
import com.bcp.backend.repository.ApplicationRepository;
import com.bcp.backend.repository.ProfileRepository;
import com.bcp.backend.repository.StateRepository;
import com.bcp.backend.services.abstractions.StateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class StateServiceImpl implements StateService {
    private StateRepository stateRepository;
    private ProfileRepository profileRepository;
    private ApplicationRepository applicationRepository;


    @Override
    public List<StateDTO> getApplicationStates(Long applicationId) {
        List<State> states = stateRepository.findByApplicationId(applicationId);
        return states.stream().map(Mappers::fromState).collect(Collectors.toList());
    }

    @Override
    public List<StateDTO> getProfileStates(Long profileId) throws ProfileNotFoundException {
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new ProfileNotFoundException("profile not found"));
        List<Profile> profiles = new ArrayList<>();
        profiles.add(profile);
        List<State> states = stateRepository.findAllByProfilesIn(profiles);
        return states.stream().map(Mappers::fromState).collect(Collectors.toList());
    }

    @Override
    public StateDTO addState(StateDTO stateDTO) throws StateNotFondeException, ApplicationNotFoundException {
        if (stateRepository.findByName(stateDTO.getName()) != null)
            throw new StateNotFondeException("state already exists");
        Application application = applicationRepository.findById(stateDTO.getApplicationId()).orElseThrow(() -> new ApplicationNotFoundException("application not found"));
        State state = Mappers.fromStateDTO(stateDTO);
        state.setApplication(application);
        State savedState = stateRepository.save(state);
        return Mappers.fromState(savedState);
    }

    @Override
    public StateDTO editState(StateDTO stateDTO) throws StateNotFondeException {
        State state = stateRepository.findById(stateDTO.getId()).orElseThrow(() -> new StateNotFondeException("state not found"));
        return Mappers.fromState(stateRepository.save(Mappers.updateState(state, stateDTO)));
    }

    @Override
    public void deleteState(Long id) throws StateNotFondeException {
        State state = stateRepository.findById(id).orElseThrow(() -> new StateNotFondeException("state not found"));
        stateRepository.delete(state);
    }
}
