package com.foodcourt.proyect.domain.servicePort;

import com.foodcourt.proyect.domain.comun.CrudBase;
import com.foodcourt.proyect.domain.model.Order;

public interface OrderServicePort extends CrudBase<Order, Long> {
    public Order createOrder(Order order);
}
