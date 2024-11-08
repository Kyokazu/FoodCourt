package com.foodcourt.proyect.domain.servicePort;

import com.foodcourt.proyect.domain.comun.CrudBase;
import com.foodcourt.proyect.domain.model.Plate;

public interface PlateServicePort extends CrudBase<Plate, Long> {

    public Plate createPlate(Plate plate);

    public Plate updateFields(Plate plate);

    public Plate ableUnablePlate(Plate plate);
}
