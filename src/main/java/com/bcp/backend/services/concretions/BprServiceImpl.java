package com.bcp.backend.services.concretions;

import com.bcp.backend.configuration.utils.Mappers;
import com.bcp.backend.dto.BprDTO;
import com.bcp.backend.exception.BprExsitException;
import com.bcp.backend.exception.BprNotFoundException;
import com.bcp.backend.exception.rootFoundException;
import com.bcp.backend.model.Bpr;
import com.bcp.backend.repository.BprRepository;
import com.bcp.backend.services.abstractions.BprService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class BprServiceImpl implements BprService {
    private BprRepository bprRepository;

    @Override
    public List<BprDTO> getAllBpr() {
        List<Bpr> bprs = bprRepository.findAll();
        return bprs.stream().map(Mappers::fromBpr).collect(Collectors.toList());
    }

    @Override
    public BprDTO getBprByCode(Long code) throws rootFoundException {
        Bpr bpr = bprRepository.findByCode(code);
        if (bpr == null) throw new rootFoundException("Bpr not found");
        return Mappers.fromBpr(bpr);
    }

    @Override
    public BprDTO addBpr(BprDTO bprDTO) throws BprExsitException {
        Bpr bpr = bprRepository.findByCode(bprDTO.getCode());
        if (bpr != null) throw new BprExsitException("Bpr already exists");
        Bpr savedBpr = bprRepository.save(Mappers.fromBprDTO(bprDTO));
        return Mappers.fromBpr(savedBpr);
    }

    @Override
    public BprDTO editBpr(BprDTO bprDTO) throws BprNotFoundException {
        Bpr bpr = bprRepository.findById(bprDTO.getCode()).orElseThrow(() -> new BprNotFoundException("Bpr not found"));
        return Mappers.fromBpr(bprRepository.save(Mappers.updateBpr(bpr, bprDTO)));
    }

    @Override
    public void deleteBpr(Long code) throws BprNotFoundException {
        Bpr bpr = bprRepository.findById(code).orElseThrow(() -> new BprNotFoundException("Bpr not found"));
        bprRepository.delete(bpr);
    }
}
