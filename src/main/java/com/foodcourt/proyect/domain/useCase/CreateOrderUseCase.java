package com.foodcourt.proyect.domain.useCase;

import com.foodcourt.proyect.domain.exception.PedidoDeClientInvalidoException;
import com.foodcourt.proyect.domain.exception.PlatoInexistenteException;
import com.foodcourt.proyect.domain.exception.RestauranteInexistenteException;
import com.foodcourt.proyect.domain.model.Order;
import com.foodcourt.proyect.domain.model.OrderStatus;
import com.foodcourt.proyect.domain.model.Plate;
import com.foodcourt.proyect.domain.repositoryPort.OrderPersistencePort;
import com.foodcourt.proyect.domain.repositoryPort.PlatePersistencePort;
import com.foodcourt.proyect.domain.repositoryPort.RestaurantPersistencePort;
import com.foodcourt.proyect.domain.repositoryPort.UserPersistencePort;
import com.foodcourt.proyect.domain.servicePort.OrderServicePort;
import com.foodcourt.proyect.infrastructure.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CreateOrderUseCase implements OrderServicePort {

    private final OrderPersistencePort orderPersistencePort;
    private final PlatePersistencePort platePersistencePort;
    private final RestaurantPersistencePort restaurantPersistencePort;
    private final UserPersistencePort userPersistencePort;


    public Order createOrder(Order order) {
        order.setClientId(getClientId());
        order.setRestaurantId(getRestaurantId(order.getPlateList()));
        validateOrder(order);
        order.setStatus(OrderStatus.PENDING);
        orderPersistencePort.save(order);
        return order;
    }

    private void validateOrder(Order order) {

        if (!validateExistentRestaurant(order.getRestaurantId())) {
            throw new RestauranteInexistenteException();
        }
        if (!validateExistentPlate(order.getPlateList())) {
            throw new PlatoInexistenteException();
        }
        if (!validateUserOrderStatus(order.getClientId())) {
            throw new PedidoDeClientInvalidoException();
        }
        if (!validatePlateSameRestaurant(order.getPlateList(), getRestaurantId(order.getPlateList()))) {
            throw new PedidoDeClientInvalidoException();
        }
    }

    private Long getClientId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = (UserEntity) authentication.getPrincipal();
        return userPersistencePort.findIdByMail(user.getMail());
    }

    private Long getRestaurantId(String plateIds) {
        List<String> list = Arrays.asList(plateIds.split(","));
        return platePersistencePort.findById(Long.parseLong(list.get(0))).getRestaurantId();
    }


    private boolean validateExistentRestaurant(Long restaurantId) {
        return restaurantPersistencePort.findById(restaurantId) != null;
    }

    private boolean validateExistentPlate(String plateIds) {
        List<String> list = Arrays.asList(plateIds.split(","));
        List<Plate> pltList = platePersistencePort.findAll();
        return list.stream().allMatch(plateIdStr -> {
            Long plateId = Long.parseLong(plateIdStr.trim());
            return pltList.stream().anyMatch(plate -> plate.getId().equals(plateId));
        });
    }

    private boolean validatePlateSameRestaurant(String plateIds, Long restaurantId) {
        List<String> idList = Arrays.asList(plateIds.split(","));
        return idList.stream().allMatch(plateIdStr -> {
            Long plateId = Long.parseLong(plateIdStr.trim());
            Plate existingPlate = platePersistencePort.findById(plateId);
            return existingPlate != null && existingPlate.getRestaurantId().equals(restaurantId);
        });
    }

    private boolean validateUserOrderStatus(Long clientId) {
        List<Order> orders = orderPersistencePort.findAll();
        return orders
                .stream()
                .filter(order -> order.getClientId().equals(clientId))
                .anyMatch(order -> order.getStatus() == OrderStatus.CANCELED
                        || order.getStatus() == OrderStatus.DELIVERED);
    }


    @Override
    public Order findById(Long aLong) {
        return null;
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