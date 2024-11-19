package com.foodcourt.proyect.domain.servicePort;

import com.foodcourt.proyect.domain.comun.CrudBase;
import com.foodcourt.proyect.domain.model.Order;
import com.foodcourt.proyect.infrastructure.dto.OrderDTO;
import com.foodcourt.proyect.infrastructure.dto.OrderListDTO;

import java.util.List;

public interface OrderServicePort extends CrudBase<Order, Long> {
    public Order createOrder(Order order);

    public List<OrderDTO> listOrders(Long orders, String status);
}
