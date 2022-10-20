package com.caito.gestionusuarios.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserStatusDTO {

    private Long userStatusId;
    private String description;
    private String code;
}
