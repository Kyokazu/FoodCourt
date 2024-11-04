package com.foodcourt.proyect.domain.useCase;

import com.example.users.domain.exception.*;
import com.foodcourt.proyect.domain.exception.*;
import com.foodcourt.proyect.domain.model.Restaurant;
import com.foodcourt.proyect.domain.repositoryPort.RestaurantPersistencePort;
import com.foodcourt.proyect.domain.repositoryPort.UserPersistencePort;
import com.foodcourt.proyect.domain.servicePort.RestaurantServicePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CreateRestaurantUseCase implements RestaurantServicePort {

    private final RestaurantPersistencePort restaurantPersistencePort;
    private final UserPersistencePort userPersistencePort;

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        restaurantCreationValidations(restaurant);
        return restaurantPersistencePort.save(restaurant);
    }

    @Override
    public Restaurant findById(Long aLong) {
        return restaurantPersistencePort.findById(aLong);
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantPersistencePort.findAll();
    }

    @Override
    public Restaurant save(Restaurant entity) {
        return restaurantPersistencePort.save(entity);
    }

    @Override
    public void update(Restaurant entity) {
        if (restaurantPersistencePort.findById(entity.getId()) != null) {
            restaurantPersistencePort.save(entity);
        }
    }

    @Override
    public void delete(Restaurant entity) {
        restaurantPersistencePort.delete(entity);
    }

    private void restaurantCreationValidations(Restaurant entity) {

        if (!existentUser(entity.getOwnerId())) {
            throw new UsuarioInexistenteException();
        }
        if (!ownerRoleValidation(entity.getOwnerId())) {
            throw new UsuarioNoPropietarioException();
        }
        if (!validatePhone(entity.getPhone())) {
            throw new CelularNoValidoException();
        }
        if (!validateNit(entity.getNit())) {
            throw new NitNoNumericoException();
        }
        if (!validateRestaurantName(entity.getName())) {
            throw new NombreRestauranteException();
        }

    }

    private boolean existentUser(Long aLong) {
        return userPersistencePort.findById(aLong) != null;
    }

    private boolean ownerRoleValidation(Long aLong) {
        return userPersistencePort.findById(aLong).getIdrol() == 1;
    }

    private boolean validatePhone(String phone) {
        return phone == null || phone.matches("\\+?\\d{1,13}");
    }

    private boolean validateNit(String nit) {
        return nit == null || nit.matches("\\d+");
    }

    private boolean validateRestaurantName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NombreRestauranteException();
        }
        if (name.matches("\\d+")) {
            throw new NombreRestauranteException();
        }
        if (!name.matches(".*[a-zA-Z]+.*")) {
            throw new NombreRestauranteException();
        }
        return true;
    }
}
