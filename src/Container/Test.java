package Container;
import Container.Card;

public class Test {

	public static void main(String[] args) {

		
		Mesa mesa = new Mesa();
		Jugador yo = new Jugador(mesa.repartir(2));
		
		mesa.flop();
		System.out.println("Flop:");
		System.out.println(mesa);
		System.out.println();
		mesa.turn();
		System.out.println("Turn:");
		System.out.println(mesa);
		System.out.println();
		
		System.out.println("River:");
		mesa.river();
		System.out.println(mesa);
		System.out.println();
		
		System.out.println(yo.checkMano(mesa.getTapete()));
		
		String hand = "2233454";
		permuta(hand.toCharArray(), "", 5);
		
	}
	
	 static boolean[] control = new boolean[100];
	    public static void permuta(char[] elementos, String actual, int cantidad) {
	        if(cantidad==0) {
	            // Hacer con la secuencia generada
	            System.out.println(actual);
	        }
	        else {
	            for(int i=0; i<elementos.length; i++  ) {
	                if(control[i]==true) continue;
	                control[i]=true;
	                permuta(elementos, actual+elementos[i],cantidad-1);
	                control[i]=false;
	            }
	        }
	    }

}
