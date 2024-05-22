package com.bcp.backend.services.abstractions;

import com.bcp.backend.dto.BprDTO;
import com.bcp.backend.exception.BprExsitException;
import com.bcp.backend.exception.BprNotFoundException;
import com.bcp.backend.exception.rootFoundException;

import java.util.List;

public interface BprService {

    List<BprDTO> getAllBpr();

    BprDTO getBprByCode(Long code)throws rootFoundException;

    /*admin tasks*/
    BprDTO addBpr(BprDTO bprDTO) throws BprExsitException;

    BprDTO editBpr(BprDTO bprDTO) throws BprNotFoundException;

    void deleteBpr(Long code) throws BprNotFoundException;

}
