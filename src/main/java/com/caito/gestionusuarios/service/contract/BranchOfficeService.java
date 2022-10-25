package com.caito.gestionusuarios.service.contract;

import com.caito.gestionusuarios.dtos.BranchOfficeRequestDTO;
import com.caito.gestionusuarios.dtos.BranchOfficeResponseDTO;

import java.util.List;

public interface BranchOfficeService {

    void createBranchOffice(BranchOfficeRequestDTO requestDTO);
    List<BranchOfficeResponseDTO> getAll();
    BranchOfficeResponseDTO getByDescription(String description);
    void deleteBranchOffice(Long branchOfficeId);
}
