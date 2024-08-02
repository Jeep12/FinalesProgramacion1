package Finales;

/*
 Dado un arreglo ARR de tamaño N de secuencias de enteros separadas por uno o más ceros, hacer un programa que
extraiga todas las secuencias con cantidad par de elementos y las copie en un arreglo PAR de enteros de tamaño N
(quedando separadas por un 0).

 */
public class Final19_2_2020 {
	public static final int MAXF = 4;
	public static final int MAXC = 18;
	public static final int N = MAXF * MAXC;

	public static void main(String[] args) {
		int[][] matriz = {

				{ 0, 7, 6, 0, 5, 6, 0, 6, 4, 0, 8, 6, 0, 0, 9, 8, 7, 0 },
				{ 0, 4, 4, 9, 0, 8, 0, 6, 5, 0, 7, 6, 0, 0, 5, 4, 3, 0 },
				{ 0, 6, 0, 5, 5, 0, 7, 0, 8, 8, 0, 4, 4, 0, 9, 9, 0, 0 },
				{ 0, 0, 7, 8, 0, 0, 9, 0, 5, 6, 0, 4, 4, 0, 6, 6, 0, 0 } };
		int[] par = new int[N];
		int index = 0;
		for (int f = 0; f < MAXF; f++) {
			int inicio = 0;
			int fin = 0;
			int pos = 0;
			while (inicio < MAXC) {
				inicio = inicioSecuencia(matriz[f], pos);
				if (inicio < MAXC) {
					fin = finSecuencia(matriz[f], inicio);
					int longitudActual = fin - inicio + 1;
					if (esPar(longitudActual)) {
						index = llenarArreglo(matriz[f], inicio, fin, par, index);

					}
				}
				pos = fin + 1;
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.print("|" + par[i]);
		}

	}

	private static int llenarArreglo(int[] fila, int inicio, int fin, int[] par, int index) {
		for(int i=inicio;i<=fin;i++) {
			par[index]=fila[i];
			index++;
		}
		index++;
		
		return index;
	}

	public static boolean esPar(int num) {
		return num % 2 == 0;
	}

	public static int inicioSecuencia(int arr[], int inicio) {
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
			return MAXC - 1;
		}

	}
}
