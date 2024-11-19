package com.foodcourt.proyect.infrastructure.handler;

import com.foodcourt.proyect.domain.comun.CrudBase;
import com.foodcourt.proyect.domain.servicePort.OrderServicePort;
import com.foodcourt.proyect.infrastructure.dto.OrderDTO;
import com.foodcourt.proyect.infrastructure.dto.OrderListDTO;
import com.foodcourt.proyect.infrastructure.mapper.OrderDTOMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderHandler implements CrudBase<OrderDTO, Long> {

    private final OrderDTOMapper orderDTOMapper;
    private final OrderServicePort createOrderServicePort;
    private final OrderServicePort listOrdersServicePort;

    public OrderHandler(OrderDTOMapper orderDTOMapper,
                        @Qualifier("createOrder") OrderServicePort createOrderServicePort,
                        @Qualifier("listOrders") OrderServicePort listOrdersServicePort) {
        this.orderDTOMapper = orderDTOMapper;
        this.createOrderServicePort = createOrderServicePort;
        this.listOrdersServicePort = listOrdersServicePort;
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {

        return orderDTOMapper.BToA(createOrderServicePort.createOrder(orderDTOMapper.AToB(orderDTO)));
    }

    public List<OrderDTO> listOrders(OrderListDTO orderList) {
        return listOrdersServicePort.listOrders(orderList.getSize(), orderList.getStatus());

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
