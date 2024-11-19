package com.foodcourt.proyect.infrastructure.persistence.repository;

import com.foodcourt.proyect.domain.model.Restaurant;
import com.foodcourt.proyect.infrastructure.persistence.entity.RestaurantEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {

    Stream<RestaurantEntity> findByOwnerId(Long ownerId);
}
