package com.caito.gestionusuarios.repository;

import com.caito.gestionusuarios.dtos.BranchOfficeResponseDTO;
import com.caito.gestionusuarios.entity.BranchOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BranchOfficeRepository extends JpaRepository<BranchOffice, Long> {

    Optional<BranchOffice> findByDescription(String description);
}
