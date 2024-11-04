package com.foodcourt.proyect.domain.useCase;

import com.foodcourt.proyect.domain.exception.CamposPlatosException;
import com.foodcourt.proyect.domain.exception.PlatoInexistenteException;
import com.foodcourt.proyect.domain.exception.RestauranteInexistenteException;
import com.foodcourt.proyect.domain.model.Plate;
import com.foodcourt.proyect.domain.repositoryPort.PlatePersistencePort;
import com.foodcourt.proyect.domain.repositoryPort.RestaurantPersistencePort;
import com.foodcourt.proyect.domain.servicePort.PlateServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Qualifier("update")
public class UpdatePlateUseCase implements PlateServicePort {
    private final PlatePersistencePort platePersistencePort;
    private final RestaurantPersistencePort restaurantPersistencePort;

    @Override
    public Plate createPlate(Plate plate) {
        return null;
    }

    @Override
    public Plate updateFields(Plate plate) {
        if (!validateExistentRestaurant(plate.getRestaurantId())) {
            throw new RestauranteInexistenteException();
        }
        if (!verifyExistingPlate(plate.getId())) {
            throw new PlatoInexistenteException();
        }

        if (!verifyUpdateFields(plate)) {
            throw new CamposPlatosException();
        }
        platePersistencePort.update(plate);
        return plate;
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
    public void update(Plate plate) {

    }

    @Override
    public void delete(Plate entity) {

    }

    private boolean verifyUpdateFields(Plate plate) {
        return Objects.equals(plate.getDescription(), platePersistencePort.findById(plate.getId()).getDescription())
                && !Objects.equals(plate.getPrice(), platePersistencePort.findById(plate.getId()).getPrice());
    }

    private boolean verifyExistingPlate(Long id) {
        return platePersistencePort.findById(id) != null;
    }

    private boolean validateExistentRestaurant(Long id) {
        return restaurantPersistencePort.findById(id) != null;
    }
}
