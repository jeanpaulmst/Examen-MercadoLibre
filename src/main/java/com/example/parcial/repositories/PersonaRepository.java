package com.example.parcial.repositories;

import com.example.parcial.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {


    //query para encontrar la cantidad de mutantes
    @Query("SELECT COUNT(m) FROM Persona m WHERE m.mutant = true" )
    Integer findQuantityOfMutants();

    //query para encontrar la cantidad de humanos
    @Query("SELECT COUNT(m) FROM Persona m WHERE m.mutant = false" )
    Integer findQuantityOfHumans();


}
