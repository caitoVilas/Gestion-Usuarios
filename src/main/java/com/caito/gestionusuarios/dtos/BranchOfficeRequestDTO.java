package com.caito.gestionusuarios.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name = "BranchOfficeRequestDTO", description = "Modelo que representa una sucursal para ingresar al sistema")
public class BranchOfficeRequestDTO {

    @Schema(name = "code", required = true, example = "1000")
    private String code;
    @Schema(name = "description", required = true, example = "Lanus")
    private String description;
}
