package com.bcp.backend.model;

import com.bcp.backend.configuration.enums.Preference;
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
@Table(name = "Profil")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Attribute(name = "nom")
    private String name;

    @Attribute(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Attribute(name = "preference")
    private Preference preference;

    @ManyToMany(mappedBy = "profiles", fetch = FetchType.LAZY)
    @Attribute(name = "agents")
    private List<Agent> agents = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Attribute(name = "etats")
    private List<State> states = new ArrayList<>();


}
