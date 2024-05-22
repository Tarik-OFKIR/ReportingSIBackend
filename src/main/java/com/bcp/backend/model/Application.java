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
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Attribute(name = "code")
    private String code;
    @Attribute(name = "nom")
    private String name;
    @OneToMany(mappedBy = "application", fetch = FetchType.LAZY)
    @Attribute(name = "etats")
    private List<State> states = new ArrayList<>();
    @ManyToMany(mappedBy = "applications",fetch = FetchType.LAZY)
    private @Attribute(name = "agences") List<Agency> agencies = new ArrayList<>();
}
