package com.foodcourt.proyect.domain.repositoryPort;

import com.foodcourt.proyect.domain.comun.CrudBase;
import com.foodcourt.proyect.domain.model.Plate;

import java.util.List;

public interface PlatePersistencePort {
    Plate findById(Long aLong);

    List<Plate> findAll();

    Plate save(Plate entity);

    void update(Plate entity);
}
