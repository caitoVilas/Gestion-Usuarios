package com.caito.gestionusuarios.mappers;

import com.caito.gestionusuarios.dtos.UserResponseDTO;
import com.caito.gestionusuarios.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

    public User userResponseDTOToUser(UserResponseDTO userResponseDTO);
    public List<User> userResponseDTOListToUserList(List<UserResponseDTO> userResponseDTOList);

    public UserResponseDTO userToUserResponseDTO(User user);
    public List<UserResponseDTO> userListToUserResponseDTOList(List<User> userList);
}
