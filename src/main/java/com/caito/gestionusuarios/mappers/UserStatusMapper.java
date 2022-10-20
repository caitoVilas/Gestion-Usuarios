package com.caito.gestionusuarios.mappers;

import com.caito.gestionusuarios.dtos.UserStatusDTO;
import com.caito.gestionusuarios.entity.UserStatus;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserStatusMapper {

    public UserStatus userStatusDTOToUserStatus(UserStatusDTO userStatusDTO);
    public List<UserStatus> userStatusDTOListToUserStatusList(List<UserStatusDTO> userStatusDTOList);

    public UserStatusDTO userStatusToUserStatusDTO(UserStatus userStatus);
    public List<UserStatusDTO> userStatusListToUserStatusDTOList(List<UserStatus> userStatusList);
}
