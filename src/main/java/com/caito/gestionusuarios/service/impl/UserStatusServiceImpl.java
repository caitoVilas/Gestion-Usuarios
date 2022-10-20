package com.caito.gestionusuarios.service.impl;

import com.caito.gestionusuarios.entity.UserStatus;
import com.caito.gestionusuarios.exceptions.customs.NotFoundException;
import com.caito.gestionusuarios.repository.UserStatusRepository;
import com.caito.gestionusuarios.service.contract.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserStatusServiceImpl implements UserStatusService {

    @Autowired
    UserStatusRepository userStatusRepository;


    @Override
    public UserStatus getByUserStatusId(Long id) {

        return userStatusRepository.findById(id).orElseThrow(()->
                new NotFoundException("Estado no encontrado!"));
    }

    @Override
    public UserStatus getByDescription(String description) {
        return userStatusRepository.findByDescription(description);
    }


}
