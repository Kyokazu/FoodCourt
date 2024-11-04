package com.foodcourt.proyect.infrastructure.mapper;

import com.foodcourt.proyect.domain.model.Plate;
import com.foodcourt.proyect.infrastructure.comun.MapperBase;
import com.foodcourt.proyect.infrastructure.dto.PlateDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlateDTOMapper extends MapperBase<PlateDTO, Plate> {
}
