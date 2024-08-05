package Finales.pruebas;

public class p1 {
	public static final int MAX1 = 9;
	public static final int MAX2 = 12;

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] arr2 = { 4, 2, 6, 3, 192, 49, 2, 2, 9, 7, 5, 0 };

		// invertir(arr);
		burbujeo(arr2);
		printArray(arr2);
	}

	public static void burbujeo(int vec[]) {
		for (int i = 0; i < MAX2 - 1; i++) {
			for (int j = 0; j < (MAX2 - 1 - i); j++) {
				if (vec[j] > vec[j + 1]) {
					int aux = vec[j];
					vec[j] = vec[j + 1];
					vec[j + 1] = aux;
				}
			}
		}
	}

	public static void invertir(int arr[]) {
		for (int i = 0; i < arr.length / 2; i++) {
			// Intercambiar los elementos en la posición i y arr.length - 1 - i
			int temp = arr[i];
			arr[i] = arr[MAX1 - 1 - i];
			arr[MAX1 - 1 - i] = temp;
		}
	}

	public static void printArray(int arr[]) {
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
