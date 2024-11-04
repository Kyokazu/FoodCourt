package com.foodcourt.proyect.infrastructure.mapper;

import com.foodcourt.proyect.domain.model.User;
import com.foodcourt.proyect.infrastructure.comun.MapperBase;
import com.foodcourt.proyect.infrastructure.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper extends MapperBase<UserEntity, User> {
}
