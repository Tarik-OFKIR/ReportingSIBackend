package com.bcp.backend.model;

import jakarta.persistence.Entity;
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
@Table(name = "succursale")
public class Succursale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Attribute(name = "nom")
    private String name;

    @Attribute(name = "code")
    private Long code;

    @ManyToOne
    @Attribute(name = "bpr")
    private Bpr bpr;

    @OneToMany(mappedBy = "succursale", fetch = FetchType.LAZY)
    @Attribute(name = "agences")
    private List<Agency> agencies = new ArrayList<>();

}
