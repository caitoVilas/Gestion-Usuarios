package com.caito.gestionusuarios.service.contract;

import com.caito.gestionusuarios.dtos.PermissionRequestDTO;
import com.caito.gestionusuarios.dtos.PermissionResponseDTO;
import com.caito.gestionusuarios.entity.Permission;

import java.util.List;

public interface PermissionService {

    public void createPermission(PermissionRequestDTO permissionRequestDTO);
    public List<PermissionResponseDTO> getAll();
    Permission getById(Long permissionId);

}
