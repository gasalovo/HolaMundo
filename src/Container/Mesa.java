package Container;
import Container.Deck;

public class Mesa {
	
	Deck deck;
	Deck tapete;
	Deck quemadas;
	
	// un turno sería: flop -> turn -> river
	public Mesa() {
		deck = new Deck(); //baraja francesa 52 cartas
		deck.shuffleDeck();
		//deck.printDeck();
	}
	
	public Deck repartir(int num) {
		Deck reparto = deck.robar(num);
		return reparto;
	}
	
	// se quema una y se ponen tres cartas en el tapete
	public void flop() {
		quemadas = deck.robar(1);
		tapete = deck.robar(3);
	}
	
	// se quema una y se suma una carta al tapete
	public void turn() {
		quemadas = quemadas.suma(deck.robar(1)); //suma deck de uno, no una carta
		tapete = tapete.suma(deck.robar(1));
	}
	
	// igual que turn
	public void river() {
		turn();
	}
	
	public Deck getTapete() {
		return tapete;
	}
	
	public String toString() {
		return tapete.toString();
	}
	
}
