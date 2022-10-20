package com.caito.gestionusuarios.mappers;

import com.caito.gestionusuarios.dtos.DocumentTypeDTO;
import com.caito.gestionusuarios.entity.DocumentType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DocumentTypeMapper {

    DocumentType documentTypeDTOToDocumentType(DocumentTypeDTO documentTypeDTO);
    List<DocumentType> documentTypeDTOListToDocumentTypeList(List<DocumentTypeDTO> documentTypeDTOList);

    DocumentTypeDTO documentTypeToDocumentTypeDTO(DocumentType documentType);
    List<DocumentTypeDTO> documentTypeListToDocumentTypeDTOList(List<DocumentType> documentTypeList);
}
