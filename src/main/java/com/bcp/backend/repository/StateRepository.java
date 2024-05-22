package com.bcp.backend.repository;

import com.bcp.backend.model.Profile;
import com.bcp.backend.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Long> {
//    State findById(Long id);
    State findByName(String name);
    List<State> findByApplicationId(Long applicationId);
    List<State> findAllByProfilesIn(List<Profile> profiles);

}
