package ex1;

import java.io.*;

public class VerificarePereche {

	public static void verificarePereche(int a, int b, PrintStream out) throws PerecheExceptie, IOException 
	{
		if (a >= b) {
			throw new PerecheExceptie("\nEroare : primul numar nu este mai mic decat al doilea!\n");
		}
		
		System.out.println("\nPerechea de numere introdusa a fost scrisa in fisier!");
		out.print("(" + a + " ");
		out.print(b + ")\n");
	}

}