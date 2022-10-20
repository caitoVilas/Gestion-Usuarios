package com.caito.gestionusuarios.service.impl;

import com.caito.gestionusuarios.dtos.PermissionRequestDTO;
import com.caito.gestionusuarios.dtos.PermissionResponseDTO;
import com.caito.gestionusuarios.entity.Permission;
import com.caito.gestionusuarios.exceptions.customs.NotFoundException;
import com.caito.gestionusuarios.mappers.PermissionRequestMapper;
import com.caito.gestionusuarios.mappers.PermissionResponseMapper;
import com.caito.gestionusuarios.repository.PermissionRepository;
import com.caito.gestionusuarios.service.contract.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermisssionServiceImpl implements PermissionService {

    @Autowired
    PermissionRepository permissionRepository;
    @Autowired
    PermissionRequestMapper permissionRequestMapper;
    @Autowired
    PermissionResponseMapper permissionResponseMapper;


    @Override
    public void createPermission(PermissionRequestDTO permissionRequestDTO) {

        permissionRepository.save(permissionRequestMapper.permissionRequestDTOtoPermission(permissionRequestDTO));
    }

    @Override
    public List<PermissionResponseDTO> getAll() {

        List<Permission> permissionList = permissionRepository.findAll();
        return permissionResponseMapper.permissionListToPermissionResponseDTOList(permissionList);
    }

    @Override
    public Permission getById(Long permissionId) {

        Permission permission = permissionRepository.findById(permissionId).orElseThrow(()->{
            return new NotFoundException("Permiso no encontrado!");
        });
        return permission;
    }
}
