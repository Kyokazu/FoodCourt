package com.foodcourt.proyect.infrastructure.handler;

import com.foodcourt.proyect.domain.comun.CrudBase;
import com.foodcourt.proyect.domain.servicePort.RestaurantServicePort;
import com.foodcourt.proyect.infrastructure.dto.RestaurantDTO;
import com.foodcourt.proyect.infrastructure.mapper.RestaurantDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantHandler implements CrudBase<RestaurantDTO, Long> {

    private final RestaurantDTOMapper restaurantDTOMapper;
    private final RestaurantServicePort restaurantServicePort;

    @Override
    public RestaurantDTO findById(Long aLong) {
        return restaurantDTOMapper.BToA(restaurantServicePort.findById(aLong));
    }

    @Override
    public List<RestaurantDTO> findAll() {
        return restaurantDTOMapper.BToA(restaurantServicePort.findAll().stream()).collect(Collectors.toList());
    }

    @Override
    public RestaurantDTO save(RestaurantDTO entity) {
        System.out.println("Saving restaurant");
        return restaurantDTOMapper.BToA(restaurantServicePort.save(restaurantDTOMapper.AToB(entity)));
    }

    @Override
    public void update(RestaurantDTO entity) {
        restaurantServicePort.update(restaurantDTOMapper.AToB(entity));
    }

    @Override
    public void delete(RestaurantDTO entity) {
        restaurantServicePort.delete(restaurantDTOMapper.AToB(entity));
    }

    public RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO){
       return  restaurantDTOMapper.BToA(restaurantServicePort.createRestaurant(restaurantDTOMapper.AToB(restaurantDTO)));
    }

}
