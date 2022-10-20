package com.caito.gestionusuarios.service.contract;

import com.caito.gestionusuarios.dtos.DataPersonDTO;
import com.caito.gestionusuarios.dtos.PersonResponseDTO;

import java.security.Permission;
import java.util.List;

public interface PersonService {

        PersonResponseDTO createPerson(DataPersonDTO dataPerson);
        PersonResponseDTO getPerson(Long personId);
        List<PersonResponseDTO> getAll();
        List<PersonResponseDTO> getBySurname(String surname);

}
