package com.foodcourt.proyect.infrastructure.comun;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CrudController<T, ID> {
    @GetMapping("/{id}")
    ResponseEntity<T> findById(@PathVariable ID id);

    @GetMapping
    ResponseEntity<List<T>> findAll();

    @PostMapping
    ResponseEntity<T> save(@RequestBody T entity);

    @PutMapping("/{id}")
    ResponseEntity<Void> update(@PathVariable ID id, @RequestBody T entity);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable ID id);
}
