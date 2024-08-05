package Finales;

//Eliminar secuencias que tienen mas elementos impares que pares
//
public class Inventado2 {
	public static final int MAXF = 4;
	public static final int MAXC = 18;

	public static void main(String[] args) {
		int[][] matriz = {

				{ 0, 7, 6, 0, 5, 6, 0, 6, 4, 0, 8, 6, 0, 0, 9, 8, 7, 0 },
				{ 0, 4, 4, 9, 0, 8, 0, 6, 5, 0, 7, 6, 0, 0, 5, 4, 3, 0 },
				{ 0, 6, 0, 5, 5, 0, 7, 0, 8, 8, 0, 4, 4, 0, 9, 9, 0, 0 },
				{ 0, 0, 7, 8, 7, 0, 9, 0, 5, 6, 0, 4, 4, 0, 6, 6, 0, 0 } };

		int cantImpares = 0;
		int cantPares = 0;
		for (int f = 0; f < MAXF; f++) {
			int inicio = 0;
			int fin = 0;
			int pos = 0;

			while (inicio < MAXC) {
				inicio = inicioSecuencia(matriz[f], pos);
				if (inicio < MAXC) {
					fin = finSecuencia(matriz[f], inicio);
					int longitud = fin - inicio + 1;
					cantPares = cantPares(matriz[f], inicio, fin);
					cantImpares = longitud - cantPares;
					if (cantImpares > cantPares) {
						eliminarSecuencia(matriz[f], inicio, fin);
					}
				}
				pos = fin + 1;
			}

		}

		imprimirMatriz(matriz);

	}

	private static void eliminarSecuencia(int[] is, int inicio, int fin) {
		for (int i = inicio; i <= fin; i++) {
			corrimientoIzquierda(is, inicio);
		}
	}

	public static int cantPares(int[] arr, int inicio, int fin) {
		int contador = 0;
		for (int i = inicio; i <= fin; i++) {
			if (esPar(arr[i])) {
				contador++;
			}
		}
		return contador;
	}

	private static void corrimientoIzquierda(int[] is, int inicio) {
		for (int i = inicio; i < MAXC - 1; i++) {
			is[i] = is[i + 1];
		}
		is[MAXC - 1] = 0;
	}

	public static boolean esPar(int numero) {
		return numero % 2 == 0;
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
