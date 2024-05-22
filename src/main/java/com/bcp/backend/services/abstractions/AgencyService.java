package com.bcp.backend.services.abstractions;

import com.bcp.backend.dto.AgencyDTO;
import com.bcp.backend.exception.AgencyAllreadyExistsException;
import com.bcp.backend.exception.AgencyNotFoundException;
import com.bcp.backend.exception.ApplicationNotFoundException;

import java.util.List;

public interface AgencyService {
    List<AgencyDTO> getBprAgencies(Long BprCode);
    List<AgencyDTO> getSuccursaleAgencies(Long succursaleId);

    /*admin tasks*/

    AgencyDTO addAgency(AgencyDTO agencyDTO) throws Exception;
    AgencyDTO editeAgency(AgencyDTO agencyDTO) throws AgencyNotFoundException;
    void deleteAgency(Long agencyId)throws AgencyNotFoundException;

    void addApplicationToAgency(Long agencyId, Long applicationId) throws AgencyNotFoundException, ApplicationNotFoundException;

}
