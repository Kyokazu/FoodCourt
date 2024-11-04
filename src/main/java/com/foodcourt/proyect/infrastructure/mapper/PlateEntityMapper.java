package com.foodcourt.proyect.infrastructure.mapper;

import com.foodcourt.proyect.domain.model.Plate;
import com.foodcourt.proyect.infrastructure.comun.MapperBase;
import com.foodcourt.proyect.infrastructure.persistence.entity.PlateEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlateEntityMapper extends MapperBase<PlateEntity, Plate>{
}
