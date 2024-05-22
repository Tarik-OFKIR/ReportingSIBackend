package com.bcp.backend.rest.controllers;

import com.bcp.backend.dto.AgencyDTO;
import com.bcp.backend.exception.AgencyNotFoundException;
import com.bcp.backend.exception.ApplicationNotFoundException;
import com.bcp.backend.exception.BprNotFoundException;
import com.bcp.backend.exception.SuccursaleNotFoundException;
import com.bcp.backend.services.abstractions.AgencyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AgencyController {
    AgencyService agencyService;

    @GetMapping("/bpr/{code}/agencies")
    public List<AgencyDTO> getBprAgencies(@PathVariable("code") Long code){
        return agencyService.getBprAgencies(code);
    }

    @GetMapping("/succursale/{id}/agencies")
    public List<AgencyDTO> getSuccursaleAgencies(@PathVariable Long id)  {
        return agencyService.getSuccursaleAgencies(id);
    }

    @PostMapping("/addApplicationToAgency")
    public void addApplicationToAgency(@RequestParam Long agencyId, @RequestParam Long applicationId) throws AgencyNotFoundException, ApplicationNotFoundException {
        agencyService.addApplicationToAgency(agencyId, applicationId);
    }

    @PostMapping("/addAgency")
    public AgencyDTO addAgency(@RequestBody AgencyDTO agencyDTO) throws Exception {
        return agencyService.addAgency(agencyDTO);
    }

    @PutMapping("/updateAgency")
    public AgencyDTO updateAgency(@RequestBody AgencyDTO agencyDTO) throws AgencyNotFoundException {
        return agencyService.editeAgency(agencyDTO);
    }

    @DeleteMapping("/deleteAgency/{id}")
    public void deleteAgency(@PathVariable Long id) throws AgencyNotFoundException {
        agencyService.deleteAgency(id);
    }

}
