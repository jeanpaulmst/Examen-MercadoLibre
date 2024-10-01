package com.example.inicial1.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseService<E, ID> {
    public List<E> findAll() throws Exception;  //trae una lista de todas las que se encuientran en nuestar BD
    public Page<E> findAll(Pageable pageable) throws Exception;
    public E findById(ID id) throws Exception;   //Encuentra elemento po id
    public E save(E entity) throws Exception;   //Guarda elemento en la BD
    public E update(ID id, E entity) throws Exception;    //Actualiza elemento en la BD
    public boolean delete(ID id) throws Exception;    //Elimina un registro de la BD

}
