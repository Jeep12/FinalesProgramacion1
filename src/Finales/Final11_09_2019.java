package Finales;

/*
Dada una matriz MAT de caracteres de MxN compuesta de secuencias de caracteres separadas por espacios, hacer  un programa completo para mantener las primeras CAN
T secuencias de la matriz y extraer las restantes pasándolas  
a un arreglo AR de tamaño R=MxN. La matriz debe quedar solo con las primeras CANT secuencias. Observaciones generales: 
_No utilizar estructuras auxiliares. 
_Suponer que la matriz se encuentra cargada y que cada fila comienza y termina con caracteres espacio.  _Realizar el programa completo bien modularizado. 

*/
public class Final11_09_2019 {
	public static final int MAXC = 10;
	public static final int MAXF = 5;

	public static void main(String[] args) {
		char[][] matriz = {

				{ ' ', 'A', ' ', 'B', 'C', 'D', ' ', 'E', 'F', 'G' },
				{ ' ', 'N', 'O', ' ', 'P', 'Q', ' ', 'R', ' ', 'S' },
				{ ' ', 'Z', 'A', 'B', ' ', 'C', ' ', 'D', 'E', 'F' },
				{ ' ', 'M', ' ', 'N', 'O', 'P', 'Q', ' ', 'R', 'S' },
				{ ' ', 'Y', ' ', 'Z', 'A', ' ', 'B', 'C', 'D', 'E' },

		};

		char[] arr = new char[MAXC * MAXF];
		int contador = 0;
		int cant = 1;
		int index = 0;
		for (int f = 0; f < MAXF; f++) {
			System.out.println("Fila nro " + (f + 1));
			int inicio = 0;
			int fin = 0;
			int pos = 0;

			while (inicio < MAXC) {
				inicio = inicioSecuencia(matriz[f], pos);
				if (inicio < MAXC) {
					fin = finSecuencia(matriz[f], inicio);
					contador++;
					if (contador > cant) {
						
						index = agregarEnArr(matriz[f], inicio, fin, index, arr);
						eliminarSec(matriz[f], inicio, fin);

					}
				}
				pos = fin + 1;
			}
		}

		imprimirMatriz(matriz);
		System.out.println();
		imprimirArr(arr);
	}

	private static void imprimirArr(char[] arr) {
		int tamanio = MAXC * MAXF;
		for (int i = 0; i < tamanio; i++) {
			System.out.print("|" + arr[i]);
		}
	}

	private static void imprimirMatriz(char[][] matriz) {
		for (int f = 0; f < MAXF; f++) {
			for (int c = 0; c < MAXC; c++) {
				System.out.print(" |" + matriz[f][c] + "| ");
			}
			System.out.println();
		}

	}

	private static void eliminarSec(char[] arr, int inicio, int fin) {
		int longitud = fin - inicio + 1;
		for (int i = inicio; i <= fin; i++) {
			corrimientoIzquierda(arr, inicio, fin);

		}
	}

	private static void corrimientoIzquierda(char[] arr, int inicio, int fin) {
		for (int i = inicio; i < MAXC - 1; i++) {
			arr[i] = arr[i + 1];
		}

		arr[fin] = ' ';
		arr[MAXC-1]= ' ';
	}

	private static void corrimientoIzquierda2(char[] arr, int inicio, int fin) {
		for (int i = inicio; i < MAXC - 1; i++) {
			arr[i] = arr[i + 1];
		}

		arr[MAXC - 1] = ' ';
	}

	public static int agregarEnArr(char[] matriz, int inicio, int fin, int index, char[] arr) {
		for (int i = inicio; i <= fin; i++) {
			arr[index] = matriz[i];
			index++;
		}
		index = index + 1;
		arr[index]=' ';
		return index;
	}

	public static final int inicioSecuencia(char[] arr, int inicio) {
		while (inicio < MAXC && arr[inicio] == ' ') {
			inicio++;
		}
		return inicio;
	}

	public static int finSecuencia(char[] arr, int inicio) {
		while (inicio < MAXC && arr[inicio] != ' ') {
			inicio++;
		}
		if (inicio < MAXC) {
			return inicio - 1;
		} else {
			return MAXC - 1;
		}
	}

	public static int cantidadSecuencias(char[][] matriz) {
		int contador = 0;
		for (int f = 0; f < MAXF; f++) {
			int inicio = 0;
			int fin = 0;
			int pos = 0;
			while (inicio < MAXC) {
				inicio = inicioSecuencia(matriz[f], pos);
				if (inicio < MAXC) {
					fin = finSecuencia(matriz[f], inicio);
					contador++;
				}
				pos = fin + 1;
			}
		}
		return contador;
	}

}
