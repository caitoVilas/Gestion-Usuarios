package com.caito.gestionusuarios.mappers;

import com.caito.gestionusuarios.dtos.RoleResponseDTO;
import com.caito.gestionusuarios.entity.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleResponseMapper {

    public Role roleResponseDTOToRole(RoleResponseDTO roleResponseDTO);
    public List<Role> RoleResponseDTOListToRoleList(List<RoleResponseDTO> roleResponseDTOList);

    public RoleResponseDTO roleToRoleResponseDTO(Role role);
    public List<RoleResponseDTO> roleListToRoleResponseDTOList(List<Role> roleList);
}
