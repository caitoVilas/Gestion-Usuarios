package com.caito.gestionusuarios.service.impl;

import com.caito.gestionusuarios.entity.DocumentType;
import com.caito.gestionusuarios.exceptions.customs.BadRequestException;
import com.caito.gestionusuarios.repository.DocumentTypeRepository;
import com.caito.gestionusuarios.service.contract.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {

    @Autowired
    DocumentTypeRepository documentTypeRepository;


    @Override
    public DocumentType getById(Long documentId) {

        return documentTypeRepository.findById(documentId).orElseThrow(()->
                new BadRequestException("Documento no encontrado!"));
    }
}
