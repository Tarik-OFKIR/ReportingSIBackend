package com.bcp.backend.services.concretions;

import com.bcp.backend.configuration.utils.Mappers;
import com.bcp.backend.dto.SuccursaleDTO;
import com.bcp.backend.exception.BprNotFoundException;
import com.bcp.backend.exception.SuccursaleNotFoundException;
import com.bcp.backend.model.Bpr;
import com.bcp.backend.model.Succursale;
import com.bcp.backend.repository.BprRepository;
import com.bcp.backend.repository.SuccursaleRepository;
import com.bcp.backend.services.abstractions.SuccursaleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class SuccursaleServiceImpl implements SuccursaleService {
    private SuccursaleRepository succursaleRepository;
    private BprRepository bprRepository;

    @Override
    public List<SuccursaleDTO> getBprSuccursales(Long bprCode) throws BprNotFoundException {
        List<Succursale> succulence = succursaleRepository.findByBprCode(bprCode);
        return succulence.stream().map(Mappers::fromSuccursale).collect(Collectors.toList());
    }

    @Override
    public SuccursaleDTO addSuccursale(SuccursaleDTO succursaleDTO) throws BprNotFoundException {
        Bpr bpr = bprRepository.findById(succursaleDTO.getBprId()).orElseThrow(() -> new BprNotFoundException("Bpr not found"));
        Succursale succursale = Mappers.fromSuccursaleDTO(succursaleDTO);
        succursale.setBpr(bpr);
        Succursale savedSuccursale = succursaleRepository.save(succursale);
        return Mappers.fromSuccursale(savedSuccursale);
    }

    @Override
    public SuccursaleDTO editSuccursale(SuccursaleDTO succursaleDTO) throws SuccursaleNotFoundException{
        Succursale succursale = succursaleRepository.findById(succursaleDTO.getId()).orElseThrow(() -> new SuccursaleNotFoundException("Succursale not found"));
        return Mappers.fromSuccursale(succursaleRepository.save(Mappers.updateSuccursale(succursale, succursaleDTO)));
    }

    @Override
    public void deleteSuccursale(Long succursaleId) throws SuccursaleNotFoundException {
        Succursale succursale = succursaleRepository.findById(succursaleId).orElseThrow(() -> new SuccursaleNotFoundException("Succursale not found"));
        succursaleRepository.delete(succursale);
    }
}
