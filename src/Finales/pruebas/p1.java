package Finales.pruebas;

public class p1 {
	public static final int MAX = 9;

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		invertir(arr);
		printArray(arr);
	}
	

	public static void invertir(int arr[]) {
		for (int i = 0; i < arr.length / 2; i++) {
			// Intercambiar los elementos en la posición i y arr.length - 1 - i
			int temp = arr[i];
			arr[i] = arr[MAX - 1 - i];
			arr[MAX - 1 - i] = temp;
		}
	}

	public static void printArray(int arr[]) {
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
