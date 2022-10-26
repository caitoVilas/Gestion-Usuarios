package com.caito.gestionusuarios.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name = "UserResponseDTO", description = "Modelo que representa un usuario para una respuesta")
public class UserResponseDTO {

    private Long userId;
    private String username;
    private LocalDateTime created;
    private LocalDateTime updated;
    private UserStatusDTO userStatus;
    private PersonResponseDTO personId;
    private BranchOfficeResponseDTO branchOfficeId;
}
