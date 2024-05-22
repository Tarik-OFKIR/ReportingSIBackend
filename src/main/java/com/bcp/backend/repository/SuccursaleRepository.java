package com.bcp.backend.repository;

import com.bcp.backend.model.Succursale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuccursaleRepository extends JpaRepository<Succursale, Long> {

    Succursale findByCode(int code);
    List<Succursale> findByBprCode(Long bprCode);

}
