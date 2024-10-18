package com.example.parcial.services;

import com.example.parcial.entities.Persona;
import com.example.parcial.repositories.BaseRepository;
import com.example.parcial.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService, Serializable {

    @Autowired
    protected PersonaRepository repository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository) {
        super(baseRepository);
    }

    //para convertir una lista de strings en una matriz para trabajrlo más facil
    public char[][] convertToMatrix(List<String> dna) {
        int rows = dna.size();
        int cols = dna.get(0).length();
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            String str = dna.get(i);
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = str.charAt(j);
            }
        }
        return matrix;
    }

    public boolean isMutant(List<String> dna) {

        boolean is_mutant = false;

        char[][] newDna = convertToMatrix(dna);

        int N = newDna.length - 1;

        //valores iniciales
        char letterFound = 'Z';
        boolean foundDifferentOne = false;

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {

                //para verificar horizontalmente
                if (j <= N - 3) {
                    if (newDna[i][j] == newDna[i][j + 1] && newDna[i][j + 1] == newDna[i][j + 2] && newDna[i][j + 2] == newDna[i][j + 3]) {

                        if (letterFound == 'Z') {
                            letterFound = newDna[i][j];
                        }
                        if (letterFound != newDna[i][j] && letterFound != 'Z') {
                            foundDifferentOne = true;
                        }

                    }
                }

                //para verificar verticalmente
                if (i <= N - 3) {
                    if (newDna[i][j] == newDna[i + 1][j] && newDna[i + 1][j] == newDna[i + 2][j] && newDna[i + 2][j] == newDna[i + 3][j]) {

                        if (letterFound == 'Z') {
                            letterFound = newDna[i][j];
                        }
                        if (letterFound != newDna[i][j] && letterFound != 'Z') {
                            foundDifferentOne = true;
                        }
                    }
                }

                //para verificar diagonalmente
                if (i <= N - 3 && j <= N - 3) {
                    if (newDna[i][j] == newDna[i + 1][j + 1] && newDna[i + 1][j + 1] == newDna[i + 2][j + 2] && newDna[i + 2][j + 2] == newDna[i + 3][j + 3]) {

                        if (letterFound == 'Z') {
                            letterFound = newDna[i][j];
                        }
                        if (letterFound != newDna[i][j] && letterFound != 'Z') {
                            foundDifferentOne = true;
                        }

                    }
                }

                if (i <= N - 3 && j >= 3) {
                    if (newDna[i][j] == newDna[i + 1][j - 1] && newDna[i + 1][j - 1] == newDna[i + 2][j - 2] && newDna[i + 2][j - 2] == newDna[i + 3][j - 3]) {

                        if (letterFound == 'Z') {
                            letterFound = newDna[i][j];
                        }
                        if (letterFound != newDna[i][j] && letterFound != 'Z') {
                            foundDifferentOne = true;
                        }
                    }
                }

            }
        }

        if (foundDifferentOne) { //si se encontró que hay al menos más de un patrón de 4 letras pasa a true
            is_mutant = true;
        } else {
            is_mutant = false;
        }

        System.out.println("La persona es mutante: " + Boolean.toString(is_mutant));
        return is_mutant;

    }

    public HashMap<String,Serializable> getStatistics(){

        HashMap<String,Serializable> data = new HashMap<>();

        int countHumans = repository.findQuantityOfHumans();
        int countMutants = repository.findQuantityOfMutants();

        double ratio = (double)countMutants/(double)countHumans;

        data.put("cantMutantes", countMutants);
        data.put("cantHumanos", countHumans);
        data.put("ratio", ratio);

        return data;
    }
}
