package com.foodcourt.proyect.domain.servicePort;

import com.foodcourt.proyect.domain.model.Order;
import com.foodcourt.proyect.domain.model.StatusChange;

import java.util.List;

public interface StatusChangeServicePort {

    public void registerStatusChange(Order order);

    public List<StatusChange> checkOrderChangelog();
}
