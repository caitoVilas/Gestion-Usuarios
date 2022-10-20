package com.caito.gestionusuarios.service.impl;

import com.caito.gestionusuarios.dtos.PermissionsListDTO;
import com.caito.gestionusuarios.dtos.RoleRequestDTO;
import com.caito.gestionusuarios.dtos.RoleResponseDTO;
import com.caito.gestionusuarios.entity.Permission;
import com.caito.gestionusuarios.entity.Role;
import com.caito.gestionusuarios.exceptions.customs.NotFoundException;
import com.caito.gestionusuarios.mappers.RoleRequestMapper;
import com.caito.gestionusuarios.mappers.RoleResponseMapper;
import com.caito.gestionusuarios.repository.RoleRepository;
import com.caito.gestionusuarios.service.contract.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RoleRequestMapper roleRequestMapper;
    @Autowired
    RoleResponseMapper roleResponseMapper;
    @Autowired
    PermisssionServiceImpl permisssionService;


    @Override
    public RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO) {

        Role responseDTO = roleRepository.save(roleRequestMapper.roleRequestDTOToRole(roleRequestDTO));
        return roleResponseMapper.roleToRoleResponseDTO(responseDTO);
    }

    @Override
    public List<RoleResponseDTO> getAll() {

        List<Role> roleList = roleRepository.findAll();
        return roleResponseMapper.roleListToRoleResponseDTOList(roleList);
    }

    @Override
    public RoleResponseDTO addPermissions(Long roleId,List<PermissionsListDTO> permissionsListDTOS) {

        Role role = roleRepository.findById(roleId).orElseThrow(()->
                new NotFoundException("Rol no encontrado!"));

        List<Permission> permissions = new ArrayList<>();
        permissionsListDTOS.forEach(p ->{
             Permission permission = permisssionService.getById(p.getPermissionId());
             permissions.add(permission);
        });

        role.setPermissions(permissions);
        return roleResponseMapper.roleToRoleResponseDTO(roleRepository.save(role));
    }


}
