package ejercicio1_serie1;

public class Problema_2 {
			
		
		
	
	public static void main(String[] arg) {
		
		int [] numeros2 = {7,2,9,4,1,8};
        int[] resultado = secondMinMax(numeros2);
       
        System.out.println("Numero mernor del arreglo :" + resultado[0]);
        System.out.println("Numero mayor del arreglo :" + resultado[1]);
        

		
	}
	public static int[] secondMinMax(int[]numbers) {
		int min = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		
		for ( int num: numbers) {
			if ( num<min) {
				secondMin = min;
				min = num;
				}
			else if( num< secondMin && num != min) {
				secondMin = num;
			}
			if ( num>max) {
				secondMax = max;
				max = num;
			}
			else if ( num>secondMax && num !=max) {
				secondMax = num;
				
			}
			
		}
		return new int [] {secondMin, secondMax};
	}
		
}
	


