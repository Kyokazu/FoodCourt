package com.foodcourt.proyect.infrastructure.handler;

import com.foodcourt.proyect.domain.comun.CrudBase;
import com.foodcourt.proyect.domain.servicePort.UserServicePort;
import com.foodcourt.proyect.infrastructure.dto.UserDTO;
import com.foodcourt.proyect.infrastructure.mapper.UserDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserHandler implements CrudBase<UserDTO,Long> {

    private final UserDTOMapper userDTOMapper;
    private final UserServicePort userService;


    @Override
    public UserDTO findById(Long aLong) {
        return userDTOMapper.BToA(userService.findById(aLong));
    }

    @Override
    public List<UserDTO> findAll() {
        return userDTOMapper.BToA(userService.findAll().stream()).collect(Collectors.toList());
    }

    @Override
    public UserDTO save(UserDTO entity) {
        System.out.println("Saving user");
        return userDTOMapper.BToA(userService.save(userDTOMapper.AToB(entity)));
    }

    @Override
    public void update(UserDTO entity) {
        userService.update(userDTOMapper.AToB(entity));
    }

    @Override
    public void delete(UserDTO entity) {
        userService.delete(userDTOMapper.AToB(entity));
    }

    public UserDTO createOwner(UserDTO userDTO){
       return userDTOMapper.BToA(userService.createOwner(userDTOMapper.AToB(userDTO)));
    }

    public UserDTO createEmployee(UserDTO userDTO){
        return userDTOMapper.BToA(userService.createEmployee(userDTOMapper.AToB(userDTO)));
    }

}
