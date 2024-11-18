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

}
