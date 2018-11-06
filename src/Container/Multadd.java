package Container;
import java.util.ArrayList;

public class Multadd {

	public static void main(String[] args) {
//		System.out.println(multadd(1.0, 2.0, 3.0));
//		System.out.println(multadd(1/2, Math.cos(Math.PI/4), Math.sin(Math.PI/4)));
//		System.out.println(multadd(1, Math.log(10), Math.log(20)));
//		System.out.println(expSum(3.5));
//		System.out.println(factorial(4));
//		System.out.println(pow(2, 6));
//		System.out.println(gauss(.3, 29));
//		System.out.println(pow_recursive(2, 8));
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		long num = Long.MAX_VALUE; // maximo valor long (63 bits a 1)
		
		String bin = toBinary(num);
		
		System.out.println(bin);
		System.out.println(bin.length());
		
		// pasar long a binario
		while (num >= 1) {
			int resto = (int) (num % 2);
			array.add(0,resto);
			if (resto == 1) {
				num = num - 1;
			}
			num = num / 2;
			
		}
		//imprime array
		for (int i: array) {
			System.out.print(i);
		}
		
		int[] a = {1, 2, 3};
		int[] b = {4, 5, 6};
		int[][] aba = {a,b,a};
		
		imprimirArray(aba);
		
		Object[] lol = {"lol",5};
		
		for (Object i: lol) {
			System.out.println("Mi objeto: "+i);
		}
		
			
	}

	private static void prueba() {
		// TODO Auto-generated method stub
		System.out.println("Prueba total");
	}
	private static void imprimirArray(int[][] array) {
		for(int i=0; i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				System.out.println(array[i][j]);
			}
		}
		prueba();
		
	}


	public static String getElement(String[] myArray) {
		return myArray[0];
	}
	
	public static double multadd(double a, double b, double c) {
		return a * b + c;
	}
	
	/**
	 * @param un double
	 * @return a * b + c
	 */
	public static double expSum(double x) {
		return (multadd(x, Math.exp(-x), Math.sqrt(1-Math.exp(-x))));
	}

	public static double gauss(double x, int n) {
		double acum = 0;
		for (int i = 0; i<n; i++) {
			acum += (Math.pow(-1,i) * Math.pow(x,(2*i))/factorial(i));
		}
		return acum;
	}
	
//	private static int pow(int num, int exp) {
//		int acum = 1;
//		for (int i = exp; i>=1; i--) {
//			acum *= num;
//		}
//		return acum;
//		
//	}

	private static int factorial(int i) {
		if (i==0) { 
			return 1;
		} else {
			return i * factorial(i-1);
		}
		
	}
	
	public static int pow_recursive(int num, int exp) {
		if (exp == 0) {
			return 1;
		} else {
			return num * pow_recursive(num, exp-1);
		}
	}
	
	public static String toBinary(long n) {
		if (n == 1) {
			return "1";
		} else {
			return toBinary(n/2) + resto(n);
		}
	}
	
	// devuelve el resto
	public static String resto(long n) {
		if (n % 2 == 0) { //tenemos un 0
			return "0";
			
		} else { // tenemos un 1
			return "1";
		}
	}

}
