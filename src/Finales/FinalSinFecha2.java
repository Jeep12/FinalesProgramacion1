package Finales;

public class FinalSinFecha2 {
	public static final int MAXC = 10;
	public static final int MAXF = 4;

	public static void main(String[] args) {
		int[][] matriz = {

				{ 0, 7, 3, 4, 0, 0, 4, 5, 2, 0 }, { 0, 3, 2, 4, 2, 0, 1, 0, 0, 0 }, { 0, 0, 7, 3, 4, 0, 4, 4, 8, 0 },
				{ 0, 0, 3, 7, 0, 7, 3, 4, 0, 0 } };

		int maxRepetidos = 0;
		int cont = 0;
		int[] secMasRepetida = new int[10];
		for (int i = 0; i < MAXF; i++) {
			System.out.println("fila nro " + (i + 1));
			int inicio = 0;
			int fin = 0;
			int pos = 0;
			while (inicio < MAXC) {
				inicio = inicioSecuencia(matriz[i], pos);
				if (inicio < MAXC) {
					fin = finSecuencia(matriz[i], inicio);
					int cantidad = contadorSecuencias(matriz, inicio, fin, matriz[i]);
					System.out.print("Inicio: " + inicio + " fin: " + fin + " = ");
					imprimirSec(matriz[i], inicio, fin);
					System.out.print(" Cantidad de repeticiones " + cantidad);
					System.out.println();

					if (cantidad > maxRepetidos) {
						maxRepetidos = cantidad;
						for (int t = inicio; t <= fin; t++) {
							secMasRepetida[cont++] = matriz[i][t];
						}
						cont =0;
					}
				}
				pos = fin + 1;
			}
		}
		for (int i = 0; i < 10; i++) {
			if (secMasRepetida[i] != 0) {

				System.out.print(" "+ secMasRepetida[i]);
			}
		}
		System.out.print(" Cantidad de repeticiones " + maxRepetidos);

	}

	public static void imprimirSec(int arr[], int inicio, int fin) {
		for (int i = inicio; i <= fin; i++) {
			System.out.print(" " + arr[i] + " ");
		}
	}

	public static int contadorSecuencias(int[][] matriz, int inicio, int fin, int[] fila) {
		int contador = 0;
		for (int i = 0; i < MAXF; i++) {
			int inicioS = 0;
			int finS = 0;
			int posS = 0;
			while (inicioS < MAXC) {
				inicioS = inicioSecuencia(matriz[i], posS);
				if (inicioS < MAXC) {
					finS = finSecuencia(matriz[i], inicioS);
					boolean comparar = compararSec(matriz[i], inicio, fin, inicioS, finS, fila);
					if (comparar) {
						contador++;
					}
				}
				posS = finS + 1;
			}
		}
		return contador;
	}

	public static boolean compararSec(int arr[], int inicio, int fin, int inicioS, int finS, int fila[]) {
		int longitud1 = fin - inicio + 1;
		int longitud2 = finS - inicioS + 1;

		if (longitud1 != longitud2) {
			return false;
		}
		for (int i = 0; i < longitud1; i++) {
			if (arr[inicioS + i] != fila[inicio + i]) {
				return false;
			}
		}
		return true;
	}

	public static int inicioSecuencia(int[] arr, int inicio) {
		while (inicio < MAXC && arr[inicio] == 0) {
			inicio++;
		}
		return inicio;
	}

	public static int finSecuencia(int[] arr, int inicio) {
		while (inicio < MAXC && arr[inicio] != 0) {
			inicio++;
		}
		if (inicio < MAXC) {
			return inicio - 1;
		} else {
			return MAXC - 1;
		}
	}
}
