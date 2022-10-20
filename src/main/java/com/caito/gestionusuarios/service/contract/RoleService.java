package com.caito.gestionusuarios.service.contract;

import com.caito.gestionusuarios.dtos.PermissionsListDTO;
import com.caito.gestionusuarios.dtos.RoleRequestDTO;
import com.caito.gestionusuarios.dtos.RoleResponseDTO;

import java.util.List;

public interface RoleService {

    public RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO);
    public List<RoleResponseDTO> getAll();
    public RoleResponseDTO addPermissions(Long roleId, List<PermissionsListDTO> permissionsListDTOS);
}
