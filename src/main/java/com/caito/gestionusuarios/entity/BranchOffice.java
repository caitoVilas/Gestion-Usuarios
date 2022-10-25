package com.caito.gestionusuarios.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "branch_offices")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BranchOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchOffoceId;
    private String code;
    private String description;
}
