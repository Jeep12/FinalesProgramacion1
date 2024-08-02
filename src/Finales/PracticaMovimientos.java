package Finales;

public class PracticaMovimientos {
	public static final int MAXC = 8;
	public static final int MAXF = 3;

	public static void main(String[] args) {
		int[][] matriz = {

				{ 3, 5, 2, 8, 1, 4, 7, 6 }, { 10, 21, 32, 43, 54, 65, 76, 87 }, { 9, 14, 17, 22, 29, 34, 41, 48 }

		};
		System.out.println(cantidadPares(matriz[0]));
		for (int i = 0; i < MAXF; i++) {
			ordenarMatriz(matriz[i]);
		}
		System.out.println();
		for (int i = 0; i < MAXF; i++) {
			for (int j = 0; j < MAXC; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}

//	if (arreglo[i] % 2 == 0) {
//		int temp = arreglo[index];
//		arreglo[index] = arreglo[i];
//		arreglo[i] = temp;
//		index++;
//	}
	public static int cantidadPares(int[] arr) {

		int contador = 0;

		for (int i = 0; i < MAXC; i++) {
			if (arr[i] % 2 == 0) {
				contador++;
			}
		}
		return contador;
	}

	public static void ordenarMatriz(int[] arr) {
		int indexPar = 0;
		int indexImpar = cantidadPares(arr);
		for (int i = 0; i < MAXC; i++) {
			if (arr[i] % 2 == 0) {
				arr[indexPar]=arr[i];
	
				indexPar++;
			}else {
			//	System.out.print("valor actual "+ arr[i]+ " valor arr impares: " + arr[indexImpar] + " valor pos " + indexImpar + " |");
				arr[indexImpar]=arr[i];
				indexImpar++;
				
			
			
			}
		}
		
			
		
		

	}
}
