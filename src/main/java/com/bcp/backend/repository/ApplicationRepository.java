package com.bcp.backend.repository;

import com.bcp.backend.model.Agency;
import com.bcp.backend.model.Agent;
import com.bcp.backend.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    Application findApplicationById(Long applicationId);
    Application findByCode(String code);
    List<Application> findAllByAgenciesIn(List<Agency> agents);

}
