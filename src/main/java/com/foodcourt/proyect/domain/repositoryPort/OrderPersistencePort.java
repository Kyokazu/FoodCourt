package com.foodcourt.proyect.domain.repositoryPort;

import com.foodcourt.proyect.domain.comun.CrudBase;
import com.foodcourt.proyect.domain.model.Order;

public interface OrderPersistencePort extends CrudBase<Order, Long> {

    public Order createOrder(Order order);
}
