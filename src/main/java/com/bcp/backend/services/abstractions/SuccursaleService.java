package com.bcp.backend.services.abstractions;

import com.bcp.backend.dto.SuccursaleDTO;
import com.bcp.backend.exception.BprNotFoundException;
import com.bcp.backend.exception.SuccursaleNotFoundException;

import java.util.List;

public interface SuccursaleService {
    List<SuccursaleDTO> getBprSuccursales(Long bprCode) throws BprNotFoundException;

    /*admin tasks*/
    SuccursaleDTO addSuccursale(SuccursaleDTO succursaleDTO) throws BprNotFoundException;

    SuccursaleDTO editSuccursale(SuccursaleDTO succursale) throws SuccursaleNotFoundException;

    void deleteSuccursale(Long succursaleId) throws SuccursaleNotFoundException;
}
