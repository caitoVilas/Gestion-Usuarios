package com.caito.gestionusuarios.dtos;

import com.caito.gestionusuarios.entity.DocumentType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name = "DataPersonDTO", description = "Modelo que representa una persona para el alta al sistema")
public class DataPersonDTO {

    @Schema(name = "name", required = true, example = "Caito")
    private String name;
    @Schema(name = "surname", required = true, example = "Vilas")
    private String surname;
    @Schema(name = "gender", required = true, example = "M")
    private String gender;
    @Schema(name = "email", required = true, example = "caito@gmail.com")
    private String email;
    @Schema(name = "telephone", required = true, example = "1157281035")
    private String telephone;
    @Schema(name = "dateOfBirth", required = true, example = "2000-01-01")
    private String dateOfBirth;
    @Schema(name = "documentType", required = true)
    private DocumentTypeDTO documentType;
    @Schema(name = "documentNumber", required = true, example = "11111111")
    private String documentNumber;
    @Schema(name = "cuit", required = true, example = "20111111117")
    private String cuit;
}
