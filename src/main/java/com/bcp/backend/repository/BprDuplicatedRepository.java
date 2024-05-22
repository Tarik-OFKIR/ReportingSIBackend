package com.bcp.backend.repository;

import com.bcp.backend.model.BprDuplicated;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BprDuplicatedRepository extends JpaRepository<BprDuplicated, Long> {


    BprDuplicated findByCode(Long code);
    List<BprDuplicated> findByBprCode(Long bprCode);
}
