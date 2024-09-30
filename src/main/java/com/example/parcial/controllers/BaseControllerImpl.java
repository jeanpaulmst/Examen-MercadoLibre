package com.example.parcial.controllers;

import java.io.Serializable;
import com.example.inicial1.entities.Base;
import com.example.inicial1.controllers.BaseController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class BaseControllerImpl<E extends Base, ID extends Serializable> implements BaseController<E, ID> {




    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<?> getOne(ID id) {
        return null;
    }

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
