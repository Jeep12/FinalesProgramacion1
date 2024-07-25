package Finales;

public class Final26_9_2018 {
	public static final int MAXF = 4;
	public static final int MAXC = 10;
	public static final int MAXA = 7;

	public static void main(String[] args) {
		int[][] MatSec = {

				{ 0, 7, 3, 4, 0, 0, 4, 5, 2, 0 },

				{ 0, 3, 2, 4, 2, 0, 1, 0, 0, 0 },

				{ 0, 0, 1, 7, 2, 0, 4, 4, 8, 0 },

				{ 0, 0, 3, 7, 0, 7, 3, 4, 0, 0 } };

		int[] patron = { 7, 3, 4, 0, 0, 0, 0 };
		int[] remplazo = { 9, 8, 7, 2, 0, 0, 0 };
		int inicio = 0;
		int fin = 0;
		int pos = 0;
		int longitudPatron = longitudArr(remplazo);

		for (int f = 0; f < MAXF; f++) {
			while (inicio < MAXC) {
				inicio = inicioSecuencia(MatSec[f], pos);
				if (inicio < MAXC) {
					fin = finSecuencia(MatSec[f], inicio);
					boolean iguales = compararSec(MatSec[f], inicio, fin, patron);
					if(iguales) {
						remplazarSec(MatSec[f],inicio,fin,remplazo);
					}

				}
				pos = fin + 1;
			}
			inicio = 0;
			fin = 0;
			pos = 0;
		}
		
	       for (int f = 0; f < MAXF; f++) {
	            for (int c = 0; c < MAXC; c++) {
	                System.out.print(MatSec[f][c] + " ");
	            }
	            System.out.println();
	        }

	}

	private static void remplazarSec(int[] fila, int inicio, int fin, int[] remplazo) {
			
	      int longitudReemplazo = longitudArr(remplazo);
	        for (int i = 0; i < longitudReemplazo; i++) {
	            fila[inicio + i] = remplazo[i];
	        }
		
	}

	public static boolean compararSec(int[] fila, int inicio, int fin, int[] patron) {
		int longitudSecuencia = longitudSec(fila, fin, inicio);
		int longitudPatron = longitudArr(patron);
		if (longitudSecuencia != longitudPatron) {
			return false;
		}
		for (int i = 0; i < longitudPatron; i++) {
			if (fila[inicio + i] != patron[i]) {
				return false;
			}
		}
		return true;
	}

	public static int longitudSec(int arr[], int fin, int inicio) {
		return fin - inicio + 1;
	}

	public static int inicioSecuencia(int[] arr, int inicio) {
		while (inicio < MAXC && arr[inicio] == 0) {
			inicio++;
		}
		return inicio;
	}

	public static int finSecuencia(int arr[], int inicio) {
		while (inicio < MAXC && arr[inicio] != 0) {
			inicio++;
		}
		if (inicio < MAXC) {
			return inicio - 1;
		} else {
			return MAXC - 1; // Return the last index
		}
	}

	public static int longitudArr(int arr[]) {
		int contador = 0;

		for (int i = 0; i < MAXA; i++) {
			if (arr[i] != 0) {
				contador++;
			}
		}

		return contador;

	}
}
