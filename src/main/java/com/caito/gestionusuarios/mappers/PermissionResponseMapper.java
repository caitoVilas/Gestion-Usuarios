package com.caito.gestionusuarios.mappers;

import com.caito.gestionusuarios.dtos.PermissionRequestDTO;
import com.caito.gestionusuarios.dtos.PermissionResponseDTO;
import com.caito.gestionusuarios.entity.Permission;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionResponseMapper {

    public Permission permissionResponseDTOToPermission(PermissionRequestDTO permissionRequestDTO);
    public List<Permission> permissionResponseDtoListToPermissionList(List<PermissionResponseDTO>
                                                                      permissionResponseDTOList);

    public PermissionResponseDTO permissionToPermissionsResponseDTO(Permission permission);
    public List<PermissionResponseDTO> permissionListToPermissionResponseDTOList(
            List<Permission> permissionList);
}
