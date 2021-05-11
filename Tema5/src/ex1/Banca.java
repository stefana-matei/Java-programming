package ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banca {

	private String denumire_banca;
	private List<Client> clienti = new ArrayList<Client>();

	
	public Banca(String denumire_banca) 
	{
		this.denumire_banca = denumire_banca;
	}

	
	public String getDenumireBanca() 
	{
		return this.denumire_banca;
	}

	
	public String toString() 
	{
		return "Denumire banca : " + denumire_banca;
	}

	
	public void adaugaClient(Client client) 
	{
		clienti.add(client);
	}

	
	public List<Client> getListClient() 
	{
		return clienti;
	}
	
	
	public void meniu() throws IOException 
	{
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int optiuneMeniu = 0;
		
		do {
			
			System.out.println("\n1. Acceseaza client existent");
			System.out.println("2. Adauga client nou");
			System.out.println("0. Intoarcere la meniul anterior");

			optiuneMeniu = scanner.nextInt();
			
			switch (optiuneMeniu) {

			case 1:
				
				if(this.getListClient().size() == 0) {
					// Daca lista este goala
					System.out.println("\nLista de clienti este goala.");
					break;
				}
				
				System.out.println("\nMeniul carui client vreti sa il accesati: ");
				
				for (int i = 0;i < this.getListClient().size();i++)
					System.out.println( i + ": " + this.getListClient().get(i));
				
				
				int optiuneClientAles = scanner.nextInt();
				this.getListClient().get(optiuneClientAles).meniu();
				
				break;
				
				
			case 2:
				
				System.out.println("\nNumele clientului: ");
				String nume = buffer.readLine();
				
				System.out.println("\nAdresa: ");
				String adresa = buffer.readLine();			
				
				Client client = new Client(nume, adresa);
				
				this.adaugaClient(client);
				
				System.out.println("\nClientul a fost adaugat cu succes! \n   " + client);

				break;
			}
			
		}while(optiuneMeniu != 0);
				
	}
}