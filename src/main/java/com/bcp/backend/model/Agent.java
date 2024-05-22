package com.bcp.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ldap.odm.annotations.Attribute;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "agent")
public class Agent {
    @Id
    @Attribute(name = "matricule")
    private String registrationNumber;

    @Attribute(name = "nom")
    private String name;

    @ManyToOne
    @Attribute(name = "agence")
    private Agency agency;

    @ManyToMany(fetch = FetchType.EAGER)
    @Attribute(name = "profil")
    private List<Profile> profiles = new ArrayList<>();
}
