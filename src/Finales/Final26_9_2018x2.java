package Finales;

public class Final26_9_2018x2 {
	public static final int MAXF = 4;
	public static final int MAXC = 10;
	public static final int MAXA = 7;

	public static void main(String[] args) {
		int[][] matriz = {

				{ 0, 7, 3, 4, 0, 3, 4, 5, 2, 0 },

				{ 0, 3, 2, 4, 2, 0, 1, 0, 0, 0 },

				{ 0, 0, 1, 7, 2, 0, 4, 4, 8, 0 },

				{ 0, 0, 3, 7, 0, 7, 3, 4, 0, 0 } };

		int[] modelo = { 7, 3, 4, 0, 0, 0, 0 };
		int[] remplazo = { 9, 8, 7, 2, 0, 0, 0 };
		int finAnterior;
		for (int f = 0; f < MAXF; f++) {
			System.out.println("Fila Nro" + (f + 1));
			int inicio = 0;
			int fin = 0;
			int pos = 0;
			while (inicio < MAXC) {
				inicio = inicioSecuencia(matriz[f], pos);
				if (inicio < MAXC) {
					fin = finSecuencia(matriz[f], inicio);
					finAnterior = fin;
					System.out.print("Inicio " + inicio + " Fin " + fin + " fin anterior " + finAnterior);
					boolean sonIguales = compararSecuencia(matriz[f], inicio, fin, modelo);
					if (sonIguales) {
						boolean hayEspacio = hayEspacio(matriz[f], inicio, fin, remplazo);
						if (hayEspacio) {
							System.out.println("hay espacio");
							remplazarSec(matriz[f], inicio, fin, remplazo);
						} else {
							System.out.println("no hay espacio");
							corrimiento(matriz[f], inicio, fin, remplazo);
							remplazarSec(matriz[f], inicio, fin, remplazo);

						}
					}
				}
				System.out.println();
				pos = fin + 1;
			}
		}

		for (int i = 0; i < MAXF; i++) {
			for (int c = 0; c < MAXC; c++) {
				System.out.print("| " + matriz[i][c]);
			}
			System.out.println();
		}
	}

	private static void corrimiento(int[] arr, int inicio, int fin, int[] remplazo) {
		int longitudRemplazo = longitudPatron(remplazo);
		int longitudActual = fin - inicio + 1;
		int desplazamiento = longitudActual - longitudRemplazo;
	    if (desplazamiento > 0) {
            for (int i = MAXC - 1; i >= inicio + desplazamiento; i--) {
                arr[i] = arr[i - desplazamiento];
            }
        }
	}

	private static boolean hayEspacio(int[] is, int inicio, int fin, int[] remplazo) {
		int longitudRemplazo = longitudPatron(remplazo);
		int longitudActual = fin - inicio + 1;
		return longitudActual - longitudRemplazo >= 0;
	}

	public static void remplazarSec(int[] arr, int inicio, int fin, int[] remplazo) {
		int posRemplazo = 0;
		while (remplazo[posRemplazo] != 0) {
			posRemplazo++;
		}
		for (int i = 0; i < posRemplazo; i++) {
			arr[inicio + i] = remplazo[i];
		}
	}

	private static boolean compararSecuencia(int[] arr, int inicio, int fin, int[] modelo) {
		int posModel = 0;
		while (modelo[posModel] != 0) {
			posModel++;
		}
		int longitudSec = longitudSec(inicio, fin);
		if (longitudSec != posModel) {
			return false;
		}

		for (int i = 0; i < posModel; i++) {
			if (arr[inicio + i] != modelo[i]) {
				return false;
			}
		}

		return true;
	}

	public static int longitudSec(int inicio, int fin) {
		return fin - inicio + 1;
	}

	public static int inicioSecuencia(int[] arr, int inicio) {
		while (inicio < MAXC && arr[inicio] == 0) {
			inicio++;
		}
		return inicio;
	}

	public static boolean hayEspacioSuficiente(int[] arr, int inicio, int fin, int[] remplazo) {
		int posRemplazo = longitudPatron(remplazo);

		return (fin - inicio + 1) >= posRemplazo;
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

	public static int longitudPatron(int[] arr) {
		int contador = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				contador++;
			}
		}
		return contador;
	}

}
