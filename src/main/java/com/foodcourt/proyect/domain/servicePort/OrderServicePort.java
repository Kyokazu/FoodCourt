package com.foodcourt.proyect.domain.servicePort;

import com.foodcourt.proyect.domain.comun.CrudBase;
import com.foodcourt.proyect.domain.model.Order;
import com.foodcourt.proyect.infrastructure.dto.ClientNotificationDTO;
import com.foodcourt.proyect.infrastructure.dto.NotificationMessageDTO;
import com.foodcourt.proyect.infrastructure.dto.OrderDTO;

import java.util.List;

public interface OrderServicePort extends CrudBase<Order, Long> {
    public Order createOrder(Order order);

    public List<OrderDTO> listOrders(Long orders, String status);

    public Order assignOrder(Long employeeId);

    public NotificationMessageDTO notifyOrderReady(ClientNotificationDTO clientNotificationDTO);
}
