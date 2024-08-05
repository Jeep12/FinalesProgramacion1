package Finales;

public class FinalFebrero {
    public static final int MAXF = 3;
    public static final int MAXC = 20;
    public static final int MAXP = 15;

    public static void main(String[] args) {
        char[][] matriz = {
            { 'T', 'A', 'T', 'C', 'G', 'C', 'C', 'G', 'A', 'A', 'T', 'C', 'G', 'C', 'A', 'T', 'A', 'A', 'C', 'G' },
            { 'A', 'T', 'C', 'C', 'A', 'G', 'G', 'A', 'C', 'C', 'T', 'A', 'T', 'C', 'C', 'G', 'A', 'C', 'C', 'G' },
            { 'T', 'G', 'G', 'A', 'T', 'C', 'A', 'G', 'G', 'A', 'A', 'A', 'C', 'T', 'C', 'G', 'T', 'A', 'A', 'C' }
        };

        char[] patron = { ' ', 'C', 'C', ' ', 'C', 'T', ' ', 'A', 'A', 'C', ' ', 'T', 'A', 'C', ' ' };

        System.out.println(patron.length);
        int inicio = 0;
        int fin = 0;
        int pos = 0;

        while (inicio < MAXP) {
            inicio = inicioSecuencia(patron, pos);
            if (inicio < MAXP) {
                fin = finSecuencia(patron, inicio);
                int longitud = fin - inicio + 1;
                existeSecuencia(matriz, patron, inicio, fin, longitud);
            }
            pos = fin + 1;
        }
        
        for (int f = 0; f < MAXF; f++) {
            for (int c = 0; c < MAXC; c++) {
                System.out.print("|" + matriz[f][c]);
            }
            System.out.println();
        }
    }

    private static void existeSecuencia(char[][] matriz, char[] patron, int inicio, int fin, int longitud) {
        if (longitud == 2) {
            for (int f = 0; f < MAXF; f++) {
                for (int c = 0; c < MAXC - longitud; c++) {
                    if (esIgualPar(matriz[f][c], matriz[f][c + 1], patron, inicio, fin)) {
                        matriz[f][c] = 'C';
                        matriz[f][c + 1] = 'T';
                        return; // Para reemplazar solo la primera aparición
                    }
                }
            }
        } else if (longitud == 3) {
            for (int f = 0; f < MAXF; f++) {
                for (int c = 0; c < MAXC - longitud; c++) {
                    if (esIgualTriple(matriz[f][c], matriz[f][c + 1], matriz[f][c + 2], patron, inicio, fin)) {
                        matriz[f][c] = 'T';
                        matriz[f][c + 1] = 'A';
                        matriz[f][c + 2] = 'C';
                        return; // Para reemplazar solo la primera aparición
                    }
                }
            }
        }
    }

    public static boolean esIgualPar(char matriz, char matriz2, char[] patron, int inicio, int fin) {
    	int longitud = fin-inicio;
    	System.out.println(longitud);
        for (int i = inicio; i <= fin -  longitud; i++) {
            if (patron[i] == matriz && patron[i + 1] == matriz2) {
                return true;
            }
        }
        return false;
    }

    public static boolean esIgualTriple(char matriz1, char matriz2, char matriz3, char[] patron, int inicio, int fin) {
    	int longitud = fin-inicio;

        for (int i = inicio; i <= fin - longitud; i++) {
            if (patron[i] == matriz1 && patron[i + 1] == matriz2 && patron[i + 2] == matriz3) {
                return true;
            }
        }
        return false;
    }

    public static int inicioSecuencia(char[] arr, int inicio) {
        while (inicio < MAXP && arr[inicio] == ' ') {
            inicio++;
        }
        return inicio;
    }

    public static int finSecuencia(char[] arr, int inicio) {
        while (inicio < MAXP && arr[inicio] != ' ') {
            inicio++;
        }
        if (inicio < MAXP) {
            return inicio - 1;
        } else {
            return MAXP - 1;
        }
    }
}
