package com.example.parcial.controllers;

import java.io.Serializable;
import com.example.inicial1.entities.Base;
import com.example.inicial1.controllers.BaseController;
import com.example.parcial.entities.Persona;
import com.example.parcial.services.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class BaseControllerImpl<E extends Base, ID extends Serializable> implements BaseController<E, ID> {

    protected PersonaService service;

    @Override
    public ResponseEntity<?> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<?> getOne(ID id) {
        return null;
    }

    //metodo que recibe un json de Persona y devuelve si es o no mutante
    @Override
    public ResponseEntity<?> save(E entity) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(ID id, E entity) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(ID id) {
        return null;
    }


}
