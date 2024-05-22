package com.bcp.backend.rest.controllers;

import com.bcp.backend.dto.BprDTO;
import com.bcp.backend.dto.StateDTO;
import com.bcp.backend.exception.ApplicationNotFoundException;
import com.bcp.backend.exception.StateNotFondeException;
import com.bcp.backend.services.abstractions.BprService;
import com.bcp.backend.services.abstractions.StateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StateController {
    StateService stateService;

    @GetMapping("/application/{code}/stats")
    public List<StateDTO> getApplicationStates(@PathVariable("code") Long code) {
        return stateService.getApplicationStates(code);
    }

    @PostMapping("/addState")
    public StateDTO addState(@RequestBody StateDTO stateDTO) throws ApplicationNotFoundException, StateNotFondeException {
        return stateService.addState(stateDTO);
    }

    @PutMapping("/updateState")
    public StateDTO updateState(@RequestBody StateDTO stateDTO) throws StateNotFondeException {
        return stateService.editState(stateDTO);
    }

    @DeleteMapping("/deleteState/{id}")
    public void deleteState(@PathVariable Long id) throws StateNotFondeException {
        stateService.deleteState(id);
    }
}
