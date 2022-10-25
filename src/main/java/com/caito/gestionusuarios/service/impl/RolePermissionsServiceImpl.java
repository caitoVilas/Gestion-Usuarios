package com.caito.gestionusuarios.service.impl;

import com.caito.gestionusuarios.entity.RolesPermissions;
import com.caito.gestionusuarios.repository.RolePermissionRepository;
import com.caito.gestionusuarios.service.contract.RolePermisssionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RolePermissionsServiceImpl implements RolePermisssionService {

    @Autowired
    RolePermissionRepository rolePermissionRepository;


    @Override
    public List<RolesPermissions> getPermissionsForRoleId(Long roleId) {


        return rolePermissionRepository.findByRoleId(roleId);
    }

    @Override
    public void deleteById(Long id) {

        rolePermissionRepository.deleteById(id);
    }

    @Override
    public void createRolePermission(RolesPermissions rolesPermissions) {

        rolePermissionRepository.save(rolesPermissions);
    }
}
