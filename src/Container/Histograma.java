package Container;

import java.util.Random;

public class Histograma {

	public static void main(String[] args) {
		
		int[] datos = new int[100]; // 100 valores
		Random random = new Random();
		for(int i = 0; i<100; i++) {
			datos[i] = random.nextInt(100); // relleno con valores aleatorios del 0-99
		}
		
		int[] counts = contar(datos); //calculo las ocurrencias de cada valor
		drawHistogram(counts); // pinto el histograma
		
		
	}
	
	private static void drawHistogram(int[] counts) {
		String aux = "";
		for(int i=getMax(counts); i>0;i--) {
			for(int j=0; j<counts.length; j++) {
				if (counts[j] >= i) {
					aux += "\u007c\t";
				} else {
					aux += " \t";
				}
			}
			System.out.println(aux);
			aux = "";
		}
		String line = "";
		for (int i=0; i<counts.length; i++) {
			aux += i + "\t";
		}
		System.out.println(line);
		System.out.println(aux);
	}

	public static int[] contar(int[] datos) {
		int[] counts = new int[getMax(datos)+1]; //igual de grande que el maximo valor
		
		for(int i=0; i<datos.length; i++ ) {
			counts[datos[i]]++;
		}
		return counts;
	}
	
	public static int getMax(int[] array) {
		
		int max = Integer.MIN_VALUE;
		for (int i=0; i<array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		return max;
		
	}
	
}
