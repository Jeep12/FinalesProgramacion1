package Finales.pruebas;

public class CorrDerecha {
	public static final int MAXF = 4;
	public static final int MAXC = 18;

	public static void main(String[] args) {
		int[][] matriz = {

				{ 0, 7, 6, 0, 5, 6, 0, 6, 4, 0, 8, 6, 0, 0, 9, 8, 7, 0 },
				{ 0, 4, 4, 9, 0, 8, 0, 6, 5, 0, 7, 6, 0, 0, 5, 4, 3, 0 },
				{ 0, 6, 0, 5, 5, 0, 7, 0, 8, 8, 0, 4, 4, 0, 9, 9, 0, 0 },
				{ 0, 0, 7, 8, 7, 0, 9, 0, 5, 6, 0, 4, 4, 0, 6, 6, 0, 0 } };

//		for (int f = 0; f < MAXF; f++) {
//			int inicio = 0;
//			int fin = 0;
//			int pos = 0;
//
//			while (inicio < MAXC) {
//				inicio = inicioSecuencia(matriz[f], pos);
//				if (inicio < MAXC) {
//					fin = finSecuencia(matriz[f], inicio);
//					int tamanio = fin - inicio + 1;
//
//					if (tamanio % 2 != 0) {
//						corrimientoDerecha(matriz[f], inicio, fin);
//					}
//				}
//				pos = fin + 1;
//			}
//
//		}

		aplanarMatriz(matriz);
	}

	public static void aplanarMatriz(int matriz[][]) {
		int totalElementos = MAXC * MAXF;
		for (int i = 0; i < totalElementos; i++) {
			int fila = i / MAXC;
			int columna = i % MAXC;

			for (int j = i + 1; j < totalElementos; j++) {
				int fila2 = j / MAXC;
				int columna2 = j % MAXC;

				if (matriz[fila][columna] > matriz[fila2][columna2]) {
					int temp = matriz[fila][columna];
					matriz[fila][columna] = matriz[fila2][columna2];
					matriz[fila2][columna2] = temp;
				}
			}
			System.out.print(" " + matriz[fila][columna]);
		}
	}

	private static void corrimientoDerecha(int[] arr, int inicio, int fin) {
		if (fin < MAXC - 1) {
			for (int i = fin + 1; i > inicio; i--) {
				arr[i] = arr[i - 1];
			}
			arr[inicio] = 0;
		}
	}

	private static void eliminarSecuencia(int[] is, int inicio, int fin) {
		for (int i = inicio; i <= fin; i++) {
			corrimientoIzquierda(is, inicio);
		}

	}

	private static void corrimientoIzquierda(int[] is, int inicio) {
		for (int i = inicio; i < MAXC - 1; i++) {
			is[i] = is[i + 1];
		}
		is[MAXC - 1] = 0;
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

	public static void imprimirMatriz(int[][] matriz) {
		for (int f = 0; f < MAXF; f++) {
			for (int c = 0; c < MAXC; c++) {
				System.out.print(" |" + matriz[f][c]);
			}
			System.out.println();
		}
	}
}
