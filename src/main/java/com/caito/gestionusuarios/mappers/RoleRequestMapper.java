package com.caito.gestionusuarios.mappers;

import com.caito.gestionusuarios.dtos.RoleRequestDTO;
import com.caito.gestionusuarios.entity.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleRequestMapper {

    public Role roleRequestDTOToRole(RoleRequestDTO roleRequestDTO);
    public List<Role> roleRequestDTOListToRoleList(List<RoleRequestDTO> roleRequestDTOList);

    public RoleRequestDTO roleToRoleRequestDTO(Role role);
    public List<RoleRequestDTO> roleListToRoleRequestDTOList(List<Role> roleList);
}
