package com.bcp.backend.services.concretions;

import com.bcp.backend.configuration.utils.Mappers;
import com.bcp.backend.dto.ApplicationDTO;
import com.bcp.backend.exception.AgencyNotFoundException;
import com.bcp.backend.exception.ApplicationFoundException;
import com.bcp.backend.exception.ApplicationNotFoundException;

import com.bcp.backend.model.Agency;
import com.bcp.backend.model.Application;
import com.bcp.backend.repository.AgencyRepository;
import com.bcp.backend.repository.ApplicationRepository;
import com.bcp.backend.repository.StateRepository;
import com.bcp.backend.services.abstractions.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private ApplicationRepository applicationRepository;
    private AgencyRepository agencyRepository;
    private StateRepository stateRepository;

    @Override
    public List<ApplicationDTO> getApplications() {
        return applicationRepository.findAll().stream().map(Mappers::fromApplication).collect(Collectors.toList());
    }

    @Override
    public List<ApplicationDTO> getAgencyApplications(Long agencyCode) throws AgencyNotFoundException {
        Agency agency = agencyRepository.findById(agencyCode).orElse(null);
        if (agency == null) throw new AgencyNotFoundException("Agency not found");
        List<Agency> agencies = new ArrayList<>();
        agencies.add(agency);
        List<Application> applications = applicationRepository.findAllByAgenciesIn(agencies);
        if (applications != null) {
            return applications.stream().map(Mappers::fromApplication).collect(Collectors.toList());
        }
        return null;
    }


    @Override
    public ApplicationDTO addApplication(ApplicationDTO applicationDTO) throws ApplicationFoundException {
        Application application = applicationRepository.findByCode(applicationDTO.getCode());
        if (application != null) throw new ApplicationFoundException("Application already exists");
        Application savedApplication = applicationRepository.save(Mappers.fromApplicationDTO(applicationDTO));
        return Mappers.fromApplication(savedApplication);
    }

    @Override
    public ApplicationDTO editApplication(ApplicationDTO applicationDTO) throws ApplicationNotFoundException {
        Application application = applicationRepository.findById(applicationDTO.getId()).orElseThrow(() -> new ApplicationNotFoundException("Application not found"));
        return Mappers.fromApplication(applicationRepository.save(Mappers.updateApplication(application, applicationDTO)));
    }

    @Override
    public void deleteApplication(Long id) throws ApplicationNotFoundException {
        Application application = applicationRepository.findById(id).orElse(null);
        if (application == null) throw new ApplicationNotFoundException("Application not found");
        applicationRepository.delete(application);
    }


}
