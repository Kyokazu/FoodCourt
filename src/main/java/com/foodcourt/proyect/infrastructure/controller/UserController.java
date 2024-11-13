package com.foodcourt.proyect.infrastructure.controller;

import com.foodcourt.proyect.infrastructure.comun.CrudController;
import com.foodcourt.proyect.infrastructure.dto.UserDTO;
import com.foodcourt.proyect.infrastructure.handler.UserHandler;
import com.foodcourt.proyect.infrastructure.security.AuthResponse;
import com.foodcourt.proyect.infrastructure.security.AuthService;
import com.foodcourt.proyect.infrastructure.security.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController implements CrudController<UserDTO, Long> {

    private final UserHandler userHandler;
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @Override
    public ResponseEntity<UserDTO> findById(Long aLong) {
        return new ResponseEntity<>(userHandler.findById(aLong), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<List<UserDTO>> findAll() {

        return new ResponseEntity<>(userHandler.findAll(), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<UserDTO> save(UserDTO entity) {
        return new ResponseEntity<>(userHandler.save(entity), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Void> update(Long aLong, UserDTO entity) {
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Void> delete(Long aLong) {
        return null;
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/createOwner")
    @Qualifier("createOwner")
    public ResponseEntity<UserDTO> createOwner(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userHandler.createOwner(userDTO), HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasRole('OWNER')")
    @PostMapping("/createEmployee")
    @Qualifier("createEmployee")
    public ResponseEntity<UserDTO> createEmployee(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userHandler.createEmployee(userDTO), HttpStatus.ACCEPTED);
    }

    @PostMapping("/createClient")
    @Qualifier("createClient")
    public ResponseEntity<UserDTO> createClient(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userHandler.createClient(userDTO), HttpStatus.ACCEPTED);
    }

}
