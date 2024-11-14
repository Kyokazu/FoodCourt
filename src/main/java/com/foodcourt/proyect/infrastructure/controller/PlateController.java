package com.foodcourt.proyect.infrastructure.controller;


import com.foodcourt.proyect.infrastructure.comun.CrudController;
import com.foodcourt.proyect.infrastructure.dto.ListPlateDTO;
import com.foodcourt.proyect.infrastructure.dto.PageDTO;
import com.foodcourt.proyect.infrastructure.dto.PlateDTO;
import com.foodcourt.proyect.infrastructure.handler.PlateHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plate")
public class PlateController implements CrudController<PlateDTO, Long> {

    private final PlateHandler plateHandler;

    @PreAuthorize("hasRole('OWNER')")
    @PostMapping("/createPlate")
    @Qualifier("createPlate")
    public ResponseEntity<PlateDTO> createPlate(@RequestBody PlateDTO plate) {
        return new ResponseEntity<>(plateHandler.createPlate(plate), HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasRole('OWNER')")
    @PutMapping("/updatePlate")
    @Qualifier("updatePlate")
    public ResponseEntity<PlateDTO> updateFields(@RequestBody PlateDTO plate) {
        return new ResponseEntity<>(plateHandler.updatePriceOrDescription(plate), HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasRole('OWNER')")
    @PutMapping("/enableUnablePlate")
    @Qualifier("enableUnablePlate")
    public ResponseEntity<PlateDTO> enableUnablePlate(@RequestBody PlateDTO plate) {
        return new ResponseEntity<PlateDTO>(plateHandler.enableUnablePlate(plate), HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasRole('CLIENT')")
    @PostMapping("/listPlate")
    @Qualifier("/listPlate")
    public ResponseEntity<List<ListPlateDTO>> listPlate(@RequestBody PageDTO pageDTO) {
        return new ResponseEntity<List<ListPlateDTO>>(plateHandler.listPlate(pageDTO), HttpStatus.ACCEPTED);
    }


    @Override
    public ResponseEntity<PlateDTO> findById(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<List<PlateDTO>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<PlateDTO> save(PlateDTO entity) {
        return null;
    }

    @Override
    public ResponseEntity<Void> update(Long aLong, PlateDTO entity) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Long aLong) {
        return null;
    }
}
