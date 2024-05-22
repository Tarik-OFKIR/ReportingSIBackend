package com.bcp.backend.services.concretions;

import com.bcp.backend.configuration.utils.Mappers;
import com.bcp.backend.dto.BPRDuplicatedDTO;
import com.bcp.backend.exception.BprDuplicatedExicetException;
import com.bcp.backend.exception.BprDuplicatedNotExicetException;
import com.bcp.backend.model.BprDuplicated;
import com.bcp.backend.repository.BprDuplicatedRepository;
import com.bcp.backend.services.abstractions.BprDuplicateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class BprDuplicatedServiceImp implements BprDuplicateService {
    private BprDuplicatedRepository bprDuplicatedRepository;

    @Override
    public List<BPRDuplicatedDTO> getAllBprDuplicated() {
        List<BprDuplicated> bprDuplicated = bprDuplicatedRepository.findAll();
        return bprDuplicated.stream().map(Mappers::fromBprDuplicated).collect(Collectors.toList());
    }

    @Override
    public BPRDuplicatedDTO getBprDuplicated(Long id) throws BprDuplicatedExicetException {
        return Mappers.fromBprDuplicated(bprDuplicatedRepository.findById(id).orElseThrow(() -> new BprDuplicatedExicetException("Bpr Duplicated not found")));
    }

    @Override
    public BPRDuplicatedDTO addBprDuplicated(BPRDuplicatedDTO bprDuplicatedDTO) throws BprDuplicatedExicetException {
        BprDuplicated duplicated =  bprDuplicatedRepository.findByCode(bprDuplicatedDTO.getCode());
        if (duplicated != null) {
            throw new BprDuplicatedExicetException("Bpr Duplicated already exist");
        }
        return Mappers.fromBprDuplicated(bprDuplicatedRepository.save(Mappers.fromBprDuplicatedDTO(bprDuplicatedDTO)));
    }

    @Override
    public BPRDuplicatedDTO editBprDuplicated(BPRDuplicatedDTO bprDuplicatedDTO) throws BprDuplicatedNotExicetException {
        BprDuplicated bprDuplicated = bprDuplicatedRepository.findByCode(bprDuplicatedDTO.getCode());
        if (bprDuplicated == null) {
            throw new BprDuplicatedNotExicetException("Bpr Duplicated not found");
        }
        return Mappers.fromBprDuplicated(bprDuplicatedRepository.save(Mappers.updateBprDuplicated(bprDuplicated, bprDuplicatedDTO)));
    }

    @Override
    public void deleteBprDuplicated(Long id) {
        bprDuplicatedRepository.deleteById(id);
    }
}
