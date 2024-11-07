package com.foodcourt.proyect.infrastructure.handler;

import com.foodcourt.proyect.domain.comun.CrudBase;
import com.foodcourt.proyect.domain.servicePort.PlateServicePort;
import com.foodcourt.proyect.infrastructure.dto.PlateDTO;
import com.foodcourt.proyect.infrastructure.mapper.PlateDTOMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlateHandler implements CrudBase<PlateDTO, Long> {

    private final PlateDTOMapper plateDTOMapper;
    private final PlateServicePort createPlateServicePort;
    private final PlateServicePort updatePlateServicePort;

    public PlateHandler(@Qualifier("create") PlateServicePort createPlateServicePort,
                        PlateDTOMapper plateDTOMapper,
                        @Qualifier("update") PlateServicePort updatePlateServicePort) {
        this.createPlateServicePort = createPlateServicePort;
        this.plateDTOMapper = plateDTOMapper;
        this.updatePlateServicePort = updatePlateServicePort;
    }

    public PlateDTO createPlate(PlateDTO plateDTO) {
        return plateDTOMapper.BToA(createPlateServicePort.createPlate(plateDTOMapper.AToB(plateDTO)));
    }

    public PlateDTO updatePriceOrDescription(PlateDTO plateDTO) {
        return plateDTOMapper.BToA(updatePlateServicePort.updateFields(plateDTOMapper.AToB(plateDTO)));
    }

    @Override
    public PlateDTO findById(Long aLong) {
        return null;
    }

    @Override
    public List<PlateDTO> findAll() {
        return List.of();
    }

    @Override
    public PlateDTO save(PlateDTO entity) {
        return null;
    }

    @Override
    public void update(PlateDTO entity) {
    }

    @Override
    public void delete(PlateDTO entity) {

    }
}
