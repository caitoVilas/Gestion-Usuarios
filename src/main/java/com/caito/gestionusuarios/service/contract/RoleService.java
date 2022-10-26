package com.caito.gestionusuarios.service.contract;

import com.caito.gestionusuarios.dtos.RoleRequestDTO;
import com.caito.gestionusuarios.dtos.RoleResponseDTO;

import java.util.List;

public interface RoleService {

    public RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO);
    public List<RoleResponseDTO> getAll();
    public void addPermissions(Long roleId, List<Long> permissions);
    void updateRole(Long roleId, String roleName);
}
