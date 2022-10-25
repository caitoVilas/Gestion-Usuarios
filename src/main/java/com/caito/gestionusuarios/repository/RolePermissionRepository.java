package com.caito.gestionusuarios.repository;

import com.caito.gestionusuarios.entity.RolesPermissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolesPermissions, Long> {

    List<RolesPermissions> findByRoleId(Long roleId);
}
