package com.foodcourt.proyect.infrastructure.controller;

import com.foodcourt.proyect.infrastructure.comun.CrudController;
import com.foodcourt.proyect.infrastructure.dto.RestaurantDTO;
import com.foodcourt.proyect.infrastructure.handler.RestaurantHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantController implements CrudController<RestaurantDTO, Long> {

    private final RestaurantHandler restaurantHandler;
    @Override
    public ResponseEntity<RestaurantDTO> findById(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<List<RestaurantDTO>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<RestaurantDTO> save(RestaurantDTO entity) {
        return null;
    }

    @Override
    public ResponseEntity<Void> update(Long aLong, RestaurantDTO entity) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Long aLong) {
        return null;
    }

    @PostMapping("/createRestaurant")
    public ResponseEntity<RestaurantDTO> createOwner(@RequestBody RestaurantDTO restaurantDTO){
        return new ResponseEntity<>(restaurantHandler.createRestaurant(restaurantDTO), HttpStatus.ACCEPTED);
    }
}
