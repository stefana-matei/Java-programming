package ex2;

import java.util.Comparator;

public class ComparaTitlu implements Comparator<Carte> {

	public int compare(Carte c1, Carte c2) {

		return (((Carte) c1).getTitlu().compareTo(((Carte) c2).getTitlu()));
	}
}