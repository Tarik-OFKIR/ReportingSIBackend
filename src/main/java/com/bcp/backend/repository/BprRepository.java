package com.bcp.backend.repository;

import com.bcp.backend.model.Bpr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BprRepository extends JpaRepository<Bpr, Long> {
    Bpr findByCode(Long bprCode);
}
