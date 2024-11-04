package com.foodcourt.proyect.domain.servicePort;

import com.foodcourt.proyect.domain.comun.CrudBase;
import com.foodcourt.proyect.domain.model.Restaurant;

public interface RestaurantServicePort extends CrudBase<Restaurant, Long> {

    public Restaurant createRestaurant(Restaurant restaurant);
}
