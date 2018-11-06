package Container;
import java.util.Vector;


public class Persona {
	
	private int edad;
	public String nombre;
	String apellido;
	
	// constructor 1
	public Persona() {
		this("Pepito");
	}
	// constructor 2
	public Persona(String nom) {
		this.nombre = nom;
	}
	
	public void saludar() {
		System.out.println("Hola, me llamo "+ nombre + " y tengo " + edad + " años\n");
	}
	
	public void setEdad(int value) {
		this.edad = value;
	}
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public void setApellido(String value) {
		this.apellido = value;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public static void recorreLista() {

		Vector<Integer> aList = new Vector<Integer>();
		
		int i;
		for (i=0; i<10; i++) {
			aList.addElement(i);
		}
		for (i=0; i<10; i++) {
			System.out.println("Vector: "+ aList.get(i));
		}
		
	}
	
	
}
