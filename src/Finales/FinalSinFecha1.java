package Finales;

/*
 
1. La máquina Enigma fue un dispositivo de cifrado electromecánico utilizado por las fuerzas armadas alemanas antes y durante la Segunda Guerra Mundial.
 La Enigma se utilizaba para cifrar y descifrar mensajes secretos de comunicación militar. En una digitalización de la máquina se pretende simular este comportamiento para cifrar mensajes.
  Dada una matriz de NxM de caracteres letras mayúsculas con secuencias separadas por uno o más espacios que posee los mensajes originales y un arreglo de caracteres mayúsculas con todas
   las letras (de la A a la Z), se pide encriptar los mensajes con el carácter inverso según el orden alfabético en que aparece en el arreglo. Por ejemplo: el carácter A se reemplaza por el Z
   , el B por el Y y así sucesivamente. 

Un ejemplo de matriz con un mensaje podría ser:

 */
public class FinalSinFecha1 {
	public static final int MAXC = 20;
	public static final int MAXF = 3;
	public static final int tamanioAbcedario = 27;
	public static final String abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

	public static void main(String[] args) {
		System.out.println(abecedario.charAt(13));
		char[][] matriz = {

				{ ' ', 'E', 'L', ' ', 'A', 'U', 'T', 'O', ' ', 'C', 'H', 'I', 'C', 'O', ' ', 'D', 'E', ' ', ' ', ' ' },
				{ ' ', ' ', 'L', 'A', ' ', 'B', 'R', 'I', 'G', 'A', 'D', 'A', ' ', ' ', ' ', 'V', 'A', ' ', 'A', ' ' },
				{ ' ', 'L', 'A', ' ', ' ', 'U', 'N', 'A', ' ', 'A', 'L', ' ', 'C', 'U', 'A', 'R', 'T', 'E', 'L',
						' ' } };

		int contadorSecuencias = 0;
		int maxPalabra = 0;
		;
		for (int i = 0; i < MAXF; i++) {
			int inicio = 0;
			int fin = 0;
			int pos = 0;
			while (inicio < MAXC) {
				inicio = inicioSecuencia(matriz[i], pos);
				if (inicio < MAXC) {
					fin = finSecuencia(matriz[i], inicio);
					encriptarPalabra(matriz[i], inicio, fin);
					int longitudActual = fin - inicio + 1;
					if (longitudActual > maxPalabra) {
						maxPalabra = longitudActual;
					}
					contadorSecuencias++;
				}
				pos=fin+1;
			}
		}

		for (int f = 0; f < MAXF; f++) {
			for (int c = 0; c < MAXC; c++) {
				System.out.print(matriz[f][c] + " ");
			}
			System.out.println();
		}
		System.out.println("Se encriptaron un total de " + contadorSecuencias + " Secuencias y el tamaño de la mas grande fue " + maxPalabra );

	}

	private static void encriptarPalabra(char[] arr, int inicio, int fin) {
		for (int i = inicio; i <= fin; i++) {
			char contraParte = contraParte(arr[i]);
			arr[i] = contraParte;
		}
	}

	public static char contraParte(char letra) {
		int posLetra = posicionLetra(letra);
		char contraParte = ' ';
		contraParte = abecedario.charAt(tamanioAbcedario - posLetra - 1);

		return contraParte;
	}

	public static int posicionLetra(char letra) {
		int pos = 0;

		for (int i = 0; i < tamanioAbcedario; i++) {
			if (letra == abecedario.charAt(i)) {
				pos = i;
			}
		}
		return pos;
	}

	public static int inicioSecuencia(char arr[], int inicio) {
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
			return MAXC - 1;
		}

	}

}
