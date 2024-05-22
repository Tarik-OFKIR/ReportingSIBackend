package com.bcp.backend.model;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ldap.odm.annotations.Attribute;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "bprDuplicata")
public class BprDuplicated {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Attribute(name = "code")
    private Long code;

    @Attribute(name = "codeAgence")
    private int codeAgencyDuplicated;

    @ManyToOne
    @Attribute(name = "bpr")
    private Bpr bpr;


}
