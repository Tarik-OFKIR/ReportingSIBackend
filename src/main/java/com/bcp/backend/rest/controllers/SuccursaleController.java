package com.bcp.backend.rest.controllers;

import com.bcp.backend.dto.SuccursaleDTO;
import com.bcp.backend.exception.BprNotFoundException;
import com.bcp.backend.exception.SuccursaleNotFoundException;
import com.bcp.backend.services.abstractions.SuccursaleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SuccursaleController {

    SuccursaleService succursaleService;

    @GetMapping("/bpr/{code}/succursales")
    List<SuccursaleDTO> getBprSuccursales(@PathVariable("code") Long code) throws BprNotFoundException {
        return succursaleService.getBprSuccursales(code);
    }
    @PostMapping("/addSuccursale")
    SuccursaleDTO addSuccursale(@RequestBody SuccursaleDTO succursaleDTO) throws BprNotFoundException {
        return succursaleService.addSuccursale(succursaleDTO);
    }
    @PutMapping("/updateSuccursale")
    SuccursaleDTO updateSuccursale(@RequestBody SuccursaleDTO succursaleDTO) throws BprNotFoundException, SuccursaleNotFoundException {
        return succursaleService.editSuccursale(succursaleDTO);
    }
    @DeleteMapping("/deleteSuccursale/{id}")
    void deleteSuccursale(@PathVariable Long id) throws BprNotFoundException, SuccursaleNotFoundException {
        succursaleService.deleteSuccursale(id);
    }
}
