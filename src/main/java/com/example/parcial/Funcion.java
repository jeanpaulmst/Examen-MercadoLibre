package com.example.parcial;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Funcion {

    //para convertir una lista de strings en una matriz para trabajrlo más facil -- Hecho con mistarlIA
    public static char[][] convertToMatrix(List<String> dna) {
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

    public static boolean isMutant(List<String> dna){

        boolean is_mutant = false;

        char[][] newDna = convertToMatrix(dna);

        System.out.println(Integer.toString(newDna.length));    //6 -- anda bien

        for (int i = 0; i < newDna.length; i++){
            for(int j = 0; j < newDna.length; j++){

                //para verificar horizontalmente
                if(j <= newDna.length-3){
                    if(newDna[i][j] == newDna[i][j+1] && newDna[i][j+1] == newDna[i][j+2] && newDna[i][j+2] == newDna[i][j+3]){
                        is_mutant = true;
                        System.out.println("verifiqué por fila!");
                    }
                }

                //para verificar verticalmente
                if(j <= newDna.length-3){
                    if(newDna[j][i] == newDna[j+1][i] && newDna[j+1][i] == newDna[j+2][i] && newDna[j+2][i] == newDna[j+3][i]){
                        is_mutant = true;
                        System.out.println("verifiqué por columna!");
                    }
                }

                //para verificar diagonalmente
                if(i <= newDna.length-3 && j <= newDna.length-3){
                    if(newDna[i][j] == newDna[i+1][j+1] && newDna[i+1][j+1] == newDna[i+2][j+2] && newDna[i+2][j+2] == newDna[i+3][j+3]){
                        is_mutant = true;
                        System.out.println("verifiqué por diagonal!");
                    }
                }
                if(i <= newDna.length-3 && j >= 3){
                    if(newDna[i][j] == newDna[i+1][j-1] && newDna[i+1][j-1] == newDna[i+2][j-2] && newDna[i+2][j-2] == newDna[i+3][j-3]){
                        is_mutant = true;
                        System.out.println("verifiqué por diagonal!");
                    }
                }

            }
        }


        System.out.println(Boolean.toString(is_mutant));
        return is_mutant;
    }

}
