package com.bcp.backend.rest.controllers;

import com.bcp.backend.exception.AgencyNotFoundException;
import com.bcp.backend.exception.BprDuplicatedNotExicetException;
import com.bcp.backend.exception.DirectoryNotExitException;
import com.bcp.backend.exception.ExtensionNotExicetException;
import com.bcp.backend.rest.request.StatRequest;
import com.bcp.backend.rest.response.StateResponse;
import com.bcp.backend.services.abstractions.ReportingSIService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReportingSIController {
    ReportingSIService reportingSIService;
    @GetMapping("/generateCodeAgence/{id}")
    public String generateCodeAgency(@PathVariable Long id) throws AgencyNotFoundException, BprDuplicatedNotExicetException {
        return reportingSIService.generateCodeAgency(id);
    }

    @PostMapping("/folderPath")
    public List<StateResponse> extractFolderPath(@RequestBody StatRequest statRequest) throws DirectoryNotExitException, ExtensionNotExicetException {
        return reportingSIService.files(statRequest);
    }
}
