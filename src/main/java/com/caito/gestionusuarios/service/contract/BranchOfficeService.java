package com.caito.gestionusuarios.service.contract;

import com.caito.gestionusuarios.dtos.BranchOfficeRequestDTO;
import com.caito.gestionusuarios.dtos.BranchOfficeResponseDTO;
import com.caito.gestionusuarios.dtos.UserResponseDTO;

import java.util.List;

public interface BranchOfficeService {

    void createBranchOffice(BranchOfficeRequestDTO requestDTO);
    List<BranchOfficeResponseDTO> getAll();
    BranchOfficeResponseDTO getByDescription(String description);
    void   deleteBranchOffice(Long branchOfficeId);
    void setBranchOffice(Long userId, Long branchOfficeId);
    List<UserResponseDTO> getUsersByBranchOffice(Long branchOffice);

}
