package com.bcp.backend.model;

import com.bcp.backend.configuration.enums.Extension;
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
@Table(name = "etat")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Attribute(name = "nom")
    private String name;

    @Attribute(name = "code")
    private String code;

    @Attribute(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Attribute(name = "extension")
    private Extension extension;

    @ManyToMany(mappedBy = "states", fetch = FetchType.LAZY)
    @Attribute(name = "profils")
    private List<Profile> profiles = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @Attribute(name = "application")
    private Application application;


}
