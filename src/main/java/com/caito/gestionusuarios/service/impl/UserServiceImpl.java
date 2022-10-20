package com.caito.gestionusuarios.service.impl;

import com.caito.gestionusuarios.dtos.DataUserDTO;
import com.caito.gestionusuarios.dtos.NewUserDTO;
import com.caito.gestionusuarios.dtos.PersonResponseDTO;
import com.caito.gestionusuarios.dtos.UserResponseDTO;
import com.caito.gestionusuarios.entity.User;
import com.caito.gestionusuarios.entity.UserStatus;
import com.caito.gestionusuarios.exceptions.customs.BadRequestException;
import com.caito.gestionusuarios.exceptions.customs.NotFoundException;
import com.caito.gestionusuarios.mappers.DataUserDTOMapper;
import com.caito.gestionusuarios.mappers.PersonResponseMapper;
import com.caito.gestionusuarios.mappers.UserResponseMapper;
import com.caito.gestionusuarios.repository.UserRepository;
import com.caito.gestionusuarios.service.contract.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PersonServiceImpl personService;
    @Autowired
    DataUserDTOMapper dataUserDTOMapper;
    @Autowired
    PersonResponseMapper personResponseMapper;
    @Autowired
    UserStatusServiceImpl userStatusService;
    @Autowired
    UserResponseMapper userResponseMapper;

    @Override
    public void createUser(NewUserDTO newUserDTO) {

        PersonResponseDTO person = personService.createPerson(newUserDTO.getPerson());

        validateUser(newUserDTO.getUser());

        User user = dataUserDTOMapper.dataUserToUser(newUserDTO.getUser());
        user.setPersonId(personResponseMapper.personResponseDTOToPerson(person));
        UserStatus userStatus = userStatusService.getByDescription("Inactivo");
        user.setUserStatus(userStatus);

        userRepository.save(user);
    }

    @Override
    public UserResponseDTO getUser(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(()->
                new NotFoundException("Usuario no encontrado!"));

        return userResponseMapper.userToUserResponseDTO(user);
    }

    @Override
    public List<UserResponseDTO> getAll() {

        List<User> userList = userRepository.findAll();
        return userResponseMapper.userListToUserResponseDTOList(userList);
    }

    private void validateUser(DataUserDTO userDTO){

        if (userDTO.getUsername().isEmpty() || userDTO.getUsername() == null){
            throw new BadRequestException("El nombre de usuario es requerido!");
        }

        if (userDTO.getPassword().isEmpty() || userDTO.getPassword() == null){
            throw new BadRequestException("La contraseña es requerida!");
        }

    }
}
