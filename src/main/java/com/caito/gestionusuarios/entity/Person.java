package com.caito.gestionusuarios.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "persons")
@SQLDelete(sql = "UPDATE persons SET deleted=true WHERE personId=?")
@Where(clause = "deleted=false")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private String surname;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "documentType")
    private DocumentType documentType;
    @Column(length = 8, nullable = false, unique = true)
    private String documentNumber;
    @Column(length = 1, nullable = false)
    private String gender;
    @Column(length = 10)
    private String dateOfBirth;
    @Column(length = 11, nullable = false, unique = true)
    private String cuit;
    @Column(length = 10)
    private String telephone;
    @Column(length = 70, nullable = false, unique = true)
    private String email;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
    private boolean deleted;

}
