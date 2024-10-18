package com.example.parcial;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class Funcion {

    //para convertir una lista de strings en una matriz para trabajrlo más facil
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

    //toma los 4 primero elementos de una lista y los compara
    public static boolean areEqual(List<Character> fourLetters){
        if(fourLetters.get(0) == fourLetters.get(1) &&
                fourLetters.get(1) == fourLetters.get(2) &&
                fourLetters.get(2) == fourLetters.get(3)){
            return true;
        }
        else{
            return false;
        }
    }

    // devuelve si 
    public static boolean isMutant(List<String> dna){

        //==== MANEJO DE ERRORES ====//
        //Si la matriz está vacía
        if(dna.isEmpty()){throw new RuntimeException("Error: Lista vacía");}
        //Si la matriz tiene valores null

        //Si la matriz no es cuadrada
        if(dna.get(0).length() != dna.size()){throw new RuntimeException("Error: La matriz debe ser cuadrada");}
        //============================//

        char[][] newDna = convertToMatrix(dna);

        int N = newDna.length-1;    //ultimo elemento en fila y columna

        //Guarda los caracteres distintos encontrados
        HashSet<Character> distintosEncontrados = new HashSet<>();

        //si encuentra una coincidencia de dos elementos guarda 4 elementos acá
        List<Character> fourLetters = new ArrayList<>(); // no se repiten

        //Itera la matriz
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= N; j+=2){

                boolean found = false;  //se pone en true si los 4 caracteres son iguales

                if(j <= N-3) {       //para que no acceda fuera de la matriz

                    //verificar por horizontal
                    if (newDna[i][j] == newDna[i][j + 2]) {
                        try {                                        //accede desde izquierda
                            char primerElemento = newDna[i][j - 1];
                            fourLetters.add(primerElemento);
                            fourLetters.add(newDna[i][j]);
                            fourLetters.add(newDna[i][j + 1]);
                            fourLetters.add(newDna[i][j + 2]);
                            System.out.println("fourLetters: " + fourLetters.toString());

                            //se analiza si los 4 son iguales
                            found = areEqual(fourLetters);
                            fourLetters.clear();
                            if (found) {
                                distintosEncontrados.add(primerElemento);
                            }

                        } catch (ArrayIndexOutOfBoundsException e) {  //accede desde derecha
                            //no hace nada, sigue al finally
                        } finally {
                            try {
                                char ultimoElemento = newDna[i][j + 3];
                                fourLetters.add(newDna[i][j]);
                                fourLetters.add(newDna[i][j + 1]);
                                fourLetters.add(newDna[i][j + 2]);
                                fourLetters.add(ultimoElemento);
                                System.out.println("fourLetters: " + fourLetters.toString());

                                //se analiza si los 4 son iguales
                                found = areEqual(fourLetters);
                                fourLetters.clear();
                                if (found) {
                                    distintosEncontrados.add(ultimoElemento);
                                }

                            } catch (ArrayIndexOutOfBoundsException e) {
                                //no hace nada, sigue ejecución normal
                            }
                        }
                    }

                    //verificar por vertical
                    if (newDna[j][i] == newDna[j + 2][i]) {
                        try {                                        //accede desde arriba
                            char primerElemento = newDna[j - 1][i];
                            fourLetters.add(primerElemento);
                            fourLetters.add(newDna[j][i]);
                            fourLetters.add(newDna[j + 1][i]);
                            fourLetters.add(newDna[j + 2][i]);
                            System.out.println("fourLetters: " + fourLetters.toString());

                            //se analiza si los 4 son iguales
                            found = areEqual(fourLetters);
                            fourLetters.clear();
                            if (found) {
                                distintosEncontrados.add(primerElemento);
                            }

                        } catch (ArrayIndexOutOfBoundsException e) {  //accede desde abajo
                            //no hace nada, sigue al finally
                        } finally {
                            try {
                                char ultimoElemento = newDna[j + 3][i];
                                fourLetters.add(newDna[j][i]);
                                fourLetters.add(newDna[j + 1][i]);
                                fourLetters.add(newDna[j + 2][i]);
                                fourLetters.add(ultimoElemento);
                                System.out.println("fourLetters: " + fourLetters.toString());

                                //se analiza si los 4 son iguales
                                found = areEqual(fourLetters);
                                fourLetters.clear();
                                if (found) {
                                    distintosEncontrados.add(ultimoElemento);
                                }

                            } catch (ArrayIndexOutOfBoundsException e) {
                                //no hace nada, sigue ejecución normal
                            }
                        }
                    }
                }

                //verificar por diagonales
                if(i <= N-3 && j <= N-3) { //diagonal izq derecha
                    if(newDna[i][j] == newDna[i+2][j+2]){
                        try {                                        //accede desde izquierda
                            char primerElemento = newDna[i - 1][j - 1];
                            fourLetters.add(primerElemento);
                            fourLetters.add(newDna[i][j]);
                            fourLetters.add(newDna[i + 1][j + 1]);
                            fourLetters.add(newDna[i + 2][j + 2]);
                            System.out.println("fourLetters: " + fourLetters.toString());

                            //se analiza si los 4 son iguales
                            found = areEqual(fourLetters);
                            fourLetters.clear();
                            if (found) {
                                distintosEncontrados.add(primerElemento);
                            }

                        } catch (ArrayIndexOutOfBoundsException e) {  //accede desde derecha
                            //no hace nada, sigue al finally
                        } finally {
                            try {
                                char ultimoElemento = newDna[i][j + 3];
                                fourLetters.add(newDna[i][j]);
                                fourLetters.add(newDna[i + 1][j + 1]);
                                fourLetters.add(newDna[i + 2][j + 2]);
                                fourLetters.add(ultimoElemento);
                                System.out.println("fourLetters: " + fourLetters.toString());

                                //se analiza si los 4 son iguales
                                found = areEqual(fourLetters);
                                fourLetters.clear();
                                if (found) {
                                    distintosEncontrados.add(ultimoElemento);
                                }

                            } catch (ArrayIndexOutOfBoundsException e) {
                                //no hace nada, sigue ejecución normal
                            }
                        }
                    }
                }
                if(i <= N-3 && j >=3) { //diagonal derecha izq
                    if (newDna[i][j] == newDna[i + 2][j - 2]) {
                        try {                                        //accede desde izquierda
                            char primerElemento = newDna[i - 1][j + 1];
                            fourLetters.add(primerElemento);
                            fourLetters.add(newDna[i][j]);
                            fourLetters.add(newDna[i + 1][j - 1]);
                            fourLetters.add(newDna[i + 2][j - 2]);
                            System.out.println("fourLetters: " + fourLetters.toString());

                            //se analiza si los 4 son iguales
                            found = areEqual(fourLetters);
                            fourLetters.clear();
                            if (found) {
                                distintosEncontrados.add(primerElemento);
                            }

                        } catch (ArrayIndexOutOfBoundsException e) {  //accede desde derecha
                            //no hace nada, sigue al finally
                        } finally {
                            try {
                                char ultimoElemento = newDna[i + 3][j - 3];
                                fourLetters.add(newDna[i][j]);
                                fourLetters.add(newDna[i + 1][j - 1]);
                                fourLetters.add(newDna[i + 2][j - 2]);
                                fourLetters.add(ultimoElemento);
                                System.out.println("fourLetters: " + fourLetters.toString());

                                //se analiza si los 4 son iguales
                                found = areEqual(fourLetters);
                                fourLetters.clear();
                                if (found) {
                                    distintosEncontrados.add(ultimoElemento);
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                                //no hace nada, sigue ejecución normal
                            }
                        }
                    }
                }
                //verificar si ya existe más de un elemento distinto encontrado
                if(distintosEncontrados.size() > 1){
                    System.out.println("Elementos distintos encontrados: " + distintosEncontrados.size());
                    System.out.println("True");
                    return true;
                }
            }
        }
        System.out.println("False");
        return false;
    }
}
