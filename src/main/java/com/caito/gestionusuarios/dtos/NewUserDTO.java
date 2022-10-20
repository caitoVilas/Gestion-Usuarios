package com.caito.gestionusuarios.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name = "NewUserDTO", description = "Modelo que representa un usuario con los datos de persona" +
               " para el alta al sistema")
public class NewUserDTO {

    private DataUserDTO user;
    private DataPersonDTO person;
}
