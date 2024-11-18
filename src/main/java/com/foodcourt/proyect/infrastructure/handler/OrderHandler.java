package com.foodcourt.proyect.infrastructure.handler;

import com.foodcourt.proyect.domain.comun.CrudBase;
import com.foodcourt.proyect.domain.servicePort.OrderServicePort;
import com.foodcourt.proyect.infrastructure.dto.OrderDTO;
import com.foodcourt.proyect.infrastructure.mapper.OrderDTOMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderHandler implements CrudBase<OrderDTO, Long> {

    private final OrderDTOMapper orderDTOMapper;
    private final OrderServicePort orderServicePort;

    public OrderHandler(OrderDTOMapper orderDTOMapper, OrderServicePort orderServicePort) {
        this.orderDTOMapper = orderDTOMapper;
        this.orderServicePort = orderServicePort;
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {

        return orderDTOMapper.BToA(orderServicePort.createOrder(orderDTOMapper.AToB(orderDTO)));
    }


    @Override
    public OrderDTO findById(Long aLong) {
        return null;
    }

    @Override
    public List<OrderDTO> findAll() {
        return List.of();
    }

    @Override
    public OrderDTO save(OrderDTO entity) {
        return null;
    }

    @Override
    public void update(OrderDTO entity) {

    }

    @Override
    public void delete(OrderDTO entity) {

    }
}
