package com.foodcourt.proyect.domain.servicePort;

import com.foodcourt.proyect.domain.model.User;
import com.foodcourt.proyect.domain.comun.CrudBase;

public interface UserServicePort extends CrudBase<User, Long> {

    public User createOwner(User user);

    public User createEmployee(User user);

    public User createClient(User user);
}
