package program;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainApp {
	

	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(new File("in.txt"));

		// colectia de angajati de tip list
		List<Angajat> angajati = new ArrayList<>();
		
		
		//lista de angajatii din luna Aprilie cu functii de conducere
		List<Angajat> aprilLeaders = new ArrayList<>();
		
		
		//lista de angajati fara functii de conducere
		List<Angajat> nonLeaders = new ArrayList<>();
		
		
		//lista de String-uri cu numele angajatilor scrise cu majuscule
		List<String> upperCasedNames = new ArrayList<>();
		
		
		while (input.hasNext()) {
			
			String[] dateAngajati = input.nextLine().split(", ");
			
			angajati.add(new Angajat(
					dateAngajati[0],
					dateAngajati[1],
					LocalDate.parse(dateAngajati[2], DateTimeFormatter.ofPattern("dd/MM/yyyy")),
					Float.parseFloat(dateAngajati[3])
					));
		}
		
		
		//afisare colectie de angajati
		System.out.println("Toate datele despre angajatii din firma : " + "\n");
		angajati.forEach(System.out::println);
		
		
		//afisare angajati care au salariul peste 2500 RON
		System.out.println("\nAngajatii cu salariile mai mari de 2500 RON : ");
		angajati
		.stream()
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
		
		aprilLeaders.forEach(System.out::println);
		
		
		//afisare angajati care nu au functie de conducere in ord. descresc. a salariilor
		System.out.println("\nAngajatii fara functii de conducere sortati in ordinea descrescatoare a salariilor : ");
		nonLeaders = angajati
					.stream()
					.filter((angajat) -> !(angajat.hasLeadingPosition()))
					.collect(Collectors.toList());
		
		nonLeaders.sort(Comparator.comparing(Angajat::getSalariul).reversed());
		nonLeaders.forEach(System.out::println);
		
		
		//afisare lista de String-uri cu numele angajatilor scrise cu majuscule
		System.out.println("\nLista de String-uri care contine numele angajatilor scrise cu majuscule : ");
		upperCasedNames = angajati
						.stream()
						.map(angajat -> angajat.getNume().toUpperCase())
						.collect(Collectors.toList());
		
		upperCasedNames.forEach(System.out::println);
		
		
		//afisare doar salariile mai mici de 3000 RON
		System.out.println("\nSalariile ce nu depasesc 3000 RON : ");
		angajati
		.stream()
		.filter(angajat -> !angajat.hasSalaryBiggerThan(3000))
		.map(Angajat::getSalariul)
		.forEach(System.out::println);
	}
}