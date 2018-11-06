package Container;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Integer;
import Container.Deck;

public class Jugador {
	static final String[] MANO = {"Carta mas alta", "Pareja", "Doble pareja","Trio", "Escalera", "Color", "Full", "Poker", "Escalera de Color", "Escalera Real"};
	Deck hand;
	
	public Jugador(Deck hand) {
		this.hand = hand;
	}
	
	/* 10 - Escalera Real
	 * 9 - Escalera de Color
	 * 
	 * 
	 * 
	 */
	public int checkMano(Deck tapete) {
		Deck poll = hand.suma(tapete);
		
		//trucar
		poll = new Deck(true, 7);
		poll.setCard(new Card(2, 3), 0);
		poll.setCard(new Card(3, 2), 1);
		poll.setCard(new Card(2, 2), 2);
		poll.setCard(new Card(3, 2), 3);
		poll.setCard(new Card(5, 2), 4);
		poll.setCard(new Card(4, 2), 5);
		poll.setCard(new Card(7, 2), 6);
		
		poll.sortDeck();
		System.out.println("Hand:"+poll.toString());
		int jugada = 0;
		
		if (isEscaleraReal(poll)) {
			jugada = 10;
		}
//		else if (isEscaleraColor(poll)) {
//			jugada = 9;
//		}
		else if (isEscalera(poll)) {
			jugada = 5;
		}
		
		
		return jugada;
	}
	
	private boolean isMismoPalo(Deck mano) {
		int palo = mano.getCards()[0].getPalo(); //palo que tienen que tener todas
		
		for(int i=1;i<mano.numCartas();i++) {
			if (mano.getCards()[i].getPalo() != palo) {
				return false;
			}
		}
		return true;
	}
	
	// comprueba si 5 cartas conforman escalera
	private boolean isEscaleraDeCinco(ArrayList<Integer> aux) {
		
		//como hay 5 cartas, puede haber solo una escalera
		Collections.sort(aux); //ordenamos de menor a mayor
		int inicio = aux.get(0); // el mas pequeño
		
		// hay escalera, el menor tiene que ser maximo 10
		if (inicio < 11) {
			int[] escalera = {inicio, inicio+1,inicio+2,inicio+3,inicio+4};
			
			for(int i=0; i<aux.size();i++) {
				if (aux.get(i) != escalera[i]) {
					return false;
				}
			}
		} else { //si el menor es 11 o mas, es imposible hacer escalera
			return false;
		}
		return true;
	}
	
	private boolean isEscalera(Deck mano) {
		ArrayList<Integer> aux = new ArrayList<>();
		ArrayList<Integer> aux2 = new ArrayList<>();
		ArrayList<Card> arrayMano = mano.getArrayCards();
		
		//en aux solo valores unicos no repetidos!
		for(int i=0; i<mano.numCartas(); i++) {
			if (!aux.contains(mano.getCards()[i].getValue())) {
				aux.add(mano.getCards()[i].getValue());
			}
		}
		
		switch (aux.size()) { //puede haber hasta siete cartas distintas
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
				return false; //no puede haber escalera con menos de 5 cartas
			case 5: return isEscaleraDeCinco(aux); //solo hay una escalera posible
			case 6: 
				for (int i=0;i<2;i++) { //solo dos posibles
					aux2.clear();
					for(int j=i; j<5+i; j++) {
						aux2.add(aux.get(j)); //añade 0-4 y luego de 1-5
					}
					if (isEscaleraDeCinco(aux2)) {
						return true;
					}
				
				}
				break;	
			case 7:
				for (int i=0;i<3;i++) { //solo tres posibles
					aux2.clear();
					for(int j=i; j<5+i; j++) {
						aux2.add(aux.get(j)); //añade 0-4, luego de 1-5 y luego 2-6
					}
					if (isEscaleraDeCinco(aux2)) {
						return true;
					}
				}
				break;
			default:
				System.out.println("Error isEscalera()");
				break;
				
		}
		return false;
	}
	
	private boolean isMismoColor(Deck mano) {
		return isMismoPalo(mano);
	}
	
	private boolean isEscaleraReal(Deck mano) {
		int[] escalera = {10,11,12,13,14};
		mano.sortDeck();
		
		// si las 5 cartas ordenadas tienen estos valores
		for(int i=0;i<mano.numCartas();i++) {
			if (mano.getCards()[i].getValue() != escalera[i]) {
				return false;
			}
		}
		if (isMismoPalo(mano)) {
			return true;
		}
		return false;
	}
	
	private boolean isEscaleraColor(Deck mano) {
		if (isMismoColor(mano) && isEscalera(mano)) {
			return true;
		}
		return false;
	}
}
