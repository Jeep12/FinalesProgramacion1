package Finales;

public class Final8_8_2018 {
    public static final int MAXF = 3; // Número de filas
    public static final int MAXC = 4; // Número de columnas

    public static void main(String[] args) {
        int[][] matriz = {
            {12, 2, 1, 6},
            {9, 4, 7, 5},
            {1, 3, 2, 8}
        };

        // Ordenar la matriz en el lugar
        ordenarMatrizEnLugar(matriz);

        // Imprimir la matriz ordenada
        imprimirMatriz(matriz);
    }

    // Método para ordenar la matriz en el lugar usando el algoritmo de burbuja
    private static void ordenarMatrizEnLugar(int[][] matriz) {
        int totalElementos = MAXF * MAXC;

        for (int i = 0; i < totalElementos; i++) {
            // Convertir índice lineal a coordenadas de matriz
            int fila1 = i / MAXC;
            int col1 = i % MAXC;

            for (int j = i + 1; j < totalElementos; j++) {
                int fila2 = j / MAXC;
                int col2 = j % MAXC;

                // Comparar y intercambiar si es necesario
                if (matriz[fila1][col1] > matriz[fila2][col2]) {
                    int temp = matriz[fila1][col1];
                    matriz[fila1][col1] = matriz[fila2][col2];
                    matriz[fila2][col2] = temp;
                }
            }
        }
    }

    // Método para imprimir la matriz
    private static void imprimirMatriz(int[][] matriz) {
        for (int f = 0; f < MAXF; f++) {
            for (int c = 0; c < MAXC; c++) {
                System.out.print(matriz[f][c] + " ");
            }
            System.out.println();
        }
    }
}
