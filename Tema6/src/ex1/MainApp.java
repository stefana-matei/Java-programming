package ex1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);
		FileOutputStream fisierOut = new FileOutputStream("pereche.txt");
		PrintStream out = new PrintStream(fisierOut);
		int a, b;

		
		do {

			System.out.println("\nScrieti primul numar: ");
			a = scanner.nextInt();

			System.out.println("\nScrieti al doilea numar: ");
			b = scanner.nextInt();

			
			try {
				VerificarePereche.verificarePereche(a, b, out);
				
			} catch (PerecheExceptie exceptie) {

				System.out.println(exceptie);

			}

		} while (a >= b);
		
		
		scanner.close();
	}
}