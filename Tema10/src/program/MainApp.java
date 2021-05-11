package program;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainApp {

	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(new File("in.txt"));

		// colectia de angajati de tip list
		List<Angajat> angajati = new ArrayList<Angajat>();
		
		
		//lista de angajatii din luna Aprilie cu functii de conducere
		List<Angajat> aprilLeaders = new ArrayList<Angajat>();
		
		
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
		angajati.forEach(System.out::println);
		
		
		//afisare angajati care au salariul peste 2500 ron
		System.out.println("\nAngajatii cu salariile mai mari de 2500 RON : ");
		angajati.stream()
				.filter(angajat -> angajat.hasSalaryBiggerThan(2500))
				.forEach(System.out::println);
		
		
		//afisare angajatii din luna Aprilie, a anului curent, care au functie de conducere
		System.out.println("\nAngajatii din luna Aprilie, a anului curent, care au functie de conducere : ");
		aprilLeaders = angajati
						.stream()
						.filter((angajat) -> angajat.isMonthOfEmployment(4))
						.filter((angajat) -> angajat.isYearOfEmployment(2021))
						.filter(Angajat::hasLeadingPosition)
						.collect(Collectors.toList());
						

	}
}