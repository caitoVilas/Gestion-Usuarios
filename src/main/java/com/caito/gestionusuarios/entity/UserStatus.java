package com.caito.gestionusuarios.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_status")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userStatusId;
    @Column(length = 50, unique = true, nullable = false)
    private String description;
    @Column(length = 2, unique = true, nullable = false)
    private String code;
}
