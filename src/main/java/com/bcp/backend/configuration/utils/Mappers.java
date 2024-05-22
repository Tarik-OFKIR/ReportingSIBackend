package com.bcp.backend.configuration.utils;

import com.bcp.backend.configuration.enums.AgencyType;
import com.bcp.backend.configuration.enums.Extension;
import com.bcp.backend.configuration.enums.Preference;
import com.bcp.backend.dto.*;
import com.bcp.backend.model.*;

public class Mappers {

    //    agency mapping
    public static AgencyDTO fromAgency(Agency agency) {

        AgencyDTO agencyBuild = AgencyDTO.builder()
                .code(agency.getCode())
                .name(agency.getName())
                .address(agency.getAddress())
                .type(agency.getType().toString())
                .bprId(agency.getBpr().getCode())
                .build();
        if (agency.getSuccursale()!= null)
            agencyBuild.setSuccursaleId(agency.getSuccursale().getId());
        return agencyBuild;
    }

    public static Agency fromAgencyDTO(AgencyDTO agencyDTO) {
        return Agency.builder()
                .code(agencyDTO.getCode())
                .name(agencyDTO.getName())
                .address(agencyDTO.getAddress())
                .type(AgencyType.valueOf(agencyDTO.getType()))
                .succursale(agencyDTO.getSuccursaleId() != null ? Succursale.builder().id(agencyDTO.getSuccursaleId()).build() : null)
                .bpr(agencyDTO.getBprId() != null ? Bpr.builder().code(agencyDTO.getBprId()).build() : null)
                .build();
    }

    public static Agency updateAgency(Agency agency, AgencyDTO agencyDTO) {
        agency.setName(agencyDTO.getName());
        agency.setAddress(agencyDTO.getAddress());
        agency.setType(AgencyType.valueOf(agencyDTO.getType()));
        agency.setSuccursale(agencyDTO.getSuccursaleId() != null ? Succursale.builder().id(agencyDTO.getSuccursaleId()).build() : null);
        agency.setBpr(agencyDTO.getBprId() != null ? Bpr.builder().code(agencyDTO.getBprId()).build() : null);
        return agency;
    }

    //   Agent mapping
    public static AgentDTO fromAgent(Agent agent) {
        return AgentDTO.builder()
                .registrationNumber(agent.getRegistrationNumber())
                .name(agent.getName())
                .agencyCode(agent.getAgency().getCode())
                .build();
    }

    public static Agent fromAgentDTO(AgentDTO agentDTO) {
       return Agent.builder()
               .name(agentDTO.getName())
               .registrationNumber(agentDTO.getRegistrationNumber())
               .agency(Agency.builder().code(agentDTO.getAgencyCode()).build())
               .build();
    }

    public static Agent updateAgent(Agent agent, AgentDTO agentDTO) {
        agent.setName(agentDTO.getName());
        agent.setRegistrationNumber(agentDTO.getRegistrationNumber());
        agent.setAgency(Agency.builder().code(agentDTO.getAgencyCode()).build());
        return agent;
    }

    //   Application mapping
    public static ApplicationDTO fromApplication(Application application) {
        return ApplicationDTO.builder()
                .id(application.getId())
                .code(application.getCode())
                .name(application.getName())
                .build();
    }

    public static Application fromApplicationDTO(ApplicationDTO applicationDTO) {
       return Application.builder()
               .code(applicationDTO.getCode())
               .name(applicationDTO.getName())
               .build();
    }

    public static Application updateApplication(Application application, ApplicationDTO applicationDTO) {
        application.setCode(applicationDTO.getCode());
        application.setName(applicationDTO.getName());
        return application;
    }

    //   State mapping
    public static StateDTO fromState(State state) {
        return StateDTO.builder()
                .id(state.getId())
                .name(state.getName())
                .applicationId(state.getApplication().getId())
                .description(state.getDescription())
                .extension(String.valueOf(state.getExtension()))
                .build();
    }

    public static State fromStateDTO(StateDTO stateDTO) {
        return State.builder()
                .name(stateDTO.getName())
                .description(stateDTO.getDescription())
                .extension(Extension.valueOf(stateDTO.getExtension()))
                .application(Application.builder().id(stateDTO.getApplicationId()).build())
                .build();
    }

