package com.foodcourt.proyect.infrastructure.persistence.repository;

import com.foodcourt.proyect.infrastructure.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
