package com.foodcourt.proyect.infrastructure.mapper;

import com.foodcourt.proyect.domain.model.Restaurant;
import com.foodcourt.proyect.infrastructure.comun.MapperBase;
import com.foodcourt.proyect.infrastructure.persistence.entity.RestaurantEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantEntityMapper extends MapperBase<RestaurantEntity, Restaurant> {
}
