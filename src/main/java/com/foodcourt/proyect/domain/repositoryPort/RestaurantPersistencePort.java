package com.foodcourt.proyect.domain.repositoryPort;

import com.foodcourt.proyect.domain.model.Restaurant;

import java.util.List;

public interface RestaurantPersistencePort {

    Restaurant findById(Long aLong);

    List<Restaurant> findAll();

    Restaurant save(Restaurant entity);

    void update(Restaurant entity);

    Long findOwnerIdByRestaurantId(Long restaurantId);

    Restaurant findRestaurantByOwnerId(Long ownerId);

}
