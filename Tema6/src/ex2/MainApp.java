package ex2;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String a, b;
		float c;
		

		while (true) {
			
			System.out.println("Scrieti primul numar: ");
			a = scanner.nextLine();

			System.out.println("\nScrieti al doilea numar: ");
			b = scanner.nextLine();

			
			try {
				
				c = Float.parseFloat(a) / Float.parseFloat(b);

				System.out.println("\nRezultatul impartirii este " + c);

				break;
			} 
			catch (ArithmeticException exceptie) {

				System.out.println("\nExceptie : nu se poate imparti la zero!\n");

			} 
			catch (NumberFormatException exceptie) {

				System.out.println("\nExceptie : nu se introduc cuvinte!\n");

			}

		}

		scanner.close();
		
	}

}