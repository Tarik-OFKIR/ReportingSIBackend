package com.bcp.backend.services.abstractions;

import com.bcp.backend.exception.AgencyNotFoundException;
import com.bcp.backend.exception.BprDuplicatedNotExicetException;
import com.bcp.backend.exception.DirectoryNotExitException;
import com.bcp.backend.exception.ExtensionNotExicetException;
import com.bcp.backend.rest.request.StatRequest;
import com.bcp.backend.rest.response.StateResponse;

import java.util.List;

public interface ReportingSIService {
    String generateCodeAgency(Long idAgency) throws AgencyNotFoundException, BprDuplicatedNotExicetException;
    List<StateResponse> files(StatRequest statRequest) throws DirectoryNotExitException, ExtensionNotExicetException;
}
