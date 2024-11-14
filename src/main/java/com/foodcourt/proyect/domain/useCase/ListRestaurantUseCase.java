package com.foodcourt.proyect.domain.useCase;

import com.foodcourt.proyect.domain.model.Restaurant;
import com.foodcourt.proyect.domain.repositoryPort.RestaurantPersistencePort;
import com.foodcourt.proyect.domain.servicePort.RestaurantServicePort;
import com.foodcourt.proyect.infrastructure.dto.ListRestaurantDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ListRestaurantUseCase implements RestaurantServicePort {

    private final RestaurantPersistencePort restaurantPersistencePort;


    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return null;
    }

    public List<ListRestaurantDTO> getAllRestaurants(int cantidad) {
        List<Restaurant> restaurantes = restaurantPersistencePort.findAll();
        return restaurantes.stream().sorted(
                        (r1, r2) ->
                                r1.getName().compareToIgnoreCase(r2.getName()))
                .limit(cantidad)
                .map(r -> new ListRestaurantDTO(r.getName(), r.getUrlLogo()))
                .collect(Collectors.toList());
    }


    @Override
    public Restaurant findById(Long aLong) {
        return null;
    }

    @Override
    public List<Restaurant> findAll() {
        return List.of();
    }

    @Override
    public Restaurant save(Restaurant entity) {
        return null;
    }

    @Override
    public void update(Restaurant entity) {

    }

    @Override
    public void delete(Restaurant entity) {

    }
}
