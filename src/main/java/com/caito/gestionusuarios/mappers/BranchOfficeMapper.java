package com.caito.gestionusuarios.mappers;

import com.caito.gestionusuarios.dtos.BranchOfficeRequestDTO;
import com.caito.gestionusuarios.dtos.BranchOfficeResponseDTO;
import com.caito.gestionusuarios.entity.BranchOffice;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BranchOfficeMapper {

    BranchOffice requestDtoToBranchOffice(BranchOfficeRequestDTO requestDTO);
    List<BranchOffice> requestDtoListToBranchOffice(List<BranchOfficeRequestDTO> branchOfficeRequestDTOList);

    BranchOfficeRequestDTO branchOfficeToRequestDto(BranchOffice branchOffice);
    List<BranchOfficeRequestDTO> branchOfficeListToRequestDtoList(List<BranchOffice> branchOfficeList);

    BranchOffice responseDtoToBranchOffice(BranchOfficeResponseDTO branchOfficeResponseDTO);
    List<BranchOffice> responseDtoListToBranchOfficeList(List<BranchOfficeResponseDTO> responseDTOList);

    BranchOfficeResponseDTO branchOfficeToResponseDto(BranchOffice branchOffice);
    List<BranchOfficeResponseDTO> branchOfficeListToResponseDtoList(List<BranchOffice> list);
}
