package com.bcp.backend.model;

import com.bcp.backend.configuration.enums.AgencyType;
import jakarta.annotation.Nullable;
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
@Table(name = "agence")
public class Agency {
    // Agency doesn't have a unique identifier I need to creat a new attribute id for that
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Attribute(name = "code")
    private Long code;
    @Attribute(name = "nom")
    private String name;
    @Attribute(name = "adresse")
    private String address;
    @Enumerated(EnumType.STRING)
    private AgencyType type;
    @OneToMany(mappedBy = "agency", fetch = FetchType.LAZY)
    @Attribute(name = "agent")
    private List<Agent> agent = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @Attribute(name = "application")
    private List<Application> applications = new ArrayList<>();
    @ManyToOne
    @Attribute(name = "succursale")
    private Succursale succursale;
    @ManyToOne
    @Attribute(name = "bpr")
    private Bpr bpr;

}
