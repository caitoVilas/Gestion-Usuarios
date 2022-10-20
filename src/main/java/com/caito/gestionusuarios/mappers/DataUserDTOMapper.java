package com.caito.gestionusuarios.mappers;

import com.caito.gestionusuarios.dtos.DataUserDTO;
import com.caito.gestionusuarios.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DataUserDTOMapper {

    User dataUserToUser(DataUserDTO dataUserDTO);
    List<User> dataUserDTOListToUserList(List<DataUserDTO> dataUserDTOList);

    DataUserDTO userToDataUserDTO(User user);
    List<DataUserDTO> UserListToDataUserDTOList(List<User> userList);
}
