package ejercicio1_serie1;

public class Problema_2 {
			
		
		
	
	public static void main(String[] arg) {
		
		int [] numeros2 = {6,8,2,4,5,10,45};
        int[] resultado = secondMinMax(numeros2);
       
        System.out.println("Numero mernor del arreglo :" + resultado[0]);
        System.out.println("Numero mayor del arreglo :" + resultado[1]);
        

		
	}
	public static int[] secondMinMax(int[]numbers) {
		int min = Integer.MAX_VALUE;
		int secondMin = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		
		for ( int num: numeros2) {
			if ( num<min) {
				secondMin = min;
				min = num;
				}
			}
		}
		
		
}
	


