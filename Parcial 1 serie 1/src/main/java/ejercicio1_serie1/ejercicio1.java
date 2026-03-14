package ejercicio1_serie1;

public class ejercicio1 {
	public static void main(String[] arg) {
		int [] numeros = {1,2,3,4,5};
		int total;
		total = 0; 
		
		for (int i =0; i<numeros.length; i++) {
			
			total +=funcion(numeros[i]);
					
			System.out.println("El total es : " + total );
		}
		
	}
	
	public static int funcion(int num) {
	if (num ==0) {
		return 0;}
	if (num ==5) {
		return 5;
	}
	if ( num %2 == 0) {
		return 1;
	}
	return 3;
	
	}
	
	

}
