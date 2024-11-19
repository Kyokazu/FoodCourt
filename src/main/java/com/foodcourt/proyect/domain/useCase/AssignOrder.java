package com.foodcourt.proyect.domain.useCase;

import com.foodcourt.proyect.domain.exception.OrdenInexistenteException;
import com.foodcourt.proyect.domain.exception.OrdenNoPendienteException;
import com.foodcourt.proyect.domain.exception.OrderDeOtroRestauranteException;
import com.foodcourt.proyect.domain.model.Order;
import com.foodcourt.proyect.domain.model.OrderStatus;
import com.foodcourt.proyect.domain.repositoryPort.OrderPersistencePort;
import com.foodcourt.proyect.domain.repositoryPort.RestaurantPersistencePort;
import com.foodcourt.proyect.domain.servicePort.OrderServicePort;
import com.foodcourt.proyect.infrastructure.dto.OrderDTO;
import com.foodcourt.proyect.infrastructure.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@RequiredArgsConstructor
@Qualifier("assignOrder")
public class AssignOrder implements OrderServicePort {

    private final OrderPersistencePort orderPersistencePort;
    private final RestaurantPersistencePort restaurantPersistencePort;


    @Override
    public Order createOrder(Order order) {
        return null;
    }

    @Override
    public List<OrderDTO> listOrders(Long orders, String status) {
        return List.of();
    }

    @Override
    public Order assignOrder(Long orderId) {
        validateExistentOrder(orderId);
        Order order = orderPersistencePort.findById(orderId);
        order.setAssignedEmployee(getEmployeeId());
        order.setStatus(OrderStatus.ON_PREPARATION);
        orderPersistencePort.update(order);
        return order;
    }

    private void validateExistentOrder(Long orderId) {
        Order order = orderPersistencePort.findById(orderId);
        if (order == null) {
            throw new OrdenInexistenteException();
        }
        if (order.getStatus() != OrderStatus.PENDING) {
            throw new OrdenNoPendienteException();
        }
        if (!validateOrderFromEmployeeRestaurant(order)) {
            throw new OrderDeOtroRestauranteException();
        }
    }

    private boolean validateOrderFromEmployeeRestaurant(Order order) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = (UserEntity) authentication.getPrincipal();
        return restaurantPersistencePort.findById(order.getRestaurantId()).getEmployees().contains(user.getId().toString());
    }

    private Long getEmployeeId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = (UserEntity) authentication.getPrincipal();
        return user.getId();
    }


    @Override
    public Order findById(Long aLong) {
        return orderPersistencePort.findById(aLong);
    }

    @Override
    public List<Order> findAll() {
        return List.of();
    }

    @Override
    public Order save(Order entity) {
        return null;
    }

    @Override
    public void update(Order entity) {

    }

    @Override
    public void delete(Order entity) {

    }
}
