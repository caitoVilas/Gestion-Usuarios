package com.caito.gestionusuarios.dtos;

import com.caito.gestionusuarios.entity.DocumentType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name = "RoleResponseDTO", description = "Modelo que representa un rol en una respuesta")
public class PersonResponseDTO {

    private Long personId;
    private String name;
    private String surname;
    private String gender;
    private String email;
    private String telephone;
    private String dateOfBirth;
    private DocumentTypeDTO documentType;
    private String documentNumber;
    private String cuit;
}
