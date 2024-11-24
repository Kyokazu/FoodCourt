package com.foodcourt.proyect.domain.servicePort;

import com.foodcourt.proyect.domain.model.Order;
import com.foodcourt.proyect.domain.model.StatusChange;
import com.foodcourt.proyect.infrastructure.dto.EmployeeRankingDTO;
import com.foodcourt.proyect.infrastructure.dto.OrderRankingDTO;

import java.util.List;

public interface StatusChangeServicePort {

    public List<StatusChange> checkOrderChangelog();

    public List<OrderRankingDTO> getOrderRanking();

    public List<EmployeeRankingDTO> getEmployeeRanking();
}
