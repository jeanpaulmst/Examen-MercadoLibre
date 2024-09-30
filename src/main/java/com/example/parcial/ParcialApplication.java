package com.example.parcial;

import com.example.parcial.entities.Persona;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ParcialApplication {

	public static void main(String[] args) {

		SpringApplication.run(ParcialApplication.class, args);
		System.out.println("funcionando");
	}

	List<String> dna_example = Arrays.asList("ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG");

	Persona persona1 = Persona.builder().dna(dna_example).build();

	boolean result = Funcion.isMutant(persona1.getDna());



}
