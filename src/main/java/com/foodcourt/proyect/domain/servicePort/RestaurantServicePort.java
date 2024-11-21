package com.foodcourt.proyect.domain.servicePort;

import com.foodcourt.proyect.domain.comun.CrudBase;
import com.foodcourt.proyect.domain.model.Restaurant;
import com.foodcourt.proyect.infrastructure.dto.ListRestaurantDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RestaurantServicePort {

    public Restaurant createRestaurant(Restaurant restaurant);

    List<ListRestaurantDTO> getAllRestaurants(long cantidad);
}
