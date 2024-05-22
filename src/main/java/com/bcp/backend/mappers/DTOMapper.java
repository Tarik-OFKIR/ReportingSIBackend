package com.bcp.backend.mappers;

import com.bcp.backend.dto.*;
import com.bcp.backend.model.*;
import org.springframework.beans.BeanUtils;


public class DTOMapper {
    public Agency fromAgencyDTO(AgencyDTO agencyDTO){
        Agency agency = new Agency();
        BeanUtils.copyProperties(agencyDTO, agency);
//        agency.setApplication(fromApplicationDTO(agencyDTO.getApplicationDTOS());
//        agency.setBpr(fromBprDTO(agencyDTO.getBprId()));
//        agency.setSuccursale(fromSuccursaleDTO(agencyDTO.getSuccursaleId());
        return agency;
    }
    public AgencyDTO fromAgency(Agency agency){
        AgencyDTO agencyDTO = new AgencyDTO();
        BeanUtils.copyProperties(agency, agencyDTO);
        agencyDTO.setBprId(agency.getBpr().getCode());
        if (agency.getSuccursale() != null)
            agencyDTO.setSuccursaleId(agency.getSuccursale().getId());
        return agencyDTO;
    }
    public Agent fromAgentDTO(AgentDTO agentDTO){
        Agent agent = new Agent();
        BeanUtils.copyProperties(agentDTO, agent);
        return agent;
    }
    public AgentDTO fromAgent(Agent agent){
        AgentDTO agentDTO = new AgentDTO();
        BeanUtils.copyProperties(agent, agentDTO);
        return agentDTO;
    }
    public Application fromApplicationDTO(ApplicationDTO applicationDTO){
        Application application = new Application();
        BeanUtils.copyProperties(applicationDTO, application);
        return application;
    }

    public ApplicationDTO fromApplication(Application application){
        ApplicationDTO applicationDTO = new ApplicationDTO();
        BeanUtils.copyProperties(application, applicationDTO);
        return applicationDTO;
    }

    public Bpr fromBprDTO(BprDTO bprDTO){
        Bpr bpr = new Bpr();
        BeanUtils.copyProperties(bprDTO, bpr);
        return bpr;
    }
    public BprDTO fromBpr(Bpr bpr){
        BprDTO bprDTO = new BprDTO();
        BeanUtils.copyProperties(bpr, bprDTO);
        return bprDTO;
    }

    public BprDuplicated fromBprDuplicatedDTO(BprDTO bprDTO){
        BprDuplicated bprDuplicated = new BprDuplicated();
        BeanUtils.copyProperties(bprDTO, bprDuplicated);
        bprDuplicated.setBpr(fromBprDTO(bprDTO));
        return bprDuplicated;
    }

    public BPRDuplicatedDTO fromBprDuplicated(BprDuplicated bprDuplicated){
        BPRDuplicatedDTO bprDuplicatedDTO = new BPRDuplicatedDTO();
        BeanUtils.copyProperties(bprDuplicated, bprDuplicatedDTO);
        bprDuplicatedDTO.setBprId(bprDuplicated.getBpr().getCode());
        return bprDuplicatedDTO;
    }

    public  Profile fromProfileDTO(ProfileDTO profileDTO){
        Profile profile = new Profile();
        BeanUtils.copyProperties(profileDTO, profile);
        return profile;
    }

    public ProfileDTO fromProfile(Profile profile){
        ProfileDTO profileDTO = new ProfileDTO();
        BeanUtils.copyProperties(profile, profileDTO);
        return profileDTO;
    }

    public State fromStateDTO(StateDTO stateDTO){
        State state = new State();
        BeanUtils.copyProperties(stateDTO, state);
        return state;
    }
    public StateDTO fromState(State state){
        StateDTO stateDTO = new StateDTO();
        BeanUtils.copyProperties(state, stateDTO);
        stateDTO.setApplicationId(state.getApplication().getId());
        return stateDTO;
    }

    public Succursale fromSuccursaleDTO(SuccursaleDTO succursaleDTO){
        Succursale succursale = new Succursale();
        BeanUtils.copyProperties(succursaleDTO, succursale);
        return succursale;
    }

    public SuccursaleDTO fromSuccursale(Succursale succursale){
        SuccursaleDTO succursaleDTO = new SuccursaleDTO();
        BeanUtils.copyProperties(succursale, succursaleDTO);
        succursaleDTO.setBprId(succursale.getBpr().getCode());
        return succursaleDTO;
    }
}
