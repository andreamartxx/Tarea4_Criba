import java.util.Scanner;
public class Num_Primos {
    	/**
    	 * @author Andrea Martin Rodriguez
    	 * @version 1.0.0
    	 * @since 22-02-21
    	 */
    	
    	/**
    	 * Declaramos las variables, boolean para saber si es primo o no, un array de primos y por último la variable 
    	 * dim que usaremos para aumentarle un valor al numero maximo (explicado en el siguiente metodo).
    	 * 
    	 */
    	private static boolean esPrimo[];
    	private static int primos[];
    	private static int dim;
    	
    	/**
    	 * Si el numero insertado por teclado es mayor que 2 devuelve el vector de números primos haciendo la criba, y si es menor de dos
    	 * devuelve un vector vacio porque no hay más numeros primos por debajo de 2, ya que el 0 y el 1 quedan descartados
    	 * en el metodo de inicioPrimos(max).
    	 * @param max = numero introducido desde teclado por el usuario.
    	 * @return array de primos
    	 */
    	
    	public static int [] generarPrimos (int max) {
    		if(max < 2) {
    			return new int [0]; //vector vacio
    		} else {
    			inicioPrimos(max);
    			encontrar();
    			vector();
    			return primos;
    		}
    	}
    	
    	/**
    	 * Inicio del vector, devuelve todos los numeros que hay hasta llegar al numero tecleado por el usuario.
    	 * eliminacion de el 0 y el 1 que no son numeros primos
    	 * @param max = numero introducido desde teclado por el usuario.
    	 */
    	
    	private static void inicioPrimos (int max) {
    		int i;
    		
    		dim = max + 1;
    		esPrimo = new boolean [max + 1];
    		
    		for(i = 2; i < esPrimo.length; i++)
    			esPrimo[i] = true;
    		
    		esPrimo[0] = esPrimo [1] = false;
    	}
    	
    	/**
    	 * Este método realiza la criba y elimina los múltiplos de i
    	 */
    	
    	private static void encontrar () {
    		int i, j;
    		for ( i = 2; i < Math.sqrt (dim) + 1; i++) {
    				if (esPrimo[i]) {
    					//eliminar multiplos i
    					for (j = 2*i ; j < dim; j+=i)
    						esPrimo[j] = false;
    				}
    		}
    	}
    	
    	/**
    	 * Cuenta los numeros primos y los rellena en el vector de primos.
    	 */
    	private static void vector () {
    		int i, j, cuenta;
    		//contar primos
    		cuenta = 0;
    		for ( i = 0; i < dim; i++)
    			if (esPrimo [i])
    				cuenta++;
    		//Rellena vector de numeros primos
    		primos = new int [cuenta];
    		
    		for ( i = 0, j = 0; i < dim; i++)
    			if (esPrimo[i])
    				primos[j++] = i;
    	}
    	
    	public static void main(String[] args) {
    		Scanner teclado=new Scanner(System.in);
    		System.out.println("Introduce el numero para la criba de Erastï¿½tenes:");
    		
    		int dato=teclado.nextInt();
    		int vector[]=new int[dato];
    		
    		System.out.println("\nVector inicial hasta: "+dato);
    		
    		for (int i = 0; i < vector.length; i++) {
    				if (i%10==0) System.out.println();
    						System.out.print(i+1+"\t");
    			}
    		
    		vector=generarPrimos(dato);
    		
    		System.out.println();
    		System.out.println("\nVector de primos hasta: "+dato);
    		
    		for (int i = 0; i < vector.length; i++) {
    				if (i%10==0) System.out.println();
    						System.out.print(vector[i]+"\t");
    		teclado.close();
    }
}
    
}