package Finales;

/*
 Dada una matriz de caracteres de MxN compuesta de secuencias de caracteres separadas por espacios, hacer un
programa completo para eliminar todas las secuencias que incluyan todas las vocales minúsculas (puede tener
repeticiones). 
 * */
/*
 				{ ' ', 'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd', ' ', 'a', 'e', 'i', 'o', 'u', ' ', ' ',' ' },
				{ ' ', 'p', 'r', 'o', 'g', 'r', 'a', 'm', 'm', 'i', 'n', 'g', ' ', 'i', 's', ' ', 'f', 'u', 'n', ' ',' ' },
				{ ' ', 'q', 'u', 'i', 'c', 'k', ' ', 'b', 'r', 'o', 'w', 'n', ' ', 'f', 'o', 'x', ' ', ' ', ' ', ' ',' ' },
				{ ' ', 'j', 'u', 'm', 'p', 's', ' ', 'o', 'v', 'e', 'r', ' ', 't', 'h', 'e', ' ', 'l', 'a', 'z', 'y',' ' },
				{ ' ', 'd', 'o', 'g', ' ', 'a', 'i', 'e', 'o', 'u', ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', ' ', ' ',' ' }};*/
public class Final4_12_2019 {
	public static final int MAXF = 5;
	public static final int MAXC = 21;

	public static void main(String[] args) {

		char[][] matriz = {


 				{ ' ', 'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd', ' ', 'a', 'e', 'i', 'o', 'u', ' ', ' ',' ' },
				{ ' ', 'p', 'r', 'o', 'g', 'r', 'a', 'm', 'm', 'i', 'n', 'g', ' ', 'i', 's', ' ', 'f', 'u', 'n', ' ',' ' },
				{ ' ', 'q', 'u', 'i', 'c', 'k', ' ', 'b', 'r', 'o', 'w', 'n', ' ', 'f', 'o', 'x', ' ', ' ', ' ', ' ',' ' },
				{ ' ', 'j', 'u', 'm', 'p', 's', ' ', 'o', 'v', 'e', 'r', ' ', 't', 'h', 'e', ' ', 'l', 'a', 'z', 'y',' ' },
				{ ' ', 'd', 'o', 'g', ' ', 'a', 'i', 'e', 'o', 'u', ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', ' ', ' ',' ' }};

		for (int f = 0; f < MAXF; f++) {
			int inicio = 0;
			int fin = 0;
			int pos = 0;
			while (inicio < MAXC) {
				inicio = inicioSecuencia(matriz[f], pos);
				if (inicio < MAXC) {
					fin = finSecuencia(matriz[f], inicio);
					boolean tieneTodasVocales = tieneVocales(matriz[f], inicio, fin);
					if (tieneTodasVocales) {
						eliminarSecuencia(matriz[f], inicio, fin);
					}
				}
				pos = fin + 1;
			}
		}
		
		
		for(int i=0;i<MAXF;i++) {
			for(int c=0;c<MAXC;c++) {
				System.out.print("| " + matriz[i][c]);
			}
			System.out.println();
		}
	}

	private static void eliminarSecuencia(char[] arr, int inicio, int fin) {
		for (int i = inicio; i <= fin; i++) {
			corrimientoIzquierda(arr, inicio);
		}

	}

	private static void corrimientoIzquierda(char[] arr, int inicio) {
		for (int i = inicio; i < MAXC-1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[MAXC - 1] = ' ';

	}

	private static boolean tieneVocales(char[] arr, int inicio, int fin) {
		boolean a = false, e = false, i = false, o = false, u = false;
		for (int t = inicio; t <= fin; t++) {
			if (arr[t] == 'a') {
				a = true;
			}
			if (arr[t] == 'e') {
				e = true;
			}
			if (arr[t] == 'i') {
				i = true;
			}
			if (arr[t] == 'o') {
				o = true;
			}
			if (arr[t] == 'u') {
				u = true;
			}
		}
		return a && e && i && o && u;
	}

	public static boolean esVocal(char letra) {
		return letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u';
	}

	public static int inicioSecuencia(char[] arr, int inicio) {
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
			return MAXC - 1; // Return the last index
		}
	}
}
