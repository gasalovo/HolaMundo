package Container;


public class Hex {

	public static void main(String[] args) {

		//System.out.println(convertHex(1234567890));
		System.out.println(binToHex("10101101010001011011111110111"));
		System.out.println(decToHex3(1111L));
	}
	
	public static String convertHex(int num) {
		if (num <= 16) {
			return decToHex(num);
		} else {
			int resto = num % 16;
			return convertHex(num/16) + decToHex2(resto);
		}
	}
	
	private static String decToHex(int deci) {
		String dec = "0";
		
			if (deci >= 0 && deci <= 9) {
			dec = Integer.toString(deci);
			return dec;
			} else {
			
			switch (deci) {
			case 10:
				dec = "A";
				break;
			case 11:
				dec = "B";
				break;
			case 12:
				dec = "C";
				break;
			case 13:
				dec = "D";
				break;
			case 14:
				dec = "E";
				break;
			case 15:
				dec = "D";
				break;
			default:
				System.out.println("Algo ha fallado en la conversion decToHex");
				break;
			}	
		}
		return dec;
	}
	
	private static String decToHex2(int deci) {
		//String[] array = new String[] {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		String array = "0123456789ABCDEF";
		//return array[deci];
		return Character.toString(array.charAt(deci));
	}
	
	private static String byteToHex(String cachito) {
		String letra = "";
		switch (cachito) {
		case "0000":
			letra = "0";
			break;
		case "0001":
			letra = "1";
			break;
		case "0010":
			letra = "2";
			break;
		case "0011":
			letra = "3";
			break;
		case "0100":
			letra = "4";
			break;
		case "0101":
			letra = "5";
			break;
		case "0110":
			letra = "6";
			break;
		case "0111":
			letra = "7";
			break;
		case "1000":
			letra = "8";
			break;
		case "1001":
			letra = "9";
			break;
		case "1010":
			letra = "A";
			break;
		case "1011":
			letra = "B";
			break;
		case "1100":
			letra = "C";
			break;
		case "1101":
			letra = "D";
			break;
		case "1110":
			letra = "E";
			break;
		case "1111":
			letra = "F";
			break;
		}
		return letra;
	}
	// este while hace que la cadena sea multiplo de 4 agregando ceros a la izquierda
	private static String binToHex(String bin) {
		String hex = "";
		while (bin.length() % 4 != 0) { // comprueba si la cadena tiene longitud multiplo de 4
			bin = "0" + bin; // si no, le añado un cero y vuelvo a comprobar si es multiplo de 4
		}
		// este while va cogiendo cachitos de 4, los pasa a hexadecimal y acumula en la variable hex
		while (bin.length() != 0) { // el while continua hasta que la cadena tenga longitud cero
			String four = bin.substring(bin.length()-4); // cojo los 4 ultimos
			hex = byteToHex(four) + hex; // paso 4 bits a hexadecimal y acumulo en hex
			bin = bin.substring(0, bin.length() - 4); // al string original le quito los cuatro bits que ya he procesado
		}
		return hex; // cuando ha terminado el while, en hex tengo el hexadecimal completo
		
	}
	
	public static String decToHex3(long n) {
		if (n < 16) {
			return resto(n);
		} else {
			return decToHex3(n/16) + resto(n);
		}
	}
	
	// devuelve el resto
	public static String resto(long n) {
		long resto = n % 16;
		return decToHex2((int)resto);
	}
}
