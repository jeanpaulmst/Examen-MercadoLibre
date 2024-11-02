package com.example.parcial.controllers;


import com.example.parcial.entities.Persona;
import com.example.parcial.services.PersonaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.parcial.DTOs.DTOPersona;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/persona")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl>{

    //metodo que recibe un json de Persona y devuelve si es o no mutante
    @PostMapping("/mutant")
    public ResponseEntity<?> analizePerson(@RequestBody DTOPersona dtoPersona) {

        try {
            boolean is_mutant = service.isMutant(dtoPersona.getDna());
            if(is_mutant){
                dtoPersona.setMutant(true);
                return ResponseEntity.status(HttpStatus.OK).body(dtoPersona);
            }else{
                dtoPersona.setMutant(false);
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(dtoPersona);
            }

        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/stats")
    public ResponseEntity<?> statistics() {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.getStatistics());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
