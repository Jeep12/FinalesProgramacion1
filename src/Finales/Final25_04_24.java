package Finales;
public class Final25_04_24 {
	public static final int MAXC = 20;
	public static final int MAXF = 10;

	public static void main(String[] args) {
		
		int[][] g = {

				{ 0, 2, 4, -3, 2, 0, 0, 0, -5, 34, 23, 9, 0, 12, 12, 0, 22, 78, 98, 0 },
				{ 0, 34, 0, 5, 0, 0, 0, 45, 7, -8, -9, 0, 0, 0, 0, 56, -8, -7, 0, 0 },
				{ 0, 6, 5, 4, 5, 9, 0, 0, 0, -7, -8, -8, 0, 6, 6, 0, 9, 0, 0, 0 },
				{ 0, 7, 34, 33, 55, -6, -7, 5, 0, 0, 7, 6, 4, 0, 7, 66, 9, 0, 0, 0 },
				{ 0, 4, 89, 0, 0, 0, 7, 6, 4, 3, -8, 99, 99, 67, 8, 0, 0, 0, 0, 0 },
				{ 0, 82, 78, 78, 5, 4, 56, 5, 4, 6, 0, 9, 9, 99, 66, 77, 0, 0, 0, 0 },
				{ 0, 67, 55, 6, 6, 0, 6, 5, 0, 7, 7, 4, 3, -5, 0, 78, 66, 0, 0, 0 },
				{ 0, 44, 4, 0, 0, 8, 6, 6, 4, 8, 8, 78, 77, 88, 88, 0, 0, 0, 0, 0 },
				{ 0, 87, 99, 0, 7, 19, 12, -6, 0, 87, 99, 10, 12, 11, 67, 9, 0, 0, 0, 0 },
				{ 0, 23, 22, 2, 3, 4, 5, 6, -7, -8, -9, 87, 88, 67, 67, 0, 78, 0, 0, 0 } };

		
		int[] arrP = {0, 2, -7, -8, -8, 0, 6, 36, 5, 0, 8, 87, 99, 0, 1, 34, 0, 11, 23, 0};
		int [] arrS = new int [100];
		
		int inicio = 0;
		int fin =0;
		int pos = 0;
		
		while(inicio<MAXC) {
			inicio = inicSecuencia(arrP, pos);
			if(inicio<MAXC) {
				fin = finSecuencia(arrP, inicio);
				if(arrP[inicio]<MAXF) {
					int nuevoInicio = inicio+1;
					System.out.println("FILA " + arrP[inicio] + " inicio " + arrP[nuevoInicio] );
					existe(g[arrP[inicio]], arrP, nuevoInicio, fin, arrS);
				}
			}
			pos = fin +1;
		}
		imprimir(arrS);
		
	}
	
	public static void existe(int[] ArrM, int[] patron, int inicio, int fin, int [] arrR) {
		int inicioM = 0;
		int finM = 0;
		int posM = 0;
		int longitudPatron = fin - inicio + 1;
		int contador =0;
		boolean existe = false;
		while (inicioM < MAXC && !existe) {
			inicioM = inicSecuencia(ArrM,posM);
			if (inicioM < MAXC) {
				 finM = finSecuencia(ArrM,inicioM);
				int longitudActual = finM - inicioM + 1;
				if (longitudPatron == longitudActual) {
					boolean sonIguales = true;
					while (sonIguales && contador<longitudActual) {
						if (!(patron[inicio] == ArrM[inicioM])) {
							sonIguales=false;
						}
						inicio++;
						inicioM++;
						contador++;
					}
					if(sonIguales) {
						existe = true;
						inicio-=contador;
						inicioM-=contador;
					}else {
						inicio-= contador;
						
					}

				}
			}
			posM = finM + 1;
		}
			if(existe) {
//				System.out.println("Existe la secuencia en la fila " + patron[inicio-1]);
//				for(int i =inicioM;i<=finM;i++) {
//					System.out.print(ArrM[i] + " ") ;
//				}
//				System.out.println();
				insertar2(arrR, inicioM, finM, patron[inicio-1]);
			}

	}

    private static void insertar(int[] arrS, int inicioM, int finM, int valor) {
    	int contador = 0;
    	boolean sePuedeInsertar = true;
    	while(sePuedeInsertar) {
    		if(arrS[contador]!=0) {
    			sePuedeInsertar = false;
    		}else {
    			arrS[contador] = valor;
    			arrS[contador+1]=inicioM;
    			arrS[contador+2]=finM;
    			sePuedeInsertar = true;


    			
    		}
    		contador++;
    		
    	}
    }
	  private static void insertar2(int[] arrS, int inicioM, int finM, int valor) {
	        int contador = 0;
	        boolean sePuedeInsertar = true;
	        while(sePuedeInsertar && (contador < 100 - 3)) {
	            if(arrS[contador] != 0 || arrS[contador + 1] != 0 || arrS[contador + 2] != 0) {
	                contador += 4;  
	            } else {
	                arrS[contador] = valor;
	                arrS[contador + 1] = inicioM;
	                arrS[contador + 2] = finM;
	                arrS[contador+3]=0;
	                sePuedeInsertar = false;
	            }
	        }
	    }

	public static int inicSecuencia(int[] arr, int inicio) {
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
			return -1;
		}
	}
	
	public static void imprimir(int [] arr) {
		for(int i =0;i<100;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
