package edu.pucmm;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author me@fredpena.dev
 * @created 02/06/2025  - 20:46
 */
public class ParallelMatrixSearch {

    private static final int MATRIX_SIZE = 1000;
    private static final int THREAD_COUNT = 4;
    private static final int[][] matrix = new int[MATRIX_SIZE][MATRIX_SIZE];
    private static final int TARGET = 256; // Número a buscar

    public static void main(String[] args) {
        fillMatrixRandom();

        long startTime = System.nanoTime();
        sequentialSearch();
        long endTime = System.nanoTime();
        System.out.println("Tiempo búsqueda secuencial: " + ((endTime - startTime) / 1_000_000) + "ms");

        // Medir el tiempo de ejecución de la búsqueda paralela
        // startTime = System.nanoTime();
        // parallelSearch();
        // endTime = System.nanoTime();
        // System.out.println("Tiempo búsqueda paralela: " + ((endTime - startTime) / 1_000_000) + "ms");
    }

    private static void sequentialSearch() {
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                if(matrix[i][j] == TARGET){
                    System.out.println("lo encontro");
                    return;
                }
            }
        }
    }

    private static void parallelSearch() {
        // Implementar búsqueda paralela
        // Sugerencia: usar AtomicBoolean para indicar si ya se encontró el número y detener hilos
    }

    private static void fillMatrixRandom() {
        Random rand = new Random();
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                matrix[i][j] = rand.nextInt(1000); // Rango arbitrario
            }
        }
    }
}