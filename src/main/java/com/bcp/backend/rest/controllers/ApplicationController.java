package com.bcp.backend.rest.controllers;

import com.bcp.backend.dto.ApplicationDTO;
import com.bcp.backend.dto.SuccursaleDTO;
import com.bcp.backend.exception.AgencyNotFoundException;
import com.bcp.backend.exception.ApplicationFoundException;
import com.bcp.backend.exception.ApplicationNotFoundException;
import com.bcp.backend.exception.BprNotFoundException;
import com.bcp.backend.services.abstractions.ApplicationService;
import com.bcp.backend.services.abstractions.SuccursaleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ApplicationController {

    ApplicationService applicationService;

    @GetMapping("/applications")
    List<ApplicationDTO> getAllApplication() {
        return applicationService.getApplications();
    }

    @GetMapping("/agence/{code}/Applications")
    List<ApplicationDTO> getAgencyApplications(@PathVariable("code") Long code) throws AgencyNotFoundException {
        return applicationService.getAgencyApplications(code);
    }

    @PostMapping("/addApplication")
    ApplicationDTO addApplication(@RequestBody ApplicationDTO applicationDTO) throws ApplicationFoundException {
        return applicationService.addApplication(applicationDTO);
    }

    @PutMapping("/updateApplication")
    ApplicationDTO updateApplication(@RequestBody ApplicationDTO applicationDTO) throws ApplicationNotFoundException {
        return applicationService.editApplication(applicationDTO);
    }
    @DeleteMapping("/deleteApplication/{id}")
    void deleteApplication(@PathVariable   Long id) throws ApplicationNotFoundException{
        applicationService.deleteApplication(id);
    }
}
