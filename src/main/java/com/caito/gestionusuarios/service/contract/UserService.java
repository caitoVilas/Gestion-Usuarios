package com.caito.gestionusuarios.service.contract;

import com.caito.gestionusuarios.dtos.NewUserDTO;
import com.caito.gestionusuarios.dtos.UserResponseDTO;

import java.util.List;

public interface UserService {

    void createUser(NewUserDTO newUserDTO);
    UserResponseDTO getUser(Long userId);
    List<UserResponseDTO> getAll();
}
