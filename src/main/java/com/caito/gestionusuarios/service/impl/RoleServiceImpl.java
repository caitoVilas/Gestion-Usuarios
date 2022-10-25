package com.caito.gestionusuarios.service.impl;

import com.caito.gestionusuarios.dtos.PermissionResponseDTO;
import com.caito.gestionusuarios.dtos.RoleRequestDTO;
import com.caito.gestionusuarios.dtos.RoleResponseDTO;
import com.caito.gestionusuarios.entity.Permission;
import com.caito.gestionusuarios.entity.Role;
import com.caito.gestionusuarios.entity.RolesPermissions;
import com.caito.gestionusuarios.exceptions.customs.NotFoundException;
import com.caito.gestionusuarios.mappers.PermissionResponseMapper;
import com.caito.gestionusuarios.mappers.RoleRequestMapper;
import com.caito.gestionusuarios.mappers.RoleResponseMapper;
import com.caito.gestionusuarios.repository.RoleRepository;
import com.caito.gestionusuarios.service.contract.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RoleRequestMapper roleRequestMapper;
    @Autowired
    RoleResponseMapper roleResponseMapper;
    @Autowired
    RolePermissionsServiceImpl rolePermissionsService;
    @Autowired
    PermissionResponseMapper permissionResponseMapper;
    @Autowired
    PermisssionServiceImpl permisssionService;

    @Override
    public RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO) {

        Role responseDTO = roleRepository.save(roleRequestMapper.roleRequestDTOToRole(roleRequestDTO));
        return roleResponseMapper.roleToRoleResponseDTO(responseDTO);
    }

    @Override
    public List<RoleResponseDTO> getAll() {

        List<RoleResponseDTO> roleResponseDTOS = new ArrayList<>();
        List<Role> roleList = roleRepository.findAll();

        for (Role role : roleList){
            List<RolesPermissions> permissions = new ArrayList<>();
            Set<Permission> permissionList = new HashSet<>();
            permissions = rolePermissionsService.getPermissionsForRoleId(role.getRoleId());

            permissions.forEach(p -> {
                Permission permission = permisssionService.getById(p.getPermissionId());
                permissionList.add(permission);
            });
            Set<PermissionResponseDTO> permissionResponseDTOS = new HashSet<>();
            permissionList.forEach(p -> {
                permissionResponseDTOS.add(permissionResponseMapper.permissionToPermissionsResponseDTO(p));
            });
            RoleResponseDTO response = new RoleResponseDTO();
            response.setRoleId(role.getRoleId());
            response.setName(role.getName());
            response.setPermissions(permissionResponseDTOS);
            roleResponseDTOS.add(response);

        }

        return roleResponseDTOS;
    }


    @Override
    public void addPermissions(Long roleId,List<Long> permissions) {

        Role role = roleRepository.findById(roleId).orElseThrow(()->
                new NotFoundException("Rol no encontrado!"));

        Set<Permission> newPermissions = new HashSet<>();

        List<RolesPermissions> oldPermissions = rolePermissionsService.getPermissionsForRoleId(roleId);
        Set<RolesPermissions> saveNewPermissions = new HashSet<>();

         permissions.forEach(per -> {
             Permission permission = permisssionService.getById(per);
             newPermissions.add(permission);
             RolesPermissions rp = new RolesPermissions();
             rp.setRoleId(roleId);
             rp.setPermissionId(permission.getPermissionId());
             saveNewPermissions.add(rp);
         });

         //eliminar viejos
         oldPermissions.forEach(permission -> {
            rolePermissionsService.deleteById(permission.getRolePermissionId());
         });

         //asignar nuevos
        saveNewPermissions.forEach(permission -> {
            rolePermissionsService.createRolePermission(permission);
        });

        return ;
    }


}
