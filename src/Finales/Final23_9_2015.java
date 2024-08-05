package Finales;

public class Final23_9_2015 {
	public final static int MAXF = 3;
	public static final int MAXC = 5;

	public static void main(String[] args) {
		int[][] matriz = { { 5, 4, 1, 2, 2 }, { 1, 2, 2, 8, 24 }, { 180, -7, 5, 20, 2 } };
		for (int f = 0; f < MAXF; f++) {

			moverPares(matriz[f]);
			ordenar(matriz[f]);
		}

		for (int i = 0; i < MAXF; i++) {
			for (int j = 0; j < MAXC; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void ordenar(int[] arr) {
		int cantPares = cantidadPares(arr);

		burbujeo(arr, 0, cantPares-1);
		burbujeo(arr, cantPares, MAXC-1);
	}

	public static void burbujeo(int[] arr, int inicio, int fin) {
		for (int i = inicio; i < fin; i++) {
			for (int j = inicio; j < fin - (i - inicio); j++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
	}

	public static void moverPares(int[] arr) {
		int index = 0;
		for (int i = 0; i < MAXC; i++) {
			if (arr[i] % 2 == 0) {
				int temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
				index++;

			}
		}
	}

	public static int cantidadPares(int[] arr) {
		int contador = 0;
		for (int i = 0; i < MAXC; i++) {
			if (arr[i] % 2 == 0) {
				contador++;
			}
		}
		return contador;
	}


}
