package com.example.parcial.services;

import com.example.parcial.entities.Persona;
import com.example.parcial.repositories.BaseRepository;
import com.example.parcial.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService, Serializable {

    @Autowired
    protected PersonaRepository repository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository) {
        super(baseRepository);
    }
}
