package com.bcp.backend.services.abstractions;

import com.bcp.backend.dto.StateDTO;
import com.bcp.backend.exception.ApplicationNotFoundException;
import com.bcp.backend.exception.ProfileNotFoundException;
import com.bcp.backend.exception.StateNotFondeException;

import java.util.List;

public interface StateService {
    List<StateDTO> getApplicationStates(Long applicationId);
    List<StateDTO> getProfileStates(Long profileId) throws ProfileNotFoundException;
    /* admin tasks */
    StateDTO addState(StateDTO stateDTO) throws StateNotFondeException, ApplicationNotFoundException;

    StateDTO editState(StateDTO stateDTO) throws StateNotFondeException;
    void deleteState(Long id) throws StateNotFondeException;

}
