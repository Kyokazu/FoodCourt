package com.foodcourt.proyect.domain.useCase;

import com.foodcourt.proyect.domain.model.Order;
import com.foodcourt.proyect.domain.model.StatusChange;
import com.foodcourt.proyect.domain.repositoryPort.StatusChangePersistencePort;
import com.foodcourt.proyect.domain.repositoryPort.UserPersistencePort;
import com.foodcourt.proyect.domain.servicePort.StatusChangeServicePort;
import com.foodcourt.proyect.domain.util.StatusComparator;
import com.foodcourt.proyect.infrastructure.persistence.jpa.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class RegisterStatusChangeUseCase implements StatusChangeServicePort {

    private final StatusChangePersistencePort statusChangePersistencePort;

    public void registerStatusChange(Order order) {
        StatusChange statusChange = new StatusChange();
        statusChange.setOrderId(order.getId());
        System.out.println("Order ID: " + order.getId() + " ");
        statusChange.setStatus(order.getStatus().name());
        System.out.println("Status: " + order.getStatus().name() + " ");
        statusChange.setClientId(order.getClientId());
        System.out.println("Client ID: " + order.getClientId() + " ");
        statusChange.setChangeDate(new java.util.Date());
        System.out.println("Change date: " + statusChange.getChangeDate() + " ");
        statusChangePersistencePort.registerStatusChange(statusChange);
        System.out.println("Saved the status changed");
    }

    @Override
    public List<StatusChange> checkOrderChangelog() {
        List<StatusChange> statusChangeList = statusChangePersistencePort.getAll();
        Long clientId = getClientId();
        return statusChangeList.stream()
                .filter(statusChange -> statusChange.getClientId().equals(clientId))
                .collect(Collectors.toList());

    }

    private Long getClientId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = (UserEntity) authentication.getPrincipal();
        return user.getId();
    }

}

