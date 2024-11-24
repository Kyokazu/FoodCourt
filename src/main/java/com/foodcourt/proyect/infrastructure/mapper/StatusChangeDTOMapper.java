package com.foodcourt.proyect.infrastructure.mapper;

import com.foodcourt.proyect.domain.model.StatusChange;
import com.foodcourt.proyect.infrastructure.comun.MapperBase;
import com.foodcourt.proyect.infrastructure.dto.StatusChangeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatusChangeDTOMapper extends MapperBase<StatusChangeDTO, StatusChange> {
}
