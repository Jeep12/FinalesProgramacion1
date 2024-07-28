package Finales;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 Final regular programación 1 - TUDAI 17/7/2019
Se tiene una matriz MAT de enteros de tamaño NFILxNCOL, donde en cada fila se tiene secuencias de números
distintos de cero separadas por uno o más ceros.
 Realizar un programa completo bien modularizado que permita:
_cargar una variable entera CANT y la matriz MAT con valores válidos, considerando que CANT solo puede tener
valores positivos y que en MAT las secuencias pueden tener valores que van desde 4 a 9 inclusive.
_invertir el orden de las últimas CANT secuencias de la matriz.
Observaciones: Suponer que durante la carga de MAT el usuario va a ingresar uno o más ceros al inicio y al final de
cada fila.
 * */
public class Final17_7_2019 {
	public static final int MAXF = 4;
	public static final int MAXC = 18;

	public static void main(String[] args) {
		int[][] matriz = {

				{ 0, 7, 6, 0, 5, 6, 0, 6, 4, 0, 8, 6, 0, 0, 9, 8, 7, 0 },
				{ 0, 4, 4, 9, 0, 8, 0, 6, 5, 0, 7, 6, 0, 0, 5, 4, 3, 0 },
				{ 0, 6, 0, 5, 5, 0, 7, 0, 8, 8, 0, 4, 4, 0, 9, 9, 0, 0 },
				{ 0, 0, 7, 8, 0, 0, 9, 0, 5, 6, 0, 4, 4, 0, 6, 6, 0, 0 }

		};
		int cant = ingresoEntero("Ingrese un numero entero positivo");

		for (int f = 0; f < MAXF; f++) {
			System.out.println("Fila Nro " + (f + 1));
			int inicio = 0;
			int fin = 0;
			int pos = 0;
			int contadorSec = 0;
			while (inicio < MAXC) {
				inicio = inicioSecuencia(matriz[f], pos);
				contadorSec++;
				if (inicio < MAXC) {
					fin = finSecuencia(matriz[f], inicio);
					System.out.println("Inicio " + inicio + " Fin " + fin + " Sec nro " + contadorSec);
					if (contadorSec >= cant) {
						invertirSecuencia(matriz[f], inicio, fin);
					}

				}
				pos = fin + 1;
			}
		}
		imprimirMatriz(matriz);

	}

	public static void invertirSecuencia(int[] arr, int inicio, int fin) {
		int longitudSecuencia = fin - inicio + 1;
		for (int i = 0; i < longitudSecuencia/ 2; i++) {
			int temp = arr[inicio + i];
			arr[inicio + i] = arr[fin - i];
			arr[fin - i] = temp;
		}
	}

	public static int ingresoEntero(String text) {
		int numeroIngresado = -1;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		while (numeroIngresado < 0) {
			try {
				System.out.println(text);
				numeroIngresado = Integer.valueOf(entrada.readLine());

			} catch (Exception exc) {
				System.out.println(exc);
			}
		}
		return numeroIngresado;
	}

	public static int inicioSecuencia(int arr[], int inicio) {
		while (inicio < MAXC && arr[inicio] == 0) {
			inicio++;
		}
		return inicio;
	}

	public static int finSecuencia(int arr[], int inicio) {
		while (inicio < MAXC && arr[inicio] != 0) {
			inicio++;
		}

		if (inicio < MAXC) {
			return inicio - 1;
		} else {
			return MAXC - 1;
		}

	}

	public static void imprimirMatriz(int[][] matriz) {
		for (int f = 0; f < MAXF; f++) {
			for (int c = 0; c < MAXC; c++) {
				System.out.print(" |" + matriz[f][c]);
			}
			System.out.println();
		}
	}

}
