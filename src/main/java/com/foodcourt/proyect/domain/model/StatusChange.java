package com.foodcourt.proyect.domain.model;

import lombok.Data;

import java.util.Date;

@Data
public class StatusChange {
    private String id;
    private Long clientId;
    private Long orderId;
    private String status;
    private Date changeDate;
}
