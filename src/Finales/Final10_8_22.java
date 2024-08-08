package Finales;

public class Final10_8_22 {
	public static final int MAXC = 10; // Número de columnas
	public static final int MAXF = 10; // Número de filas

	public static void main(String[] args) {

		char[][] matriz = {

				{ 'a', '7', 'e', '2', 'c', '4', '5', '6', 'e', '8' },
				{ '1', 'a', '2', 'b', '3', 'c', '4', 'd', '5', 'e' },
				{ '9', 'i', '8', 'h', '7', 'g', '6', 'f', '5', 'e' },
				{ '0', 'a', '1', 'b', '2', 'c', '3', 'd', '4', 'e' },
				{ 'a', '0', 'b', '1', 'c', '2', 'd', '3', 'e', '4' },
				{ '5', '6', '7', '8', '9', '0', '1', '2', '3', '4' },
				{ 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j' },
				{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' },
				{ 'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q' },
				{ '9', '8', '7', '6', '5', '4', '3', '2', '1', '0' } };

		boolean cambios = false;
		while (!cambios) {

			for (int f = 0; f < MAXF; f++) {
				int cantidadVocalesFila = contadorVocalesFila(matriz[f]);
				int cantidadDigitosFila = cantidadDigitosFila(matriz[f]);
				for (int c = 0; c < MAXC; c++) {
					int cantidadVocalesColumna = contadorVocalesColumna(matriz, c);
					int cantidadDigitosColumna = cantidadDigitosColumna(matriz, c);

					if (cantidadVocalesColumna == cantidadVocalesFila
							&& cantidadDigitosColumna == cantidadDigitosFila) {
						corrimientoFila(matriz[f]);
						corrimientoColumna(matriz, c);
				
						cambios = true;

					}

				}

			}
			imprimir(matriz);

		}
	}

//		System.out.println("Columna 0");
//		System.out.println("digitos " + cantidadDigitosColumna(matriz, 0));
//		System.out.println("vocales " + contadorVocalesColumna(matriz, 0));
//
//		System.out.println("Fila 0 ");
//
//		System.out.println("digitos " + cantidadDigitosFila(matriz[0]));
//		System.out.println("vocales " + contadorVocalesFila(matriz[0]));
	public static void ajustarMatriz(char[][] matriz) {
		// Ajustar la matriz eliminando la última fila y columna
		for (int i = 0; i < MAXF; i++) {
			matriz[i][MAXC - 1] = ' ';
		}
		for (int j = 0; j < MAXC; j++) {
			matriz[MAXF - 1][j] = ' ';
		}
	}

	public static void corrimientoFila(char arr[]) {
		for (int i = 0; i < MAXC - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[MAXC - 1] = ' ';
	}

	public static void corrimientoColumna(char[][] matriz, int c) {
		for (int i = 0; i < MAXF - 1; i++) {
			matriz[i][c] = matriz[i + 1][c];
		}
		matriz[MAXF - 1][c] = ' ';
	}

	public static int contadorVocalesFila(char[] fila) {
		int contador = 0;

		for (int i = 0; i < MAXC; i++) {
			if (esVocal(fila[i])) {
				contador++;
			}
		}
		return contador;
	}

	public static int contadorVocalesColumna(char matriz[][], int columna) {
		int contador = 0;
		for (int i = 0; i < MAXF; i++) {
			if (esVocal(matriz[i][columna])) {
				contador++;
			}
		}

		return contador;
	}

	public static int cantidadDigitosFila(char[] fila) {
		int contador = 0;

		for (int i = 0; i < MAXC; i++) {
			if (esDigito(fila[i])) {
				contador++;
			}
		}
		return contador;
	}

	public static int cantidadDigitosColumna(char matriz[][], int columna) {
		int contador = 0;
		for (int i = 0; i < MAXF; i++) {
			if (esDigito(matriz[i][columna])) {
				contador++;
			}
		}

		return contador;
	}

	public static boolean esVocal(char caracter) {
		return caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u';
	}

	public static boolean esDigito(char caracter) {
		return caracter == '0' || caracter == '1' || caracter == '2' || caracter == '3' || caracter == '4'
				|| caracter == '5' || caracter == '6' || caracter == '7' || caracter == '8' || caracter == '9';
	}

	public static void imprimir(char matriz[][]) {
		for (int f = 0; f < MAXF; f++) {
			for (int c = 0; c < MAXC; c++) {
				System.out.print(" |" + matriz[f][c] + "| ");
			}
			System.out.println();

		}
	}

	
	
	
}
