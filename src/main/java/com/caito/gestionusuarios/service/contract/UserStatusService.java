package com.caito.gestionusuarios.service.contract;

import com.caito.gestionusuarios.entity.UserStatus;

public interface UserStatusService {

    UserStatus getByUserStatusId(Long id);
    UserStatus getByDescription(String description);
}
