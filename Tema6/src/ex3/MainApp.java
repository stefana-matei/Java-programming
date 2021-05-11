package ex3;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {

		String nume, CNP;

		Scanner scanner = new Scanner(System.in);

		System.out.println("\nNume : ");
		nume = scanner.nextLine();

		while (true) {

			System.out.println("\nCNP : ");
			CNP = scanner.nextLine();

			try {

				Persoana p = new Persoana(nume, CNP);
				System.out.println(p);
				p.calculareVarsta(CNP);

				break;
			} 
			catch (CNPEronat exceptie) {

				System.out.println(exceptie);

			}

		}

		scanner.close();
	}
}