package Container;

import java.util.ArrayList;
import java.util.Iterator;
import Container.Card;

public class Generator {
	private final Iterator<Card> iterator;
	
//	public Generator(Card[] cards) {
//		IntStream i = IntStream.generate(cards);
//		iterator = i.iterator();
//	}
	
	public Generator(ArrayList<Card> arrayCards) {
		iterator = arrayCards.iterator();
	}
	
	public Card next() {
		if (iterator.hasNext()) {
			return iterator.next();
		}
		return new Card(0,0);
	}
}
