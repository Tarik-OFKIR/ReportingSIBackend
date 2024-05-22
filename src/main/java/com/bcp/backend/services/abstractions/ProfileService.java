package com.bcp.backend.services.abstractions;

import com.bcp.backend.dto.ProfileDTO;
import com.bcp.backend.exception.ProfileFoundException;
import com.bcp.backend.exception.ProfileNotFoundException;


import java.util.List;

public interface ProfileService {

    List<ProfileDTO> getAllProfiles();
    List<ProfileDTO> getAgentProfiles(String AgentRegistrationNumber);

    /*admin tasks*/
    ProfileDTO addProfile(ProfileDTO profileDTO)throws ProfileFoundException;
    ProfileDTO editProfile(ProfileDTO profileDTO)throws ProfileNotFoundException;
    void deleteProfile(Long profileId) throws ProfileNotFoundException;
    void addStateToProfile(Long profileId, Long stateId);
}
