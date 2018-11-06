

public class Inicio {

	public static void main(String[] args) {
		
		final double PI = 3.1416;
		double radio = calcularRadioCuadrado(3, 4, 5, 6);
		double area = PI * radio;
		
		System.out.println("Area: " + area);
		
	}
	
	public static double cuadrado(double x) {
		return x*x;
	}
	
//	no se necesita para calcular el área
	public static double raizCuadrada(double x) {
		return Math.sqrt(x);
	}
	
	public static double calcularRadioCuadrado(double x1, double y1, double x2, double y2) {
		
		return cuadrado(Math.abs(x1-x2)) + cuadrado(Math.abs(y1-y2));
	}
	

}