    public static State updateState(State state, StateDTO stateDTO) {
        state.setName(stateDTO.getName());
        state.setDescription(stateDTO.getDescription());
        state.setExtension(Extension.valueOf(stateDTO.getExtension()));
        state.setApplication(Application.builder().id(stateDTO.getApplicationId()).build());
        return state;
    }

    //    Bpr mapping
    public static BprDTO fromBpr(Bpr bpr) {
        return BprDTO.builder()
                .code(bpr.getCode())
                .name(bpr.getName())
                .address(bpr.getAddress())
                .build();
    }

    public static Bpr fromBprDTO(BprDTO bprDTO) {
        return Bpr.builder()
                .code(bprDTO.getCode())
                .name(bprDTO.getName())
                .address(bprDTO.getAddress())
                .build();
    }
    public static Bpr updateBpr(Bpr bpr, BprDTO bprDTO) {
        bpr.setName(bprDTO.getName());
        bpr.setAddress(bprDTO.getAddress());
        return bpr;
    }

    //    BPRDuplicated mapping
    public static BPRDuplicatedDTO fromBprDuplicated(BprDuplicated bprDuplicated) {
        return BPRDuplicatedDTO.builder()
                .id(bprDuplicated.getId())
                .bprId(bprDuplicated.getBpr().getCode())
                .code(bprDuplicated.getCode())
                .codeAgencyDuplicated(bprDuplicated.getCodeAgencyDuplicated())
                .build();
    }

    public static BprDuplicated fromBprDuplicatedDTO(BPRDuplicatedDTO bprDuplicatedDTO) {
       return BprDuplicated.builder()
                .id(bprDuplicatedDTO.getId())
               .code(bprDuplicatedDTO.getCode())
               .bpr(Bpr.builder().code(bprDuplicatedDTO.getBprId()).build())
               .codeAgencyDuplicated(bprDuplicatedDTO.getCodeAgencyDuplicated())
               .build();
    }
    public static BprDuplicated updateBprDuplicated(BprDuplicated bprDuplicated, BPRDuplicatedDTO bprDuplicatedDTO) {
        bprDuplicated.setCode(bprDuplicatedDTO.getCode());
        bprDuplicated.setBpr(Bpr.builder().code(bprDuplicatedDTO.getBprId()).build());
        bprDuplicated.setCodeAgencyDuplicated(bprDuplicatedDTO.getCodeAgencyDuplicated());
        return bprDuplicated;
    }

    //    Profile mapping
    public static ProfileDTO fromProfile(Profile profile) {
        return ProfileDTO.builder()
                .id(profile.getId())
                .name(profile.getName())
                .preference(String.valueOf(profile.getPreference()))
                .description(profile.getDescription())
                .build();
    }

    public static Profile fromProfileDTO(ProfileDTO profileDTO) {
        return Profile.builder()
                .name(profileDTO.getName())
                .preference(Preference.valueOf(profileDTO.getPreference()))
                .description(profileDTO.getDescription())
                .build();
    }

    public static Profile updateProfile(Profile profile, ProfileDTO profileDTO) {
        profile.setName(profileDTO.getName());
        profile.setPreference(Preference.valueOf(profileDTO.getPreference()));
        profile.setDescription(profileDTO.getDescription());
        return profile;
    }



    //    Succursale mapping
    public static SuccursaleDTO fromSuccursale(Succursale succursale) {
        return SuccursaleDTO.builder()
                .id(succursale.getId())
                .name(succursale.getName())
                .code(succursale.getCode())
                .bprId(succursale.getBpr().getCode())
                .build();
    }

    public static Succursale fromSuccursaleDTO(SuccursaleDTO succursaleDTO) {
        return  Succursale.builder()
                .id(succursaleDTO.getId())
                .name(succursaleDTO.getName())
                .code(succursaleDTO.getCode())
                .bpr(Bpr.builder().code(succursaleDTO.getBprId()).build())
                .build();
    }
    public static Succursale updateSuccursale(Succursale succursale, SuccursaleDTO succursaleDTO) {
        succursale.setName(succursaleDTO.getName());
        succursale.setCode(succursaleDTO.getCode());
        succursale.setBpr(Bpr.builder().code(succursaleDTO.getBprId()).build());
        return succursale;
    }
}
