package com.bcp.backend.rest.controllers;

import com.bcp.backend.dto.AgentDTO;
import com.bcp.backend.exception.AgentNotFoundException;
import com.bcp.backend.services.abstractions.AgentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AgentController {
    AgentService agentService;
    @GetMapping("/agents")
    public List<AgentDTO> getAgents(){
        return agentService.getAllAgents();
    }
    @PostMapping("/addAgent")
    public AgentDTO addAgent(@RequestBody AgentDTO agentDTO, @RequestParam Long agencyCode) throws AgentNotFoundException {
        return agentService.addAgent(agentDTO, agencyCode);
    }
    @PostMapping("/addProfileToAgent")
    public void addProfileToAgent(@RequestParam String registrationNumber, @RequestParam Long profileId) throws AgentNotFoundException {
        agentService.addProfileToAgent(registrationNumber, profileId);
    }
    @PutMapping("/updateAgent")
    public AgentDTO updateAgent(@RequestBody AgentDTO agentDTO) throws AgentNotFoundException {
        return agentService.editAgent(agentDTO);
    }
    @DeleteMapping("/deleteAgent/{registrationNumber}")
    public void deleteAgent(@PathVariable String registrationNumber) throws AgentNotFoundException {
        agentService.deleteAgent(registrationNumber);
    }
}
