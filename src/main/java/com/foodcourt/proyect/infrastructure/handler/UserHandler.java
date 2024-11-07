package com.foodcourt.proyect.infrastructure.handler;

import com.foodcourt.proyect.domain.comun.CrudBase;
import com.foodcourt.proyect.domain.servicePort.UserServicePort;
import com.foodcourt.proyect.infrastructure.dto.UserDTO;
import com.foodcourt.proyect.infrastructure.mapper.UserDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service


public class UserHandler implements CrudBase<UserDTO, Long> {

    private final UserDTOMapper userDTOMapper;
    private final UserServicePort createOwnerServicePort;
    private final UserServicePort createEmployeeServicePort;

    public UserHandler(
            @Qualifier("createEmployee") UserServicePort createEmployeeServicePort,
            UserDTOMapper userDTOMapper,
            @Qualifier("createOwner") UserServicePort createOwnerServicePort) {
        this.createEmployeeServicePort = createEmployeeServicePort;
        this.userDTOMapper = userDTOMapper;
        this.createOwnerServicePort = createOwnerServicePort;
    }

    @Override
    public UserDTO findById(Long aLong) {
        return null;
    }

    @Override
    public List<UserDTO> findAll() {
        return null;
    }

    @Override
    public UserDTO save(UserDTO entity) {
        return null;
    }

    @Override
    public void update(UserDTO entity) {
    }

    @Override
    public void delete(UserDTO entity) {

    }

    public UserDTO createOwner(UserDTO userDTO) {
        return userDTOMapper.BToA(createOwnerServicePort.createOwner(userDTOMapper.AToB(userDTO)));
    }

    public UserDTO createEmployee(UserDTO userDTO) {
        return userDTOMapper.BToA(createEmployeeServicePort.createEmployee(userDTOMapper.AToB(userDTO)));
    }

}
