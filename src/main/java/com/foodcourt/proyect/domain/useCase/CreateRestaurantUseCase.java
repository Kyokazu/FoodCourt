package com.foodcourt.proyect.domain.useCase;

import com.foodcourt.proyect.domain.exception.*;
import com.foodcourt.proyect.domain.model.Restaurant;
import com.foodcourt.proyect.domain.repositoryPort.RestaurantPersistencePort;
import com.foodcourt.proyect.domain.repositoryPort.UserPersistencePort;
import com.foodcourt.proyect.domain.servicePort.RestaurantServicePort;
import com.foodcourt.proyect.infrastructure.dto.ListRestaurantDTO;
import com.foodcourt.proyect.infrastructure.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@RequiredArgsConstructor
public class CreateRestaurantUseCase implements RestaurantServicePort {

    private final RestaurantPersistencePort restaurantPersistencePort;
    private final UserPersistencePort userPersistencePort;


    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        restaurantCreationValidations(restaurant);
        restaurant.setOwnerId(getOwnerId());
        return restaurantPersistencePort.save(restaurant);
    }

    @Override
    public List<ListRestaurantDTO> getAllRestaurants(int cantidad) {
        return List.of();
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
        Long ownerId = getOwnerId();
        if (!existentUser(ownerId)) {
            throw new UsuarioInexistenteException();
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

    private Long getOwnerId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = (UserEntity) authentication.getPrincipal();
        return user.getId();
    }
}
