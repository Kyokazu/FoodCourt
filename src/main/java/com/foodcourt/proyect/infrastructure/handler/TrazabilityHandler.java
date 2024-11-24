package com.foodcourt.proyect.infrastructure.handler;


import com.foodcourt.proyect.domain.model.Order;
import com.foodcourt.proyect.domain.servicePort.StatusChangeServicePort;
import com.foodcourt.proyect.infrastructure.dto.StatusChangeDTO;
import com.foodcourt.proyect.infrastructure.mapper.StatusChangeDTOMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrazabilityHandler {

    private final StatusChangeServicePort statusChangeServicePort;
    private final StatusChangeDTOMapper statusChangeDTOMapper;


    public TrazabilityHandler(@Qualifier("statusChange") StatusChangeServicePort statusChangeServicePort,
                              StatusChangeDTOMapper statusChangeDTOMapper) {
        this.statusChangeServicePort = statusChangeServicePort;
        this.statusChangeDTOMapper = statusChangeDTOMapper;
    }

    public List<StatusChangeDTO> getOrdersInfo() {
        return statusChangeDTOMapper.BToA(statusChangeServicePort.checkOrderChangelog().stream()).collect(Collectors.toList());
    }

}
