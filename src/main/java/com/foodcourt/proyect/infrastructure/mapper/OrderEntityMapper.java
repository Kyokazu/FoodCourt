package com.foodcourt.proyect.infrastructure.mapper;

import com.foodcourt.proyect.domain.model.Order;
import com.foodcourt.proyect.infrastructure.comun.MapperBase;
import com.foodcourt.proyect.infrastructure.persistence.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderEntityMapper extends MapperBase<OrderEntity, Order> {
}
