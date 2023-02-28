/**
 * 
 */
package Logica;

/**
 * @author GonzalezHDanielaA
 *
 */
public class Sudoku_Backtracking {

	/**
	 * @param args
	 */
	

	//Declaración de variabble definirá el tamaño del tablero
	public static int dimension = 9;
	
	
	public static void main(String[] args) {
		
		//Generamos un tablero inicial de Sudoku
		
		int [][] tablero = {
							{0,7,0,0,0,0,0,8,0},
							{0,5,8,6,0,0,0,0,1},
							{0,0,3,1,4,0,0,0,0},
							
							{9,0,6,0,5,0,3,0,0},
							{0,0,0,0,0,0,0,0,0},
							{0,0,5,0,2,0,1,0,7},
							
							{0,0,0,0,6,5,7,0,0},
							{3,0,0,0,0,1,9,2,0},
							{0,4,0,0,0,0,0,1,0}};
		
		System.out.println("El juego a resolver es: ");
		imprimir(tablero);
		if(!resolver(tablero))
			System.out.println("El sudoku no tiene solución");
		//System.out.println("Presione la tecla Enter para salir");
		

	}

	//Funcion para imprirmir el tablero del sudoku
	public static void imprimir(int [][] tablero)
	{
		for(int i=0; i < dimension; i++)
		{
			if(i%3==0)
			{
				System.out.println(" ");
			}
			for(int j=0; j<dimension;j++)
			{
				if(j%3==0)
				{
					System.out.print(" ");
				}
				System.out.print(tablero[i][j]);
			}
			System.out.println("  ");
		}	
	}
	//Funcion que resuelve el sudoku
	public static boolean resolver(int [][]tablero)
	{
		for(int i=0;i< dimension; i++) {
			
			for(int j=0; j< dimension; j++)
			{
				if(tablero[i][j] != 0)
				{
					continue;
				}
				else {
					//Calcula los elementos de la solucion, para ello revisa si es
					//posible insertar el valor k en las coordenadas correspondientes
					
					for(int k=1; k<=9;k++)
					{
						if(esPosiblleInsertar(tablero,i,j,k))
						{
							tablero[i][j] = k;
							Boolean b = resolver(tablero);
							
							if(b)
								return true;
							tablero[i][j] = 0;	
						}
					}
					/*
					 * Cuando se termina de recorrer el tablero y no se ha retornado 
					 * el valor de verdadero, entoncer el tablero no tiene solución
					 */
					return false;
				}
			}
		}
		
		System.out.println();
		System.out.println("Solución encontrada");
		imprimir(tablero);
		return true;
		
	}

	/**
	 * Funcion para verificar si se añade un valor al tablero, el tablero siga siendo
	 * consistente, es decir, que el valor no se repita  en la fila  o columna
	 * @param tablero
	 * @param i
	 * @param j
	 * @param k
	 * @return
	 */
	private static boolean esPosiblleInsertar(int[][] tablero, int i, int j, int valor) {
		
		//Primeramente, se vericar que  valor no se encuentre en la misma columna
		for(int a=0; a< dimension;a++)
		{
			if(a!= i && tablero[a][j]==valor )
			{
				return false;
			}
		}
		//Luego se verifica que el valor no se encuentre en la misma fila
		for(int a=0; a< dimension; a++)
		{
			if(a != j && tablero[i][a] == valor)
			{
				return false;
			}
		}
		//Se verifica que el valor no se encuentre en la misma cuadricula
		int y = (i/3)*3;
		int x = (j/3) *3;
		
		for(int a=0; a<dimension /3;a++)
		{
			for(int b=0;b<dimension/3;b++)
			{
				if(a!= i && b!= j && tablero[y+a][x+b]==valor)
				{
					return false;
				}	
			}			
		}
		return true;
	}
	
	
	
	
	
	
}
