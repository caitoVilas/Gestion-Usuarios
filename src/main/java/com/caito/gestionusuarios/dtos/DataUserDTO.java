package com.caito.gestionusuarios.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name = "DataUserDTO", description = "modelo que representa un usuario para el alta al sistema")
public class DataUserDTO {

    @Schema(name = "username", required = true, example = "caito")
    private String username;
    @Schema(name = "password", required = true, example = "12345678")
    private String password;
}
