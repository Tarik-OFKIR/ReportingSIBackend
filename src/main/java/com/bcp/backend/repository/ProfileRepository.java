package com.bcp.backend.repository;

import com.bcp.backend.model.Agent;
import com.bcp.backend.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findByName(String name);
    List<Profile> findAllByAgentsIn(List<Agent> agents);

}
