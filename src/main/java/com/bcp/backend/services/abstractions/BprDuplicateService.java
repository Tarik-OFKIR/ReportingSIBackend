package com.bcp.backend.services.abstractions;

import com.bcp.backend.dto.BPRDuplicatedDTO;
import com.bcp.backend.exception.BprDuplicatedExicetException;
import com.bcp.backend.exception.BprDuplicatedNotExicetException;

import java.util.List;

public interface BprDuplicateService {

    List<BPRDuplicatedDTO> getAllBprDuplicated();
    BPRDuplicatedDTO getBprDuplicated(Long id) throws BprDuplicatedExicetException;

    // admin tasks
    BPRDuplicatedDTO addBprDuplicated(BPRDuplicatedDTO bprDuplicatedDTO) throws BprDuplicatedExicetException;
    BPRDuplicatedDTO editBprDuplicated(BPRDuplicatedDTO bprDuplicatedDTO) throws BprDuplicatedNotExicetException;
    void deleteBprDuplicated(Long id);
}
