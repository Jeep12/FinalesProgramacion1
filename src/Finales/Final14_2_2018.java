package Finales;

public class Final14_2_2018 {
	public static final int MAXC = 15;
	public static final int MAXF = 4;

	public static void main(String[] args) {
		char[][] MAT = { { ' ', 'P', 'U', 'E', 'R', 'T', 'A', ' ', ' ', 'A', 'B', 'R', 'E', ' ', ' ' },
				{ ' ', 'L', 'A', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
				{ ' ', ' ', 'J', 'U', 'A', 'N', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
				{ ' ', ' ', ' ', ' ', 'M', 'A', 'Ñ', 'A', 'N', 'A', ' ', ' ', 'D', 'E', ' ' } };
		char[] AR = new char[MAXC * MAXF];

		// solucion:
		// la idea trata de obtener la cantidad de secuencias que se tienen que
		// insertar, asi podemos iterar esta cantidad.

		// teniendo las iteraciones por cantidad de secuencias, voy llenando el arreglo
		// con la menor de las secuencias de la matriz

		// inserta la menor de las secuencias
		// la borra
		// siguie la siguiente iteracion
		// nueva secuencia menor pq la anterior fue eliminada
		// se inserta
		// la borra
		// ...
		int contadorInsercciones = cantidadSecuencias(MAT);
		int inicio = 0;
		int fin = 0;
		int pos = 0;
		int contadorAR = 0;
		while (contadorInsercciones > 0) {
			char inicialSecuenciaMenor = menorInicial(MAT);
			System.out.println("Inserción " + contadorInsercciones + ": menor inicial = " + inicialSecuenciaMenor);
			for (int f = 0; f < MAXF; f++) {

				while (inicio < MAXC) {
					inicio = inicioSecuencia(MAT[f], pos);
					if (inicio < MAXC) {
						fin = finSecuencia(MAT[f], inicio);
						if (MAT[f][inicio] == inicialSecuenciaMenor) {
							System.out.println("Eliminando secuencia con la inicial: " + MAT[f][inicio]);

							// la ultima po,
							copiarSecuencia(AR, MAT[f], inicio, fin, contadorAR);
							contadorAR += (fin - inicio + 2);
							eliminarSecuencia(MAT[f], inicio, fin);
							contadorInsercciones--; // Disminuir el contador de secuencias
						}
						pos = fin + 1;
					}
				}
				inicio = 0;
				fin = 0;
				pos = 0;
			}
		}
		for (char c : AR) {
			System.out.print(c);

		}
	}

	public static void copiarSecuencia(char[] AR, char[] fuente, int inicio, int fin, int posInsercion) {
		for (int i = inicio; i <= fin; i++) {
			AR[posInsercion++] = fuente[i];
		}
	}

	public static void eliminarSecuencia(char[] arr, int inicio, int fin) {
		for (int i = inicio; i <= fin; i++) {
			corrimientoIzquierda(arr, inicio, fin);
		}
	}

	public static void corrimientoIzquierda(char[] arr, int pos, int fin) {
		for (int i = pos; i < MAXC - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[fin] = ' ';
		arr[MAXC-1] = ' ';
	}

	public static char menorInicial(char[][] matriz) {
		int inicio = 0;
		int pos = 0;
		int fin = 0;
		char menor = 'Z' + 1; // Mayor que cualquier letra del alfabeto
		for (int f = 0; f < MAXF; f++) {
			while (inicio < MAXC) {
				inicio = inicioSecuencia(matriz[f], pos);
				if (inicio < MAXC) {
					fin = finSecuencia(matriz[f], inicio);
					if (matriz[f][inicio] < menor) {
						menor = matriz[f][inicio];
					}
					pos = fin + 1;
				}
			}
			inicio = 0;
			pos = 0;
		}
		return menor;
	}

	public static int cantidadSecuencias(char[][] matriz) {
		int inicio = 0;
		int fin = 0;
		int pos = 0;
		int contador = 0;
		for (int f = 0; f < MAXF; f++) {
			while (inicio < MAXC) {
				inicio = inicioSecuencia(matriz[f], pos);
				if (inicio < MAXC) {
					fin = finSecuencia(matriz[f], inicio);
					contador++;
					pos = fin + 1;
				}
			}
			inicio = 0;
			fin = 0;
			pos = 0;
		}
		return contador;
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
