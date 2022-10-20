package com.caito.gestionusuarios.service.impl;

import com.caito.gestionusuarios.dtos.DataPersonDTO;
import com.caito.gestionusuarios.dtos.DocumentTypeDTO;
import com.caito.gestionusuarios.dtos.PersonResponseDTO;
import com.caito.gestionusuarios.entity.DocumentType;
import com.caito.gestionusuarios.entity.Person;
import com.caito.gestionusuarios.exceptions.customs.BadRequestException;
import com.caito.gestionusuarios.exceptions.customs.NotFoundException;
import com.caito.gestionusuarios.mappers.DataPersonDTOMapper;
import com.caito.gestionusuarios.mappers.DocumentTypeMapper;
import com.caito.gestionusuarios.mappers.PersonResponseMapper;
import com.caito.gestionusuarios.repository.PersonRepository;
import com.caito.gestionusuarios.service.contract.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    //private static final Logger logger = LoggerFactory.getLogger()

    @Autowired
    PersonRepository personRepository;
    @Autowired
    DataPersonDTOMapper dataPersonDTOMapper;
    @Autowired
    PersonResponseMapper personResponseMapper;
    @Autowired
    DocumentTypeMapper documentTypeMapper;
    @Autowired
    DocumentTypeServiceImpl documentTypeService;


    @Override
    public PersonResponseDTO createPerson(DataPersonDTO dataPerson) {

        validatePerson(dataPerson);

        Person person = dataPersonDTOMapper.dataPersonDTOToPerson(dataPerson);
        DocumentType documentType = documentTypeService.getById(dataPerson.getDocumentType().getDocumentId());
        person.setDocumentType(documentType);
        personRepository.save(person);

        return personResponseMapper.personToPersonResponseDTO(person);
    }

    @Override
    public PersonResponseDTO getPerson(Long personId) {

        Person person = personRepository.findById(personId).orElseThrow(()->
                new NotFoundException("Persona no Encontrada!"));
       return  personResponseMapper.personToPersonResponseDTO(person);
    }

    @Override
    public List<PersonResponseDTO> getAll() {
        List<Person> personList = personRepository.findAll();
        return personResponseMapper.personListToPersonResponseDTOList(personList);
    }

    @Override
    public List<PersonResponseDTO> getBySurname(String surname) {

        List<Person> personList = personRepository.findBySurname(surname);
        return personResponseMapper.personListToPersonResponseDTOList(personList);
    }

    private void validatePerson(DataPersonDTO personDTO){

        if (personDTO.getName().isEmpty() || personDTO.getName() == null){
            throw new BadRequestException("El nombre es requerido!");
        }

        if(personDTO.getSurname().isEmpty() || personDTO.getSurname() == null){
            throw new BadRequestException("El apellido es requerido!");
        }

        if (personDTO.getGender().isEmpty() || personDTO.getGender() == null){
            throw new BadRequestException("El genero es requerido!");
        }

        if (!personDTO.getGender().equals("M") &&
                !personDTO.getGender().equals("F") &&
                !personDTO.getGender().equals("X")){
            throw new BadRequestException("El genero solo acepta M, F o X");
        }

        if (personDTO.getEmail().isEmpty() || personDTO.getEmail() == null){
            throw new BadRequestException("El email es requerido!");
        }

        //todo: validar formato mail

        if (personDTO.getDocumentNumber().isEmpty() || personDTO.getDocumentNumber() == null){
            throw new BadRequestException("El numero de documento es requerido!");
        }

        if (personDTO.getCuit().isEmpty() || personDTO.getCuit() == null){
            throw new BadRequestException("El cuit es requerido!");
        }
    }
}
