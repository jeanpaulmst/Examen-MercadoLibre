package com.example.parcial.repositories;

import com.example.parcial.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends BaseRepository<Persona, Long> {
}
