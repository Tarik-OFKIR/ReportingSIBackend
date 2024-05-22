package com.bcp.backend.services.concretions;

import com.bcp.backend.configuration.utils.Mappers;
import com.bcp.backend.dto.AgencyDTO;
import com.bcp.backend.exception.AgencyAllreadyExistsException;
import com.bcp.backend.exception.AgencyNotFoundException;
import com.bcp.backend.exception.ApplicationNotFoundException;
import com.bcp.backend.model.Agency;
import com.bcp.backend.model.Application;
import com.bcp.backend.model.Bpr;
import com.bcp.backend.repository.AgencyRepository;
import com.bcp.backend.repository.ApplicationRepository;
import com.bcp.backend.repository.BprRepository;
import com.bcp.backend.repository.SuccursaleRepository;
import com.bcp.backend.services.abstractions.AgencyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class AgencyServiceImpl implements AgencyService {
    private AgencyRepository agencyRepository;
    private BprRepository bprRepository;
    private SuccursaleRepository succursaleRepository;
    private ApplicationRepository applicationRepository;

    @Override
    public List<AgencyDTO> getBprAgencies(Long BprCode) {
        List<Agency> agencies = agencyRepository.findByBprCode(BprCode);
        return agencies.stream().map(Mappers::fromAgency).collect(Collectors.toList());
    }


    @Override
    public List<AgencyDTO> getSuccursaleAgencies(Long succursaleId) {
        List<Agency> agencies = agencyRepository.findBySuccursaleId(succursaleId);
        return agencies.stream().map(Mappers::fromAgency).collect(Collectors.toList());
    }

    @Override //TODO: need to make condition if code succursale has been initialized to shack if under code bpr
    public AgencyDTO addAgency(AgencyDTO agencyDTO) throws Exception {
        if (agencyRepository.findById(agencyDTO.getCode()).isPresent())
            throw new AgencyAllreadyExistsException("Agency already exists");
        Bpr bpr = bprRepository.findById(agencyDTO.getBprId()).orElseThrow(() -> new Exception("Bpr not found"));

        if(bpr.getSuccursales().stream().noneMatch(succursale -> succursale.getCode().equals(agencyDTO.getSuccursaleId())))
            throw new Exception("Succursale not found under this Bpr");

        Agency agency = Mappers.fromAgencyDTO(agencyDTO);
        Agency savedAgency = agencyRepository.save(agency);
        return Mappers.fromAgency(savedAgency);
    }

    @Override //TODO: need to make condition if code succursale has been change need to shack if under code bpr
    public AgencyDTO editeAgency(AgencyDTO agencyDTO) throws AgencyNotFoundException {
        Agency agency = agencyRepository.findById(agencyDTO.getCode()).orElseThrow(() -> new AgencyNotFoundException("Agency not found"));
        return Mappers.fromAgency(agencyRepository.save(Mappers.updateAgency(agency, agencyDTO)));
    }

    @Override//todo: need find a way to delete all agents under bpr or succursale
    public void deleteAgency(Long agencyId) throws AgencyNotFoundException {
        Agency agency = agencyRepository.findById(agencyId).orElse(null);
        if (agency == null) throw new AgencyNotFoundException("Agency not found");
        agencyRepository.delete(agency);
    }

    @Override
    public void addApplicationToAgency(Long agencyId, Long applicationId) throws AgencyNotFoundException, ApplicationNotFoundException {
        Agency agency = agencyRepository.findById(agencyId).orElse(null);
        if (agency == null) throw new AgencyNotFoundException("Agency not found");
        Application application = applicationRepository.findById(applicationId).orElse(null);
        if (application == null) throw new ApplicationNotFoundException("Application not found");
        if (agency.getApplications() != null) {
            agency.getApplications().add(application);
        }

    }
}
