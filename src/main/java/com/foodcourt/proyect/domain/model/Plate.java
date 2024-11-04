package com.foodcourt.proyect.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Plate {

    private Long id;
    private String name;
    private int price;
    private String description;
    private String urlImage;
    private String category;
    private Long restaurantId;
    private boolean active;
}
