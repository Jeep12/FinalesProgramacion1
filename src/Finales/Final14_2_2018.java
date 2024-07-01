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
			corrimientoIzquierda(arr, inicio);
		}
	}

	public static void corrimientoIzquierda(char[] arr, int pos) {
		while (pos < MAXC - 1) {
			arr[pos] = arr[pos + 1];
			pos++;
		}
		arr[MAXC - 1] = ' '; // Llenar el último espacio con un espacio
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
