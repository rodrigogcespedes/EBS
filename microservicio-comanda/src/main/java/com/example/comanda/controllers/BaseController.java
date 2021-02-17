package com.example.comanda.controllers;

import com.example.comanda.local_models.Base;
import com.example.comanda.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public abstract class BaseController<E extends Base, S extends BaseServiceImpl<E,Long>>{

    @Autowired
    public S service;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error\"}");
        }
    }

    @GetMapping("/paged")
    public ResponseEntity<?> getAll(Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody E entity) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error\"}");
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody E entity) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.update(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error\"}");
        }
    }
}
