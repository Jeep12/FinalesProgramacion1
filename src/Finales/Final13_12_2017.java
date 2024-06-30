package Finales;

public class Final13_12_2017 {
    public static final int N = 22;

    public static void main(String[] args) {
        char[] AR = {'J', 'U', 'A', 'N', ' ', 'A', 'B', 'R', 'E', ' ', 'L', 'A', ' ', ' ', 'P', 'U', 'E', 'R', 'T', 'A', ' ', ' '};
        int cantSecuencias = cantidadSecuencias(AR);
        char[][] MAT = new char[cantSecuencias][N];
        System.out.println(AR.length);
        for (int i = 0; i < cantSecuencias; i++) {
            int inicio = 0;
            int pos = 0;
            int fin = 0;
            char menor = menorInicial(AR);

            while (inicio < N) {
                inicio = inicioSecuencia(AR, pos);
                if (inicio < N) {
                    fin = finSecuencia(AR, inicio);
                    if (AR[inicio] == menor) {
                        llenarMatriz(MAT[i], AR, inicio, fin);
                        eliminarSecuencia(AR, inicio, fin);
                        break;
                    }
                }
                pos = fin + 1;
            }
        }

        System.out.println("Matriz resultante:");
        imprimir(MAT, cantSecuencias);
    }

    public static void imprimir(char[][] matriz, int filas) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < N; j++) {
                if (matriz[i][j] != '\0') {
                    System.out.print(matriz[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void eliminarSecuencia(char[] arr, int inicio, int fin) {
        for (int i = inicio; i <= fin; i++) {
            corrimientoIzquierda(arr, inicio);
        }
    }

    public static void corrimientoIzquierda(char[] arr, int pos) {
        while (pos < N - 1) {
            arr[pos] = arr[pos + 1];
            pos++;
        }
        arr[N - 1] = ' '; // Llenar el último espacio con un espacio
    }

    public static void llenarMatriz(char[] fila, char[] arr, int inicio, int fin) {
        int contador = 0;
        for (int i = inicio; i <= fin; i++) {
            fila[contador] = arr[i];
            contador++;
        }
    }

    public static char menorInicial(char[] arr) {
        int inicio = 0;
        int pos = 0;
        int fin = 0;
        char menor = 'Z' + 1; // Mayor que cualquier letra del alfabeto
        while (inicio < N) {
            inicio = inicioSecuencia(arr, pos);
            if (inicio < N) {
                fin = finSecuencia(arr, inicio);
                if (arr[inicio] < menor) {
                    menor = arr[inicio];
                }
            }
            pos = fin + 1;
        }
        return menor;
    }

    public static int cantidadSecuencias(char[] arr) {
        int inicio = 0;
        int fin = 0;
        int pos = 0;
        int contador = 0;
        while (inicio < N) {
            inicio = inicioSecuencia(arr, pos);
            if (inicio < N) {
                fin = finSecuencia(arr, inicio);
                contador++;
            }
            pos = fin + 1;
        }
        return contador;
    }

    public static int inicioSecuencia(char arr[], int inicio) {
        while (inicio < N && arr[inicio] == ' ') {
            inicio++;
        }
        return inicio;
    }

    public static int finSecuencia(char arr[], int inicio) {
        while (inicio < N && arr[inicio] != ' ') {
            inicio++;
        }
        if (inicio < N) {
            return inicio - 1;
        } else {
            return N - 1; // Return the last index
        }
    }
}
