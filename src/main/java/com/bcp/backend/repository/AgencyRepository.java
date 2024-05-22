package com.bcp.backend.repository;

import com.bcp.backend.model.Agency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AgencyRepository extends JpaRepository<Agency, Long> {

//    Optional<Agency> findById(Long agencyId);

    Agency findByCode(Long agencyCode);
    List<Agency> findByBprCode(Long bprCode);
    List<Agency> findBySuccursaleId( Long succursaleId);

}
