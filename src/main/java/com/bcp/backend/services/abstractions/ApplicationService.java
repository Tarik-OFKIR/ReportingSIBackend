package com.bcp.backend.services.abstractions;

import com.bcp.backend.dto.ApplicationDTO;
import com.bcp.backend.exception.AgencyNotFoundException;
import com.bcp.backend.exception.ApplicationFoundException;
import com.bcp.backend.exception.ApplicationNotFoundException;

import java.util.List;

public interface ApplicationService {
    List<ApplicationDTO> getApplications();

    List<ApplicationDTO> getAgencyApplications(Long agencyCode) throws AgencyNotFoundException;
    /*admin tasks*/
    ApplicationDTO addApplication(ApplicationDTO applicationDTO)throws ApplicationFoundException;
    ApplicationDTO editApplication(ApplicationDTO applicationDTO)throws ApplicationNotFoundException;
    void deleteApplication(Long id) throws ApplicationNotFoundException;

}
