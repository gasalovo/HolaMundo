package Container;

public class Erastotenes {

	public static void main(String[] args) {
		
		boolean[] myresult;
		
		//System.out.println(myresult.toString());
		
		myresult = sieve(100);
		
		for (int i=0; i<myresult.length; i++) {
			System.out.println("Numero: "+i +" ; es primo? "+myresult[i]);
		}

	}
	public static boolean[] sieve(int n) {
		int[] nums = new int[n];
		boolean[] result = new boolean[n];
		
		for (int i = 0; i<nums.length; i++) { // rellena el array de 0 a n-1
			nums[i] = i;
		}
		for (int i = 0; i<result.length; i++) { // rellena el array de true
			result[i] = true;
		}
		
		for (int i = 2; i<nums.length; i++) {
			if (result[i] == true) { // si el numero es false, no hago nada y sigo
				for(int e = i+i; e<result.length; e+=i) { //Salto de i en i, son múltiplos de i, los tacho. No tacho el i, porque lo quiero true.
					result[e] = false;
				}
				
			}
		}
		return result;
		
	}
	
}
