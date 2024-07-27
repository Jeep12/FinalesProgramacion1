package Finales;

/*
 Final Regular Programación 1 - TUDAI 7/3/2018
1) Se tiene una matriz MatA de NxM y de tipo caracter. En cada fila de MatA hay una o más secuencias de letras
distintas del caracter espacio, separadas por uno o más caracteres espacios al principio, entre secuencias, y al final.

Se pide determinar la secuencia de letras distintas del caracter espacio que aparece la mayor cantidad de veces en
toda la matriz e imprimir por pantalla el resultado.
Observaciones generales para 1):
_Suponer que MatA está cargada.
_Realizar también el programa principal y la definición de constantes.
_Los métodos deben estar bien modularizados.
 */
public class Final7_3_2018 {
	public static final int MAXF = 5;
	public static final int MAXC = 10;

	public static void main(String[] args) {

		char matriz[][] = { { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
				{ ' ', ' ', ' ', ' ', ' ', 's', 't', ' ', ' ', ' ' },
				{ ' ', ' ', ' ', 'k', 'l', ' ', ' ', ' ', ' ', ' ' },
				{ ' ', 'k', 'l', ' ', 's', 't', ' ', ' ', ' ', ' ' },
				{ ' ', 's', 't', ' ', ' ', ' ', ' ', 's', 't', ' ' } };

		int maxRepeticiones = 0;
		String secuenciaMasRepetida = "";
		for (int f = 0; f < MAXF; f++) {
			int inicio = 0;
			int fin = 0;
			while (inicio < MAXC) {
				inicio = inicioSecuencia(matriz[f], fin + 1);
				if (inicio < MAXC) {
					fin = finSecuencia(matriz[f], inicio);

					int repeticiones = contadorSecuencias(matriz, f, inicio, fin);
					if (repeticiones > maxRepeticiones) {
						maxRepeticiones = repeticiones;

					}
				}
			}
		}
		System.out.println(
				"La secuencia más repetida es: " + secuenciaMasRepetida + " con " + maxRepeticiones + " repeticiones.");
	}

	public static int contadorSecuencias(char[][] matriz, int filaOriginal, int inicioOriginal, int finOriginal) {
		int contador = 0;
		for (int f = 0; f < MAXF; f++) {
			int inicio = 0;
			int fin = 0;
			while (inicio < MAXC) {
				inicio = inicioSecuencia(matriz[f], fin + 1);
				if (inicio < MAXC) {
					fin = finSecuencia(matriz[f], inicio);
					if (compararSecuencia(matriz[filaOriginal], inicioOriginal, finOriginal, matriz[f], inicio, fin)) {
						contador++;
					}
				}
			}
		}
		return contador;
	}

	public static boolean compararSecuencia(char[] arr1, int inicio1, int fin1, char[] arr2, int inicio2, int fin2) {
		if (fin1 - inicio1 != fin2 - inicio2) {
			return false;
		}
		for (int i = 0; i <= fin1 - inicio1; i++) {
			if (arr1[inicio1 + i] != arr2[inicio2 + i]) {
				return false;
			}
		}
		return true;
	}

	public static int inicioSecuencia(char[] arr, int inicio) {
		while (inicio < MAXC && arr[inicio] == ' ') {
			inicio++;
		}
		return inicio;
	}

	public static int finSecuencia(char[] arr, int inicio) {
		while (inicio < MAXC && arr[inicio] != ' ') {
			inicio++;
		}
		return inicio - 1;
	}
}
