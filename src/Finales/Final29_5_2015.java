package Finales;

public class Final29_5_2015 {
    public static final int MAXF = 3;
    public static final int MAXC = 5;

    public static void main(String[] args) {
        int[][] matriz = {
            { 5, 4, 1, 2, 2 }, 
            { 1, 2, 2, 8, 24 }, 
            { 180, -7, 5, 20, 2 } 
        };

        for (int t = 0; t < MAXF; t++) {
            ordenarPares(matriz[t]);
            ordenarImpares(matriz[t]);
            moverParesAlPrincipio(matriz[t]);
        }

        // Imprimir la matriz ordenada
        for (int i = 0; i < MAXF; i++) {
            for (int j = 0; j < MAXC; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void ordenarPares(int[] arreglo) {
        for (int i = 0; i < MAXC - 1; i++) {
            for (int j = i + 1; j < MAXC; j++) {
                if (arreglo[i] % 2 == 0  && arreglo[i] > arreglo[j]) {
                    int temp = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = temp;
                }
            }
        }
    }

    public static void ordenarImpares(int[] arreglo) {
        for (int i = 0; i < MAXC - 1; i++) {
            for (int j = i + 1; j < MAXC; j++) {
                if (arreglo[i] % 2 != 0 && arreglo[i] > arreglo[j]) {
                    int temp = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = temp;
                }
            }
        }
    }

    public static void moverParesAlPrincipio(int[] arreglo) {
        int index = 0;
        for (int i = 0; i < MAXC; i++) { 
            if (arreglo[i] % 2 == 0) {
                int temp = arreglo[index];
                arreglo[index] = arreglo[i];
                arreglo[i] = temp;
                index++;
            }
        }
    }
    
    
}
