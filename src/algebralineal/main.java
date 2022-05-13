
package algebralineal;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int varNum;
		
		System.out.println("Bienvenido");
		System.out.print("Escribe la cantidad de variables del SEL: ");
		varNum = leer.nextInt();
		
		//Condicional para evaluar la cantidad de variables del SEL
		if (varNum > 1) {
			procesarSel(varNum, leer);
			
		} else{
			despeje(leer);
		} //Fin del condicional 
    }
	
	static void procesarSel(int varNum, Scanner leer){
		int contCeros = 0;
			double pivote, multiplicador;
			double[][] matriz = new double[varNum][varNum+1];
			
			//Solicitar los datos del SEL
			for (int i = 0; i < varNum; i++) {
				for (int j = 0; j < varNum+1; j++) {
					if ( j < varNum) {
						System.out.print("Escribe el coeficiente de la variable numero "+(j+1)+" de la ecuacion "+(i+1)+": ");
						matriz[i][j] = leer.nextDouble();
					} else{
						System.out.print("Escribe el resultado de la ecuacion "+(i+1)+": ");
						matriz[i][j] = leer.nextDouble();
					}
				}
			}
			
			//Mostrar en pantalla la matriz resultante del SEL
			System.out.println("\nLa matriz del sistema de ecuaciones es");
			for (int i = 0; i < varNum; i++) {
				for (int j = 0; j < varNum+1; j++) {
					System.out.print(matriz[i][j]+" ");
				}
				System.out.println("");
			}
			
			//Transformar en ceros los numeros bajo el pivote
			outerloop:
			for (int i = 0; i < varNum-1; i++) {
				pivote = matriz[i][i];
				System.out.println("\n\nPivote "+(i+1)+": "+pivote);
				
				//Ciclo para controlar los renglones convertidos por un mismo pivote
				for (int j = i+1; j < varNum; j++) {
					contCeros=0;
					multiplicador = -matriz[j][i]/pivote;
					System.out.println("\nEl valor del multiplicador es "+multiplicador+" en el renglon "+(j+1));
					
					//Ciclo para convertir cada uno de los elementos del renglon
					for (int k = 0; k < matriz[j].length; k++) {
						matriz[j][k] = ( matriz[i][k] * multiplicador ) + matriz[j][k];
					}
					
					//Ciclo For para mostrar el renglon convertido
					System.out.print("El nuevo renglon "+(j+1)+" es: ");
					for (int k = 0; k < matriz[j].length; k++) {
						System.out.print(matriz[j][k]+" ");
						
						if (matriz[j][k]==0) {
							contCeros++;
						}
					}
					
					if (contCeros >= (varNum+1)) {
						System.out.println("\n///////El SEL tiene soluciones infinitas///////");
						break outerloop;
					}	
				}
			}
			
			//Mostrar en pantalla la matriz resultante del SEL procesada
			System.out.println("\n\nLa matriz del sistema de ecuaciones final es");
			for (int i = 0; i < varNum; i++) {
				for (int j = 0; j < varNum+1; j++) {
					System.out.print(matriz[i][j]+" ");
				}
				System.out.println("");
			}
	}//Fin del metodo procesarSel
	
	static void despeje(Scanner leer){
		double var, resultado, resultFinal;
			
			System.out.print("Escribe el coeficiente de la variable: ");
			var = leer.nextDouble();
			
			System.out.print("Escribe el resultado: ");
			resultado = leer.nextDouble();
			
			resultFinal = resultado/var;
			System.out.println("El resultado de la ecuacion es: "+resultFinal);
	}
    
}
