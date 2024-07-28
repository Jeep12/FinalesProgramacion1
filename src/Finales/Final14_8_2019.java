package Finales;

public class Final14_8_2019 {
	public static final int MAX = 14;
	public static final int MAXN = 4;

	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 0, 2, 2, 0, 0, 5, 1, 0, 0, 0, 0 };
		int[] nuevo = { 0, 3, 2, 0 };
		int inicio = 0;
		int fin = 0;
		int pos = 0;
		int sumaNuevo = sumaNuevo(nuevo);
		while (inicio < MAX) {
			inicio = inicioSecuencia(arr, pos);
			if (inicio < MAX) {
				fin = finSecuencia(arr, inicio);
				int longitudActual = fin - inicio + 1;
				int sumaActual = sumaSec(arr, inicio, fin);
				System.out.println("Inicio " + inicio + " Fin " + fin );
				if(sumaActual>=sumaNuevo) {
					
				}
			}
			pos = fin + 1;
		}
	}

	public static int sumaNuevo(int arr[]) {
		int suma = 0;
		for (int i = 0; i < MAXN; i++) {
			suma += arr[i];
		}
		return suma;
	}

	public static int sumaSec(int[] arr, int inicio, int fin) {
		int suma = 0;
		for (int i = inicio; i <= fin; i++) {
			suma += arr[i];
		}
		return suma;
	}

	public static int inicioSecuencia(int arr[], int inicio) {
		while (inicio < MAX && arr[inicio] == 0) {
			inicio++;
		}
		return inicio;
	}

	public static int finSecuencia(int arr[], int inicio) {
		while (inicio < MAX && arr[inicio] != 0) {
			inicio++;
		}

		if (inicio < MAX) {
			return inicio - 1;
		} else {
			return MAX - 1;
		}
	}
}
