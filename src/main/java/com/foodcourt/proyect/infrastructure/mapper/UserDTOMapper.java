package com.foodcourt.proyect.infrastructure.mapper;

import com.foodcourt.proyect.domain.model.User;
import com.foodcourt.proyect.infrastructure.comun.MapperBase;
import com.foodcourt.proyect.infrastructure.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDTOMapper extends MapperBase<UserDTO, User> {

}
