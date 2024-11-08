package com.foodcourt.proyect.domain.useCase;

import com.foodcourt.proyect.domain.exception.PrecioInvalidoException;
import com.foodcourt.proyect.domain.exception.RestauranteInexistenteException;
import com.foodcourt.proyect.domain.model.Plate;
import com.foodcourt.proyect.domain.repositoryPort.PlatePersistencePort;
import com.foodcourt.proyect.domain.repositoryPort.RestaurantPersistencePort;
import com.foodcourt.proyect.domain.repositoryPort.UserPersistencePort;
import com.foodcourt.proyect.domain.servicePort.PlateServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@RequiredArgsConstructor
@Qualifier("createPlate")
public class CreatePlateUseCase implements PlateServicePort {

    private final PlatePersistencePort platePersistencePort;
    private final RestaurantPersistencePort restaurantPersistencePort;

    @Override
    public Plate createPlate(Plate plate) {
        if (!validateExistentRestaurant(plate.getRestaurantId())) {
            throw new RestauranteInexistenteException();
        }
        if (!validatePrice(plate.getPrice())) {
            throw new PrecioInvalidoException();
        }
        return platePersistencePort.save(plate);
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
    public Plate findById(Long aLong) {
        return platePersistencePort.findById(aLong);
    }

    @Override
    public List<Plate> findAll() {
        return platePersistencePort.findAll();
    }

    @Override
    public Plate save(Plate entity) {
        return platePersistencePort.save(entity);
    }

    @Override
    public void update(Plate entity) {
        if (platePersistencePort.findById(entity.getId()) != null) {
            platePersistencePort.save(entity);
        }
    }

    @Override
    public void delete(Plate entity) {
        platePersistencePort.delete(entity);
    }

    private boolean validateExistentRestaurant(Long id) {
        return restaurantPersistencePort.findById(id) != null;
    }

    private boolean validatePrice(int price) {
        return price > 0;
    }

}
