package com.caito.gestionusuarios.service.impl;

import com.caito.gestionusuarios.dtos.BranchOfficeRequestDTO;
import com.caito.gestionusuarios.dtos.BranchOfficeResponseDTO;
import com.caito.gestionusuarios.entity.BranchOffice;
import com.caito.gestionusuarios.exceptions.customs.NotFoundException;
import com.caito.gestionusuarios.mappers.BranchOfficeMapper;
import com.caito.gestionusuarios.repository.BranchOfficeRepository;
import com.caito.gestionusuarios.service.contract.BranchOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchOfficeServiceImpl implements BranchOfficeService {

    @Autowired
    BranchOfficeRepository branchOfficeRepository;
    @Autowired
    BranchOfficeMapper branchOfficeMapper;


    @Override
    public void createBranchOffice(BranchOfficeRequestDTO requestDTO) {

        branchOfficeRepository.save(branchOfficeMapper.requestDtoToBranchOffice(requestDTO));
    }

    @Override
    public List<BranchOfficeResponseDTO> getAll() {

        List<BranchOffice> branchOfficeList = branchOfficeRepository.findAll();
        return branchOfficeMapper.branchOfficeListToResponseDtoList(branchOfficeList);
    }

    @Override
    public BranchOfficeResponseDTO getByDescription(String description) {

        BranchOffice branchOffice = branchOfficeRepository.findByDescription(description).orElseThrow(() ->
                new NotFoundException("Sucursal no encontrada!"));
        return branchOfficeMapper.branchOfficeToResponseDto(branchOffice);
    }

    @Override
    public void deleteBranchOffice(Long branchOfficeId) {

        BranchOffice branchOffice = branchOfficeRepository.findById(branchOfficeId).orElseThrow(() ->
                new NotFoundException("Sucursal no encontrada!"));
        branchOfficeRepository.deleteById(branchOffice.getBranchOffoceId());
    }
}
