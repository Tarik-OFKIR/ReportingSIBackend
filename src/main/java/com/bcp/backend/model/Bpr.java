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
@Table(name = "bpr")
public class Bpr {
    @Id
    @Attribute(name = "code")
    private Long code;

    @Attribute(name = "nom")
    private String name;

    @Attribute(name = "adresse")
    private String address;

    @OneToMany(mappedBy = "bpr", fetch = FetchType.LAZY)
    @Attribute(name = "bprDuplicata")
    private List<BprDuplicated> bprDuplicates = new ArrayList<>();

    @OneToMany(mappedBy = "bpr", fetch = FetchType.LAZY)
    @Attribute(name = "agences")
    private List<Agency> agencies = new ArrayList<>();

    @OneToMany(mappedBy = "bpr", fetch = FetchType.LAZY)
    @Attribute(name = "succursales")
    private List<Succursale> succursales = new ArrayList<>();

}
