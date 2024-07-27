package Finales;

/*
 Realizar un programa que dada una matriz MAT de caracteres de tamaño MAXFxMAXC con filas compuestas de
secuencias de caracteres distintos del carácter espacio ‘ ’, elimine todas las secuencias que no tienen orden entre sus
caracteres o tienen longitud impar. Para ello además deberá tener en cuenta que cuando elimina una secuencia
debe realizar un corrimiento a izquierda y completar con caracteres espacio al final de la fila.
Observaciones:
_Suponer que MAT está cargada con datos.
_Cada fila de MAT empieza y termina con uno o más caracteres espacio.
_Realizar también el programa principal y la definición de constantes.
_Los métodos deben estar bien modularizados.
 */
public class Final19_12_2018 {
	public static final int MAXF = 5;
	public static final int MAXC = 10;

	public static void main(String[] args) {
		char[][] matriz = {

				{ ' ', 'A', 'B', 'C', 'D', ' ', ' ', 'E', 'D', ' ' },
				{ ' ', 'K', 'J', ' ', 'A', 'A', ' ', 'O', 'P', ' ' },
				{ ' ', 'Q', 'R', ' ', 'A', 'B', 'C', ' ', ' ', ' ' },
				{ ' ', ' ', 'A', 'B', ' ', 'A', 'D', 'A', ' ', ' ' },
				{ ' ', 'H', 'H', ' ', 'E', 'E', ' ', 'B', 'B', ' ' } };

		for (int f = 0; f < MAXF; f++) {
			System.out.println();
			System.out.println("Fila Nro " + (f + 1));
			System.out.println();

			int inicio = 0;
			int fin = 0;
			int pos = 0;
			while (inicio < MAXC) {
				inicio = inicioSecuencia(matriz[f], pos);
				if (inicio < MAXC) {
					fin = finSecuencia(matriz[f], inicio);
					int longitudActual = calcularLongitud(inicio, fin);
					if(esDesordenado(matriz[f],inicio,fin) || esImpar(longitudActual)) {
						eliminarSecuencia(matriz[f],inicio,fin);
					}
				}
				pos = fin + 1;
			}
		}
		
		imprimirMatriz(matriz);
	}
	

    public static void eliminarSecuencia(char[] arr, int inicio, int fin) {
        for (int i = inicio; i <= fin; i++) {
            corrimientoIzquierda(arr, inicio);
        }
    }

    public static void corrimientoIzquierda(char[] arr, int pos) {
        while (pos < MAXC -1) {
            arr[pos] = arr[pos + 1];
            pos++;
        }
        arr[MAXC -1] = ' '; // Llenar el último espacio con un espacio
    }


	public static boolean esImpar(int longitud) {
		return longitud%2!=0;
	}
	public static boolean esDesordenado(char arr [],int inicio,int fin) {
		return !(esIgual(arr, inicio, fin) || esAscendente(arr, inicio, fin) || esDescendente(arr, inicio, fin));
	}
	public static int calcularLongitud(int inicio, int fin) {
		return fin - inicio + 1;
	}

	public static boolean esIgual(char[] arr, int inicio, int fin) {

		// Si el rango es de un solo elemento, es igual por definición.
		if (inicio == fin) {
			return true;
		}
		
		for (int i = inicio; i <= fin - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				return false;
			}
		}

		return true;
	}

	public static boolean esDescendente(char[] arr, int inicio, int fin) {
		for (int i = inicio; i <= fin - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static boolean esAscendente(char[] arr, int inicio, int fin) {
		for (int i = inicio; i <= fin - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static int inicioSecuencia(char arr[], int inicio) {
		while (inicio < MAXC && arr[inicio] == ' ') {
			inicio++;
		}
		return inicio;
	}

	public static int finSecuencia(char arr[], int inicio) {
		while (inicio < MAXC && arr[inicio] != ' ') {
			inicio++;
		}

		if (inicio < MAXC) {
			return inicio - 1;
		} else {
			return MAXC - 1;
		}
	}
	public static void imprimirMatriz(char[][] matriz) {
		for (int f = 0; f < MAXF; f++) {
			for (int c = 0; c < MAXC; c++) {
				System.out.print(" |" + matriz[f][c]);
			}
			System.out.println();
		}
	}
}
