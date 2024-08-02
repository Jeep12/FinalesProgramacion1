package Finales;

public class Final29_5_2015x2 {
	public static final int MAXF = 3;
	public static final int MAXC = 5;

	public static void main(String[] args) {
		int[][] matriz = { { 5, 4, 1, 2, 2 }, { 1, 2, 2, 8, 24 }, { 180, -7, 5, 20, 2 } };

		for (int t = 0; t < MAXF; t++) {

			moverParesAlPrincipio(matriz[t]);
			ordenar(matriz[t]);
		}

		// Imprimir la matriz ordenada
		for (int i = 0; i < MAXF; i++) {
			for (int j = 0; j < MAXC; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void ordenar(int[] arreglo) {
		int cantPares = cantidadPares(arreglo);
        int cantImpares = cantidadImpares(arreglo);


        // Ordenar pares
        if (cantPares > 1) {
            burbujeo(arreglo, 0, cantPares - 1);
        }
        // Ordenar impares
        if (cantImpares > 1) {
            burbujeo(arreglo, cantPares, MAXC - 1);
        }
	}

	public static void burbujeo(int[] arreglo, int start, int end) {
		for (int i = start; i < end; i++) {
			for (int j = start; j < end - (i - start); j++) {
				if (arreglo[j] > arreglo[j + 1]) {
					// Intercambiar elementos
					int temp = arreglo[j];
					arreglo[j] = arreglo[j + 1];
					arreglo[j + 1] = temp;
				}
			}
		}
	}

	public static int cantidadPares(int[] arr) {
		int count = 0;
		for (int num : arr) {
			if (num % 2 == 0) {
				count++;
			}
		}
		return count;
	}

	public static int cantidadImpares(int[] arr) {
		int count = 0;
		for (int num : arr) {
			if (num % 2 != 0) {
				count++;
			}
		}
		return count;
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
