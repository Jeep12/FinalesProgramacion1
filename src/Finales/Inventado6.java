package Finales;

public class Inventado6 {
	public static final int MAXF = 8;
	public static final int MAXC = 10;

	public static void main(String[] args) {
		int[][] matriz = {

				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

				{ 7, 1, 0, 3, 2, 0, 0, 2, 0, 0 },

				{ 3, 4, 5, 7, 0, 2, 4, 0, 8, 0 },

				{ 4, 0, 6, 0, 4, 0, 0, 0, 2, 5 },

				{ 0, 2, 3, 4, 4, 0, 6, 5, 9, 0 },

				{ 1, 2, 3, 4, 4, 0, 6, 5, 9, 0 },

				{ 1, 2, 3, 4, 0, 0, 6, 5, 9, 0 },

				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

		int[] patron = { 7, 3, 4, 0, 0, 0, 0 };
		int[] remplazo = { 9, 8, 7, 2, 0, 0, 0 };
		// Ejemplo de recorrido por columnas
		for (int c = 0; c < MAXC; c++) {
			System.out.println("columna " + c);
			int inicio = 0;
			int fin = 0;
			int pos = 0;
			while (inicio < MAXF) {
				inicio = inicioSecuencia(matriz, c, pos);
				if (inicio < MAXF) {
					fin = finSecuencia(matriz, c, inicio);
					boolean esIgual = compararSec(matriz, c, inicio, fin, patron);
					if (esIgual) {
						remplazarSec(matriz, c, inicio, fin, remplazo);
					}

				}
				pos = fin + 1;
			}
		}
	
		imprimirMatriz(matriz);
	}

	private static void remplazarSec(int[][] matriz, int c, int inicio, int fin, int[] remplazo) {
		int index = 0;
		for (int i = inicio; i <= fin; i++) {
			matriz[i][c] = remplazo[index];
			index++;
		}

	}

	private static boolean compararSec(int[][] matriz, int c, int inicio, int fin, int[] patron) {
		int longitudPatron = longitudPatron(patron);
		int longitudSecuencia = fin - inicio + 1;

		if (longitudPatron != longitudSecuencia) {
			return false;
		}
		for (int i = 0; i < longitudPatron; i++) {
			if (matriz[inicio + i][c] != patron[i]) {
				return false;
			}
		}

		return true;
	}

	public static int longitudPatron(int[] arr) {
		int contador = 0;
		for (int i = 0; i < 7; i++) {
			if (arr[i] != 0) {
				contador++;
			}
		}
		return contador;
	}

	private static void ordenarColumna(int[][] matriz, int c, int inicio, int fin) {
		// Ordenar la columna desde 'inicio' hasta 'fin'
		for (int i = inicio; i < fin; i++) {
			for (int j = i + 1; j <= fin; j++) {
				if (matriz[i][c] > matriz[j][c]) {
					// Intercambiar elementos si están en el orden incorrecto
					int temp = matriz[i][c];
					matriz[i][c] = matriz[j][c];
					matriz[j][c] = temp;
				}
			}
		}
	}

	private static int finSecuencia(int[][] matriz, int c, int inicio) {
		while (inicio < MAXF && matriz[inicio][c] != 0) {
			inicio++;
		}
		if (inicio < MAXF) {
			return inicio - 1;
		} else {
			return MAXF - 1;
		}
	}

	private static int inicioSecuencia(int[][] matriz, int c, int inicio) {
		while (inicio < MAXF && matriz[inicio][c] == 0) {
			inicio++;
		}
		return inicio;
	}
	private static void imprimirMatriz(int[][] matriz) {
        System.out.print("   ");
        for (int c = 0; c < MAXC; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
        for (int f = 0; f < MAXF; f++) {
            System.out.print(f + ": ");
            for (int c = 0; c < MAXC; c++) {
                System.out.print(matriz[f][c] + " ");
            }
            System.out.println();
        }
    }
}
