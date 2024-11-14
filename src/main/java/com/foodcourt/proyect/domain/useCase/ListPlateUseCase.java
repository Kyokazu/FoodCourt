package com.foodcourt.proyect.domain.useCase;

import com.foodcourt.proyect.domain.model.Plate;
import com.foodcourt.proyect.domain.model.Restaurant;
import com.foodcourt.proyect.domain.repositoryPort.PlatePersistencePort;
import com.foodcourt.proyect.domain.repositoryPort.RestaurantPersistencePort;
import com.foodcourt.proyect.domain.servicePort.PlateServicePort;
import com.foodcourt.proyect.infrastructure.dto.ListPlateDTO;
import com.foodcourt.proyect.infrastructure.dto.ListRestaurantDTO;
import com.foodcourt.proyect.infrastructure.dto.PageDTO;
import com.foodcourt.proyect.infrastructure.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.stream.Collectors;

@Qualifier("listPlate")
@RequiredArgsConstructor
public class ListPlateUseCase implements PlateServicePort {

    private final PlatePersistencePort platePersistencePort;
    private final RestaurantPersistencePort restaurantPersistencePort;


    @Override
    public Plate createPlate(Plate plate) {
        return null;
    }

    @Override
    public Plate updateFields(Plate plate) {
        return null;
    }

    @Override
    public Plate ableUnablePlate(Plate plate) {
        return null;
    }

    @Override
    public List<ListPlateDTO> listPlate(PageDTO pageDTO) {
        return getAllPlates(pageDTO);
    }

    public List<ListPlateDTO> getAllPlates(PageDTO pageDTO) {
        List<Plate> plate = platePersistencePort.findAll();

        return plate.stream()
                .filter(p -> p.getRestaurantId().equals(pageDTO.getRestaurantId()) && p.getCategory().equalsIgnoreCase(pageDTO.getCategory()))
                .sorted((r1, r2) -> r1.getName().compareToIgnoreCase(r2.getName()))
                .limit(pageDTO.getPage())
                .map(r -> new ListPlateDTO(r.getCategory(), r.getDescription(), r.getName(), r.getPrice(), r.getUrlImage()))
                .collect(Collectors.toList());
    }


    @Override
    public Plate findById(Long aLong) {
        return null;
    }

    @Override
    public List<Plate> findAll() {
        return List.of();
    }

    @Override
    public Plate save(Plate entity) {
        return null;
    }

    @Override
    public void update(Plate entity) {

    }

    @Override
    public void delete(Plate entity) {

    }


}
