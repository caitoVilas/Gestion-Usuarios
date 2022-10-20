package com.caito.gestionusuarios.mappers;

import com.caito.gestionusuarios.dtos.PermissionRequestDTO;
import com.caito.gestionusuarios.entity.Permission;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionRequestMapper {

    public Permission permissionRequestDTOtoPermission(PermissionRequestDTO permissionRequestDTO);
    public List<Permission> permissionListToPermissionRequestDTOLisr(
            List<PermissionRequestDTO> permissionRequestDTOList);

    public PermissionRequestDTO permisionToPermissionRequestDTO(Permission permission);
    public List<PermissionRequestDTO> permissionListToPermissionRequestDTOList(
            List<Permission> permissionList);
}
