package Container;

import java.util.Comparator;

public class SortCard implements Comparator<Card> {
	public int compare(Card a, Card b) {
		return a.compareTo(b);
	}
}


