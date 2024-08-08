package Finales;

public class Inventado4 {
	public static final int MAXF = 4;
	public static final int MAXC = 10;
	public static final int MAXP = 7;

	public static void main(String[] args) {
		int[][] matriz = {

				{ 0, 7, 3, 4, 0, 0, 4, 5, 2, 0 },

				{ 0, 3, 2, 4, 2, 0, 1, 0, 0, 0 },

				{ 0, 0, 1, 7, 2, 0, 4, 4, 8, 0 },

				{ 0, 0, 3, 7, 0, 7, 3, 4, 0, 0 } };

		int[] patron = { 0, 7, 3, 4, 0, 0, 0 };

		for (int i = 0; i < MAXF; i++) {
			int inicio = 0;
			int fin = 0;
			int pos = 0;
			System.out.println("Fila Nro " + (i ));
			while (inicio < MAXC) {
				inicio = inicioSecuenciaMatriz(matriz[i], pos);
				if (inicio < MAXC) {
					fin = finSecuenciaMatriz(matriz[i], inicio);
					boolean sonIguales = compararSecuencias(matriz[i], inicio, fin, patron);
					System.out.println("Inicio " + inicio + " Fin " + fin + " Es igual " + sonIguales);
				}
				pos = fin + 1;
			}
		}

		for (int i = 0; i < MAXC; i++) {
			System.out.print("    " + i);
		}
		System.out.println();
		imprimir(matriz);

	}

	private static boolean compararSecuencias(int[] filaMatriz, int inicio, int fin, int[] patron) {
		int inicioP = 0;
		int finP = 0;
		int posP = 0;
		int longitud1 = fin - inicio + 1;

		while (inicioP < MAXP) {
			inicioP = inicioSecuenciaPatron(patron, posP);
			if (inicioP < MAXP) {
				finP = finSecuenciaPatron(patron, inicioP);
				int longitudActual = finP - inicioP + 1;
				if (longitudActual != longitud1) {
					return false;
				}
				for (int i = 0; i < longitud1; i++) {
					if (filaMatriz[inicio + i] != patron[inicioP + i]) {
						return false;
					}
				}
			}
			posP = finP + 1;
		}
		return true;
	}

	public static int inicioSecuenciaMatriz(int[] arr, int inicio) {
		while (inicio < MAXC && arr[inicio] == 0) {
			inicio++;
		}
		return inicio;
	}

	public static int finSecuenciaMatriz(int[] arr, int inicio) {
		while (inicio < MAXC && arr[inicio] != 0) {
			inicio++;
		}
		if (inicio < MAXC) {
			return inicio - 1;
		} else {
			return MAXC - 1;
		}
	}

	public static int inicioSecuenciaPatron(int[] arr, int inicio) {
		while (inicio < MAXP && arr[inicio] == 0) {
			inicio++;
		}
		return inicio;
	}

	public static int finSecuenciaPatron(int[] arr, int inicio) {
		while (inicio < MAXP && arr[inicio] != 0) {
			inicio++;
		}
		if (inicio < MAXP) {
			return inicio - 1;
		} else {
			return MAXP - 1;
		}
	}

	public static void imprimir(int matriz[][]) {
		// Imprimir los índices de las columnas

		// Imprimir la matriz con índices de filas
		for (int f = 0; f < MAXF; f++) {
			System.out.print(f + " ");
			for (int c = 0; c < MAXC; c++) {
				System.out.print(" |" + matriz[f][c] + "| ");
			}
			System.out.println();
		}
	}
}

//if (longitudActual != longitud1) {
//return false;
//}
//for (int i = 0; i < longitud1; i++) {
//if (filaMatriz[inicio + i] != patron[inicioP + i]) {
//	return false;
//}
//}
