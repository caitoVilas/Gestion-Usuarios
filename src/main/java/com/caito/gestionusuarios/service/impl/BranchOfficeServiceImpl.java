package com.caito.gestionusuarios.service.impl;

import com.caito.gestionusuarios.dtos.BranchOfficeRequestDTO;
import com.caito.gestionusuarios.dtos.BranchOfficeResponseDTO;
import com.caito.gestionusuarios.dtos.UserResponseDTO;
import com.caito.gestionusuarios.entity.BranchOffice;
import com.caito.gestionusuarios.entity.User;
import com.caito.gestionusuarios.exceptions.customs.BadRequestException;
import com.caito.gestionusuarios.exceptions.customs.NotFoundException;
import com.caito.gestionusuarios.mappers.BranchOfficeMapper;
import com.caito.gestionusuarios.mappers.UserResponseMapper;
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
    @Autowired
    UserServiceImpl userService;
    @Autowired
    UserResponseMapper userResponseMapper;



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

        List<User> userList = userService.getUserByBranchOffice(branchOffice);

        if (!userList.isEmpty()){
            throw  new BadRequestException("La sucursal se encuentra aignada a usuarios");
        }

        branchOfficeRepository.deleteById(branchOffice.getBranchOffoceId());

    }

    @Override
    public void setBranchOffice(Long userId, Long branchOfficeId) {

        BranchOffice branchOffice = branchOfficeRepository.findById(branchOfficeId).orElseThrow(() -> {
             return new NotFoundException("Sucursal no encontrada!");
        });

        User user = userService.getuserInternal(userId);
        user.setBranchOfficeId(branchOffice);
        userService.updateUser(user);
    }

    @Override
    public List<UserResponseDTO> getUsersByBranchOffice(Long branchOfficeId) {

        BranchOffice branchOffice = branchOfficeRepository.findById(branchOfficeId).orElseThrow(() -> {
            return new NotFoundException("Sucursal no encontrada!");
        });

        List<User> userList = userService.getUserByBranchOffice(branchOffice);
        return userResponseMapper.userListToUserResponseDTOList(userList);
    }


}
