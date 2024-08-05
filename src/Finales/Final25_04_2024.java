package Finales;

public class Final25_04_2024 {
	public static final int MAXC = 20;
	public static final int MAXF = 10;

	public static void main(String[] args) {
		int[][] matriz = {

				{ 0, 2, 4, -3, 2, 0, 0, 0, -5, 34, 23, 9, 0, 12, 12, 0, 22, 78, 98, 0 },
				{ 0, 34, 0, 5, 0, 0, 0, 45, 7, -8, -9, 0, 0, 0, 0, 56, -8, -7, 0, 0 },
				{ 0, 6, 5, 4, 5, 9, 0, 0, 0, -7, -8, -8, 0, 6, 6, 0, 9, 0, 0, 0 },
				{ 0, 7, 34, 33, 55, -6, -7, 5, 0, 0, 7, 6, 4, 0, 7, 66, 9, 0, 0, 0 },
				{ 0, 4, 89, 0, 0, 0, 7, 6, 4, 3, -8, 99, 99, 67, 8, 0, 0, 0, 0, 0 },
				{ 0, 82, 78, 78, 5, 4, 56, 5, 4, 6, 0, 9, 9, 99, 66, 77, 0, 0, 0, 0 },
				{ 0, 67, 55, 6, 6, 0, 0, 0, 6, 5, 0, 4, 3, -5, 0, 78, 66, 0, 0, 0 },
				{ 0, 44, 4, 0, 0, 8, 6, 6, 4, 8, 8, 78, 77, 88, 88, 0, 0, 0, 0, 0 },
				{ 0, 87, 99, 0, 7, 19, 12, -6, 0, 87, 99, 10, 12, 11, 67, 9, 0, 0, 0, 0 },
				{ 0, 23, 22, 2, 3, 4, 5, 6, -7, -8, -9, 87, 88, 67, 67, 0, 78, 0, 0, 0 } };

		int[] arrP = { 0, 2, -7, -8, -8, 0, 6, 6, 5, 0, 8, 87, 99, 0, 1, 34, 0, 11, 23, 0 };
		int[] solucion = new int[MAXC * MAXF];

		int inicio = 0;
		int fin = 0;
		int pos = 0;
		int index = 0;
		while (inicio < MAXC) {
			inicio = inicioSecuencia(arrP, pos);
			if (inicio < MAXC) {
				fin = finSecuencia(arrP, inicio);
				if (arrP[inicio] < MAXF) {
					int nuevoInicio = inicio + 1;
					System.out.println("Fila " + arrP[inicio]);
					index = buscarYRemplazar(matriz[arrP[inicio]], nuevoInicio, fin, arrP, solucion, index);
				}
			}
			pos = fin + 1;
		}

		for (int i = 0; i < solucion.length; i++) {
			System.out.print("|" + solucion[i]);
		}

	}

	public static int buscarYRemplazar(int[] fila, int nuevoInicio, int fin, int[] arrP, int[] solucion, int index) {
		int inicioF = 0;
		int finF = 0;
		int posF = 0;
		while (inicioF < MAXC) {
			inicioF = inicioSecuencia(fila, posF);
			if (inicioF < MAXC) {
				finF = finSecuencia(fila, inicioF);
				boolean sonIguales = compararSec(fila, inicioF, finF, nuevoInicio, fin, arrP);
				System.out.println("Inicio " + inicioF + " Fin " + finF + " " + sonIguales);
				if (sonIguales) {
					solucion[index]=arrP[nuevoInicio-1];
					solucion[index+1]=inicioF;
					solucion[index+2]=finF;
					index+=3;
				}
			}
			posF = finF + 1;
		}
		return index;

	}

	public static boolean compararSec(int[] fila, int inicioF, int finF, int nuevoInicio, int fin, int[] arrP) {
		int longitud1 = finF - inicioF + 1;
		int longitud2 = fin - nuevoInicio + 1;
		if (longitud1 != longitud2) {
			return false;
		}
		for (int i = 0; i < longitud1; i++) {
			if (fila[inicioF + i] != arrP[nuevoInicio + i]) {
				return false;
			}
		}

		return true;
	}

	public static int inicioSecuencia(int[] arr, int inicio) {
		while (inicio < MAXC && arr[inicio] == 0) {
			inicio++;
		}
		return inicio;
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

}
