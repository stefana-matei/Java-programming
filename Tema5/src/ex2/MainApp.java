package ex2;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MainApp {

	public static void main(String[] args) throws IOException {

		
		Scanner input = new Scanner(new File("in.txt"));
		Map<Integer, Carte> map = new HashMap<Integer, Carte>();
		String titlu, autor;
		int an, key;

		
		System.out.println("\n1. Afisare colectia de obiecte de tip Map ");
		while (input.hasNext()) {

			String v[] = input.nextLine().split(";");
			key = Integer.parseInt(v[0]);
			titlu = v[1];
			autor = v[2];
			an = Integer.parseInt(v[3]);
			Carte carte = new Carte(titlu, autor, an);

			//introducem cartile in colectie
			map.put(key, carte);

			//System.out.println("\nKey : " + key + carte);
		}
		System.out.println(map);
		
		
		System.out.println("\n\n2. Afisare colectia de obiecte de tip List ");
		List<Carte> carti = new ArrayList<Carte>(map.values());
		for(Carte carte : carti) {
			System.out.println(carte);
		}
		
		
		System.out.println("\n\n3. Afisare colectia de obiecte de tip List ordonata dupa titlul cartii ");
		Collections.sort(carti, new ComparaTitlu());
		for(int i = 0;i < carti.size();i++) {
			System.out.println(carti.get(i));	
		}
	}
}