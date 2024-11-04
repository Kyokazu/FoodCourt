package com.foodcourt.proyect.infrastructure.persistence.repository;

import com.foodcourt.proyect.infrastructure.persistence.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
}
