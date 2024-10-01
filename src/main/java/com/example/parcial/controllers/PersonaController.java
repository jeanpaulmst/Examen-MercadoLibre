package com.example.parcial.controllers;


import com.example.parcial.Funcion;
import com.example.parcial.entities.Persona;
import com.example.parcial.services.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/persona")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl>{

    PersonaServiceImpl personaService;

    //metodo que recibe un json de Persona y devuelve si es o no mutante
    @PostMapping("/mutant")
    public ResponseEntity<?> analizePerson(@RequestBody Persona persona) {
        try {
            boolean is_mutant = Funcion.isMutant(persona.getDna());
            if(is_mutant){
                return ResponseEntity.status(HttpStatus.OK).body(null);
            }else{
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
            }

        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
