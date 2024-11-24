package com.foodcourt.proyect.domain.repositoryPort;

import com.foodcourt.proyect.domain.comun.CrudBase;
import com.foodcourt.proyect.domain.model.StatusChange;
import com.foodcourt.proyect.infrastructure.persistence.mongodb.entity.StatusChangeEntity;

import java.util.List;

public interface StatusChangePersistencePort {

    public void registerStatusChange(StatusChange statusChange);

    List<StatusChange> getAll();
}
