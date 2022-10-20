package com.caito.gestionusuarios.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseDTO {

    private Long userId;
    private String username;
    private LocalDateTime created;
    private LocalDateTime updated;
    private UserStatusDTO userStatus;
    private PersonResponseDTO personId;
}
