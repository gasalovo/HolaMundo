package Container;

public class Card {
	
	private int valor;
	private int palo;
	
	static final String[] VALORES = new String[] {"Comodin", "-","2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King","As"};
	static final String[] PALOS = new String[] {"Comodin","Pica", "Corazon", "Diamante", "Trebol"};
	
	
	public Card(int valor, int palo){
		
		if ((valor < 2 || valor > 14) || (palo < 0 || palo > 4)) {
			System.out.println("Carta invalida, valor: "+valor+"; palo: "+palo+" : ahora es un comodin");
			this.valor = 0;
			this.palo = 0;
		} else {
			this.valor = valor;
			this.palo = palo;
		}
	}
	
	public String toString() {
		if (this.valor == 0) {
			return("El comodin");
		}
		return ("El "+VALORES[this.valor]+" de "+PALOS[this.palo]);
	}
	
	public boolean equals(Card that) {
		if (this.valor == that.valor && this.palo == that.palo) {
			return true;
		} else {
			return false;
		}
	}
	
	// compara primero valor y si son iguales, compara los palos (por poner un orden...)
	public int compareTo(Card that) {
		if (this.valor > that.valor) return 1;
		if (this.valor < that.valor) return -1;
		if (this.palo > that.palo) return 1;
		if (this.palo < that.palo) return -1;
		
		return 0;
	}
	
	public int getValue() {
		return valor;
	}
	
	public int getPalo() {
		return palo;
	}
	
	
}
