package com.foodcourt.proyect.domain.repositoryPort;

import com.foodcourt.proyect.domain.comun.CrudBase;
import com.foodcourt.proyect.domain.model.User;

public interface UserPersistencePort extends CrudBase<User, Long> {
    Long findIdByMail(String mail);
}
