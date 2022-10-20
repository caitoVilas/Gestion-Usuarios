package com.caito.gestionusuarios.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name = "RoleRequestDTO", description = "Modelo que representa un rol para el alta al sistema")
public class RoleRequestDTO {

    @Schema(name = "name", required = true, example = "ADMIN")
    private String name;
}
