package com.foodcourt.proyect.infrastructure.persistence.jpa.entity;

import com.foodcourt.proyect.domain.model.OrderStatus;
import com.foodcourt.proyect.domain.model.Plate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long restaurantId;
    private Long clientId;
    @NotNull
    private String plateList;
    @NotNull
    private String plateQuantity;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private Long assignedEmployee;
    private int securityPin;
}
