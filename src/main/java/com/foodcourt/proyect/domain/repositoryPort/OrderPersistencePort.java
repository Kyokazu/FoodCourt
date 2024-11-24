package com.foodcourt.proyect.domain.repositoryPort;

import com.foodcourt.proyect.domain.comun.CrudBase;
import com.foodcourt.proyect.domain.model.Order;

import java.util.List;

public interface OrderPersistencePort {
    Order findById(Long aLong);

    List<Order> findAll();

    Order save(Order entity);

    void update(Order entity);
}
