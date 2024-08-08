package Finales;

//agregar la secuencia patron despues de la la variable cant(cantidad secuencias)=
public class Inventado5 {
	public static final int MAXC = 10;
	public static final int MAXF = 5;
	public static final int MAX2 = 12;

	public static void main(String[] args) {
		int[][] matriz = {

				{ 0, 4, 2, 3, 0, 3, 3, 7, 0, 0 }, { 0, 1, 5, 6, 0, 8, 5, 7, 0, 0 }, { 0, 9, 3, 3, 2, 1, 0, 1, 2, 0 },
				{ 0, 4, 4, 0, 5, 6, 0, 7, 7, 0 }, { 0, 0, 2, 8, 3, 0, 1, 2, 3, 0 }

		};
		
		int[] vec = { 4, 2, 6, 3, 192, 49, 2, 2, 9, 7, 5, 0 };
		
		for (int i = 0; i < MAX2 - 1; i++) {
			for (int j = 0; j < (MAX2 - 1 - i); j++) {
				if (vec[j] > vec[j + 1]) {
					int aux = vec[j];
					vec[j] = vec[j + 1];
					vec[j + 1] = aux;
				}
			}
		}
		for(int i =0;i<vec.length;i++) {
			System.out.print("| "+vec[i]+"| ");
		}
		
		System.out.println();

		for (int f = 0; f < MAXF; f++) {
			int inicio = 0;
			int fin = 0;
			int pos = 0;
			while (inicio < MAXC) {
				inicio = inicioSecuencia(matriz[f], pos);

				if (inicio < MAXC) {
					fin = finSecuencia(matriz[f], inicio);
					burbujeo(matriz[f], inicio, fin);
				}
				pos = fin + 1;
			}
		}
		imprimirMatriz(matriz);

	}

	private static void burbujeo(int[] is, int inicio, int fin) {
		for (int i = inicio; i < fin; i++) {
			for (int j = inicio; j < fin - (inicio - i); j++) {
				if (is[i] > is[i + 1]) {
					int temp = is[i];
					is[i] = is[i + 1];
					is[i + 1] = temp;
				}
			}
		}
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

	public static void imprimirMatriz(int[][] matriz) {
		for (int f = 0; f < MAXF; f++) {
			for (int c = 0; c < MAXC; c++) {
			
				System.out.print( " |" + matriz[f][c]+"| ");
			}
			System.out.println();
		}
	}
}
