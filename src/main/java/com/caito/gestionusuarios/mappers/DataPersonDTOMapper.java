package com.caito.gestionusuarios.mappers;

import com.caito.gestionusuarios.dtos.DataPersonDTO;
import com.caito.gestionusuarios.entity.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DataPersonDTOMapper {

    DataPersonDTO personToDataPersonDTO(Person request);
    List<DataPersonDTO> personListToDataPersonDTOList(List<Person> personList);

    Person dataPersonDTOToPerson(DataPersonDTO dataPersonDTO);
    List<Person> dataPersonDTOListToPersonList(List<DataPersonDTO> dataPersonDTOList);
}
