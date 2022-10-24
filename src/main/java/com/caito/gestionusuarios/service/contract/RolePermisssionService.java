package com.caito.gestionusuarios.service.contract;

import com.caito.gestionusuarios.dtos.PermissionResponseDTO;
import com.caito.gestionusuarios.entity.RolesPermissions;

import java.util.List;

public interface RolePermisssionService {

    List<RolesPermissions> getPermissionsForRoleId(Long roleId);
}
