package com.bcp.backend.rest.controllers;

import com.bcp.backend.dto.BPRDuplicatedDTO;
import com.bcp.backend.exception.BprDuplicatedExicetException;
import com.bcp.backend.exception.BprDuplicatedNotExicetException;
import com.bcp.backend.services.abstractions.BprDuplicateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BprDuplicatedController {
   BprDuplicateService bprDuplicatedServiceImp;

    @GetMapping("/ListBps")
    public List<BPRDuplicatedDTO> getAllBprDuplicated(){
        return bprDuplicatedServiceImp.getAllBprDuplicated();
    }

    @GetMapping("/Bps/{id}")
    public BPRDuplicatedDTO getBprDuplicated(@PathVariable Long id) throws BprDuplicatedExicetException {
        return bprDuplicatedServiceImp.getBprDuplicated(id);
    }

    @PostMapping("/addBps")
    public BPRDuplicatedDTO addBprDuplicated(@RequestBody BPRDuplicatedDTO bprDuplicatedDTO) throws BprDuplicatedExicetException {
        return bprDuplicatedServiceImp.addBprDuplicated(bprDuplicatedDTO);
    }

    @PutMapping("/updateBps")
    public BPRDuplicatedDTO editBprDuplicated(@RequestBody BPRDuplicatedDTO bprDuplicatedDTO) throws BprDuplicatedNotExicetException {
        return bprDuplicatedServiceImp.editBprDuplicated(bprDuplicatedDTO);
    }

    @DeleteMapping("/deleteBps/{id}")
    public void deleteBprDuplicated(@PathVariable Long id){
        bprDuplicatedServiceImp.deleteBprDuplicated(id);
    }
}
