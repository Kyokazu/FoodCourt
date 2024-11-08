package com.foodcourt.proyect.domain.useCase;

import com.foodcourt.proyect.domain.exception.PlatoInexistenteException;
import com.foodcourt.proyect.domain.exception.PropietarioDePlatoInvalidoException;
import com.foodcourt.proyect.domain.model.Plate;
import com.foodcourt.proyect.domain.repositoryPort.PlatePersistencePort;
import com.foodcourt.proyect.domain.repositoryPort.RestaurantPersistencePort;
import com.foodcourt.proyect.domain.repositoryPort.UserPersistencePort;
import com.foodcourt.proyect.domain.servicePort.PlateServicePort;
import com.foodcourt.proyect.infrastructure.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@RequiredArgsConstructor
@Qualifier("enableUnablePlate")
public class EnableUnablePlateUseCase implements PlateServicePort {

    private final PlatePersistencePort platePersistencePort;
    private final RestaurantPersistencePort restaurantPersistencePort;
    private final UserPersistencePort userPersistencePort;

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
        if (!validateExistentPlate(plate.getId())) {
            throw new PlatoInexistenteException();
        }

        if (!validatePlateOwner(plate.getId())) {
            throw new PropietarioDePlatoInvalidoException();
        }
        Plate oldPlate = platePersistencePort.findById(plate.getId());
        oldPlate.setActive(!oldPlate.isActive());
        platePersistencePort.update(oldPlate);
        return oldPlate;
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

    private boolean validatePlateOwner(Long plateId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = (UserEntity) authentication.getPrincipal();
        Plate plate = platePersistencePort.findById(plateId);
        Long userId = userPersistencePort.findIdByMail(user.getMail());
        return restaurantPersistencePort.findOwnerIdByRestaurantId(plate.getRestaurantId()).equals(userId);
    }

    private boolean validateExistentPlate(Long id) {
        return platePersistencePort.findById(id) != null;
    }

}
