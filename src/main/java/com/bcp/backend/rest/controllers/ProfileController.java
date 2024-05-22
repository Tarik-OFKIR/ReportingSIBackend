package com.bcp.backend.rest.controllers;

import com.bcp.backend.dto.ProfileDTO;
import com.bcp.backend.exception.ProfileFoundException;
import com.bcp.backend.exception.ProfileNotFoundException;
import com.bcp.backend.services.abstractions.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProfileController {
    ProfileService profileService;
    @GetMapping("/profiles")
    public List<ProfileDTO> getProfiles(@RequestParam String agentRegistrationNumber){
        return profileService.getAgentProfiles(agentRegistrationNumber);
    }
    @PostMapping("/addProfile")
    public ProfileDTO addProfile(@RequestBody ProfileDTO profileDTO) throws ProfileFoundException {
        return profileService.addProfile(profileDTO);
    }
    @PostMapping("/addStateToProfile/{stateId}")
    public void addStateToProfile(@RequestParam Long profileId, @PathVariable Long stateId){
        profileService.addStateToProfile(profileId, stateId);
    }

    @PutMapping("/updateProfile")
    public ProfileDTO updateProfile(@RequestBody ProfileDTO profileDTO) throws ProfileFoundException {
        try {
            return profileService.editProfile(profileDTO);
        } catch (ProfileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/deleteProfile/{id}")
    public void deleteProfile(@PathVariable Long id) throws ProfileNotFoundException {
        profileService.deleteProfile(id);
    }
}
