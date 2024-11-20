package com.foodcourt.proyect.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class Order {

    private Long id;
    private Long restaurantId;
    private Long clientId;
    private String plateList;
    private String plateQuantity;
    private OrderStatus status;
    private Long assignedEmployee;
    private int securityPin;

}
