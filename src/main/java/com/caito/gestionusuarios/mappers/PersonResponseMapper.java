package com.caito.gestionusuarios.mappers;

import com.caito.gestionusuarios.dtos.PersonResponseDTO;
import com.caito.gestionusuarios.entity.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonResponseMapper {

    PersonResponseDTO personToPersonResponseDTO(Person request);
    List<PersonResponseDTO> personListToPersonResponseDTOList(List<Person> personList);

    Person personResponseDTOToPerson(PersonResponseDTO personResponseDTO);
    List<Person> personResponseDTOListToPersonList(List<PersonResponseDTO> personResponseDTOList);
}
