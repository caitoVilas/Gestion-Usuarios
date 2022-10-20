package com.caito.gestionusuarios.repository;

import com.caito.gestionusuarios.entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStatusRepository extends JpaRepository<UserStatus, Long> {

    UserStatus findByDescription(String Description);
}
