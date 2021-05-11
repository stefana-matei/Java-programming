package ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Client {

	private String nume, adresa;
	private Set<ContBancar> conturi = new LinkedHashSet<ContBancar>();
	
	
	public Client(String nume, String adresa) 
	{
		this.nume = nume;
		this.adresa = adresa;
	}
	
	
	public String getNume()
	{
		return nume;
	}
	
	
	public String getAdresa()
	{
		return adresa;
	}
	
	
	public String toString()
	{
		return "Nume client : " + nume + " Adresa : " + adresa;
	}
	
	
	public void adaugaContBancar(ContBancar cont)
	{
		if(conturi.size() >= 5) {
			System.out.println("\nAti atins deja numarul maxim de conturi, nu s-a introdus acest cont!");
			return;
		}
		
		conturi.add(cont);
	}
	
	
	
	public Set<ContBancar> getSetCont()
	{
		return conturi;
	}
	
	
	public void meniu() throws IOException 
	{
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int optiuneMeniu = 0;
		
		
		do {
			
			System.out.println("\n1. Adauga cont nou");
			System.out.println("0. Intoarcere la meniul anterior");

			optiuneMeniu = scanner.nextInt();
			
			switch (optiuneMeniu) {

			case 1:
								
				System.out.println("\nNumar cont: ");
				String numarCont = buffer.readLine();
				
				System.out.println("\nSuma: ");
				float suma = scanner.nextFloat();
				
				System.out.println("\nMoneda: ");
				String moneda = buffer.readLine();
				
				Calendar data_deschiderii = Calendar.getInstance();
				data_deschiderii.set(2019, 7, 22);
				
				Calendar data_ultimei_operatiuni = Calendar.getInstance();
				data_ultimei_operatiuni.set(2020, 0, 7);
				
				ContBancar cont = new ContBancar(numarCont, suma, moneda, data_deschiderii, data_ultimei_operatiuni);
				
				this.adaugaContBancar(cont);
				
				
				if(conturi.size() == 5) {
					System.out.println("\nS-a atins limita maxima posibila!");
				}
				else
					System.out.println("\nContul a fost adaugat cu succes! \n   " + cont);
		
				break;
			}
			
		}while(optiuneMeniu != 0);
		
	}
}