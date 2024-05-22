package com.bcp.backend.rest.controllers;

import com.bcp.backend.dto.BprDTO;
import com.bcp.backend.exception.BprExsitException;
import com.bcp.backend.exception.BprNotFoundException;
import com.bcp.backend.model.Bpr;
import com.bcp.backend.services.abstractions.BprService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BarController {
    BprService bprService;
    @GetMapping("/bprs")
    List<BprDTO> getAllBpr(){
        return bprService.getAllBpr();
    }

    @PostMapping("/addBpr")
    BprDTO addBpr(@RequestBody BprDTO bprDTO) throws BprExsitException {
        return bprService.addBpr(bprDTO);
    }

    @PutMapping("/updateBpr")
    BprDTO updateBpr(@RequestBody BprDTO bprDTO) throws BprNotFoundException {
        return bprService.editBpr(bprDTO);
    }
    @DeleteMapping("/deleteBpr/{code}")
    void deleteBpr(@PathVariable Long code) throws BprNotFoundException {
        bprService.deleteBpr(code);
    }
}
