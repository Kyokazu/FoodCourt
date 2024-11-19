package com.foodcourt.proyect.domain.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Restaurant {

    private Long id;
    private String name;
    private String nit;
    private String address;
    private String phone;
    private String urlLogo;
    private Long ownerId;
    private String employees;

}
