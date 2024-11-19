package com.foodcourt.proyect.infrastructure.dto;

import com.foodcourt.proyect.domain.model.OrderStatus;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {

    private Long id;
    private Long restaurantId;
    private Long clientId;
    private String plateList;
    private String plateQuantity;
    private OrderStatus status;

    public OrderDTO(Long id, Long restaurantId, Long clientId, String plateList, String plateQuantity, OrderStatus status) {
        this.id = id;
        this.clientId = clientId;
        this.plateList = plateList;
        this.plateQuantity = plateQuantity;
        this.restaurantId = restaurantId;
        this.status = status;
    }

    public OrderDTO() {
    }
}
