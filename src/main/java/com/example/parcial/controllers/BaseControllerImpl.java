package com.example.parcial.controllers;

import java.io.Serializable;
import com.example.inicial1.entities.Base;
import com.example.inicial1.controllers.BaseController;
import com.example.parcial.entities.Persona;
import com.example.parcial.services.BaseServiceImpl;
import com.example.parcial.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E, Long>> implements BaseController<E, Long> {

    @Autowired
    protected S service;

    @Override
    public ResponseEntity<?> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<?> getOne(Long id) {
        return null;
    }

    //metodo que recibe un json de Persona y devuelve si es o no mutante
    @Override
    public ResponseEntity<?> save(E entity) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(Long id, E entity) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return null;
    }



}
