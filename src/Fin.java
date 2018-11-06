public class Fin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		System.out.println("Adios \"Mundo Cruel\"\nTexto en otra línea\n\tY otra linea mas tabulada");
		System.out.print("lol\n");
		System.out.println("lola");
		
		try {
			System.out.println("Argumento: "+args[0]);
		} catch (Exception e) {
			System.out.println("Petada: "+e);
		}
		
		
		String texto = "my string", name;
		int x = 0, y = 1, edad = 0;
		Boolean done = false;
		
		System.out.print("Numero: "+ x + "\n");
		
		Scanner kb = new Scanner(System.in);
		
		Persona alejandro = new Persona();
		
		
		System.out.println("Como te llamas?");
		
		alejandro.setNombre(kb.next());
		//Alejandro.nombre = kb.next();
		System.out.println("Tu nombre es: "+ alejandro.getNombre() + ", que edad tienes?");
		
		
		while (!kb.hasNextInt() && true) {
				System.out.println("Calamar, que edad tienes?");
				kb.next(); // discard
			}
		alejandro.setEdad(Integer.parseInt(kb.next())); //take it
		
		alejandro.saludar();
		
		
		Persona.recorreLista(); // la puedes llamar sin instanciar por ser static
		*/
	
//		int[] count = new int[10];
//		
//		
//		for (int i : count) {
//			System.out.printf("My count: %d\n", i);
		double raiz = 25.8;
		System.out.println("Raiz de: "+raiz+" es: "+raizCuadrada(raiz, 25));
	}
	
		
	public static double raizCuadrada (double num, int aprox) {
		
			double acum = 1.0;
			int i=0;
			while (i < aprox) {
				acum = acum - ((acum*acum-num)/(2*acum));
				System.out.println(acum);
				i++;
			}
			return acum;
		}
		
	}


