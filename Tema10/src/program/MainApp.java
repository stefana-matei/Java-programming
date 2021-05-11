package program;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(new File("in.txt"));

		// colectia de angajati de tip list
		List<Angajat> angajati = new ArrayList<Angajat>();
		
		
		while (input.hasNext()) {
			
			String[] dateAngajati = input.nextLine().split(", ");
			
			angajati.add(new Angajat(
					dateAngajati[0],
					dateAngajati[1],
					LocalDate.parse(dateAngajati[2], DateTimeFormatter.ofPattern("dd/MM/yyyy")),
					Float.parseFloat(dateAngajati[3])
					));
		}
		
		
		//afisare colectie creata de angajati
		System.out.println("Toate datele despre angajatii din firma : " + "\n");
		angajati.forEach((value) -> System.out.println(value + "\n"));
		
		
		//afisare angajati care au salariul peste 2500 ron
		System.out.println("\nAngajatii cu salariile mai mari de 2500 RON : ");
		angajati.stream()
				.filter(angajat -> angajat.hasSalaryBiggerThan(2500))
				.forEach((value) -> System.out.println(value + "\n"));

	}
}