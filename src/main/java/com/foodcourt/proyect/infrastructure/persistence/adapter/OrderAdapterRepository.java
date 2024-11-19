package com.foodcourt.proyect.infrastructure.persistence.adapter;

import com.foodcourt.proyect.domain.model.Order;
import com.foodcourt.proyect.domain.repositoryPort.OrderPersistencePort;
import com.foodcourt.proyect.infrastructure.mapper.OrderEntityMapper;
import com.foodcourt.proyect.infrastructure.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class OrderAdapterRepository implements OrderPersistencePort {

    private final OrderRepository orderRepository;
    private final OrderEntityMapper orderEntityMapper;


    @Override
    public Order findById(Long aLong) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return orderEntityMapper.AToB(orderRepository.findAll().stream()).collect(Collectors.toList());
    }

    @Override
    public Order save(Order entity) {
        return orderEntityMapper.AToB(orderRepository.save(orderEntityMapper.BToA(entity)));
    }

    @Override
    public void update(Order entity) {

    }

    @Override
    public void delete(Order entity) {

    }

    @Override
    public Order createOrder(Order order) {
        return null;
    }
}
