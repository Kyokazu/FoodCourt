package com.foodcourt.proyect.infrastructure.persistence.repository;

import com.foodcourt.proyect.infrastructure.persistence.entity.PlateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlateRepository extends JpaRepository<PlateEntity, Long> {
}
