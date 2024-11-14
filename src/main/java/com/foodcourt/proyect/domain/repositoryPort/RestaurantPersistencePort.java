package com.foodcourt.proyect.domain.repositoryPort;

import com.foodcourt.proyect.domain.comun.CrudBase;
import com.foodcourt.proyect.domain.model.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RestaurantPersistencePort extends CrudBase<Restaurant, Long> {

    Long findOwnerIdByRestaurantId(Long restaurantId);

}
