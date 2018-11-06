package Container;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import Container.Generator;
import Container.Card;



public class Deck {
	private Card[] cards; //array with Cards
	ArrayList<Card> arrayCards; //arrayList with Cards
	Generator gen; //generator with arrayCards
	ArrayList<Card> escalera;
	
	
	// genera una baraja de 52 cartas (baraja francesa)
	public Deck() {
		this.cards = new Card[52];
		int index = 0;
		for (int i = 1; i<=4; i++) { // rellena palos
			for (int j = 2; j<=14; j++) {
				this.cards[index] = new Card(j,i); // valor, palo
				index++;
			}
		}
		build_arrayList();
	}
	
	// genera una baraja de n cartas aleatorias (se repiten!)
	// no genera comodines
	public Deck(int cards) {
		this.cards = randomDeck(cards);
		
		//for (int i = 0; i<cards; i++) { // create n random cards
		//	this.cards[i] = new Card(random.nextInt(13)+1, random.nextInt(3)+1);
		//}
		build_arrayList();
	}
	
	// empty Deck if empty=true
	public Deck(boolean empty, int cards) {
		//this(cards);
		if (empty) {
			this.cards = new Card[cards];
		} else {
			this.cards = randomDeck(cards);
		}
		build_arrayList();
	}
	
	public Card[] randomDeck(int cards) {
		Random random = new Random();
		Card[] aux = new Card[cards];
		
		for (int i = 0; i<cards; i++) { // create n random cards
			aux[i] = new Card(random.nextInt(13)+2, random.nextInt(4)+1); //(max - min + 1)+min
		}
		return aux;
	}
	
	public void build_arrayList() {
		arrayCards = new ArrayList<Card>(Arrays.asList(this.cards));
		gen = new Generator(arrayCards);
	}
	
	// imprime la baraja
	public void printDeck() {
		for (int i = 0; i<=this.cards.length-1; i++) {
			System.out.println(this.cards[i]);
		}
	}
	public void sortDeck() {
		Arrays.sort(this.cards, new SortCard());
		build_arrayList();
	}
	
	public void shuffleDeck() {
		Card[] shuffled = new Card[getCards().length];
		Random random = new Random();
		
		for(int i=0; i<getCards().length;i++) {
			int random_number = random.nextInt(getCards().length-i); //numero aleatorio, rango-1 al anterior
			Card tmp = getCards()[random_number]; //salvo ese elemento
			shuffled[i] = tmp; //lo meto a la derecha del anterior
			this.cards[random_number] = getCards()[(getCards().length-1)-i]; //muevo el del extremo al hueco que deja el random
		}
		this.cards = shuffled;
		build_arrayList();
	}
	
	public Card robar() {
		return gen.next();
		
	}
	
	public void setCard(Card card, int n) {
		this.cards[n] = card;
		build_arrayList();
	}
	
	public Card[] getCards() {
		return this.cards;
	}
	
	public Deck robar(int num) {
		Deck hand;
		if (num == 0) {
			return hand = new Deck(true, 0); //deck nulo
		} 
		//if (num > this.cards.length) { //no puedes robar mas de las cartas que hay en la baraja
		//	num = this.cards.length;
		//}
		
		hand = new Deck(true, num); //empty Deck
		for (int i=0; i<num; i++) {
			Card card = this.robar();
			//System.out.println("Carta que he robado: "+card.toString());
			hand.setCard(card, i); // fill empty Deck
		}
		//update this.cards
		Card[] aux = new Card[this.cards.length-num];
		for (int i = 0; i<aux.length; i++) {
			aux[i] = this.cards[i+num];
		}
		this.cards = aux;
		
		build_arrayList(); // update arrayCards
		
		return hand;
		
	}
	
	public String toString() {
		String mazo = "";
		for (int i = 0; i<this.getCards().length; i++) {
			mazo += this.getCards()[i].toString()+"\n";
		}
		return mazo.substring(0,mazo.length()-1); //skip last \n
	}
	
	public Deck suma(Deck that) {
		Deck suma = new Deck(true, this.getCards().length+that.getCards().length);
		
		//las cartas de that
		for(int i = 0; i<that.getCards().length;i++) {
			suma.setCard(that.robar(), i);
		}
		//las cartas de this
		for(int i = that.getCards().length; i<this.getCards().length+that.getCards().length;i++) {
			suma.setCard(this.robar(), i);
		}
		suma.build_arrayList();
		return suma;
	}
	
	public int numCartas() {
		return getCards().length;
	}
	
	public ArrayList<Card> getArrayCards(){
		return arrayCards;
	}
	
	
}
