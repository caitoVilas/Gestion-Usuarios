package com.caito.gestionusuarios.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles_permissions")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RolesPermissions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rolePermissionId;
    private Long roleId;
    private Long permissionId;
}
