package ex1.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import ex1.Banca;
import ex1.Client;
import ex1.ContBancar;

public class ClientiiBancilor {

	public static void main(String[] args) throws IOException {

		
		Vector<Banca> banci = new Vector<Banca>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int optiune = 0;
		
		
		do {

			System.out.println("\n1. Adaugare banci, clienti, conturi");
			System.out.println("2. Afisare date introduse.");
			System.out.println("3. Depunerea unei sume in cont.");
			System.out.println("4. Extragerea unei sume din cont.");
			System.out.println("5. Transfer de bani intre doua conturi.");
			System.out.print("\nOptiunea dvs : ");
			optiune = scanner.nextInt();

			switch (optiune) {

			
			case 1:

				adaugare(banci);
								
				break;

				
			case 2:

				afisare(banci);
				
				break;
				
				
			case 3:
			{
				
				float suma = 0;
				String cont = "";
				
				
				System.out.println("\nIn ce cont depuneti bani? : ");
				cont = br.readLine();

				
				System.out.println("Ce suma depuneti in cont? : ");
				suma = scanner.nextFloat();
				
				
				depunere(suma, cont, banci);
			}
			
				break;
				
				
			case 4:
			{
				
				float suma = 0;
				String cont = "";
				
				
				System.out.println("\nDin ce cont extrageti bani? : ");
				cont = br.readLine();

				
				System.out.println("Ce suma extrageti din cont? : ");
				suma = scanner.nextFloat();
				
				
				extragere(suma, cont, banci);
			}
			
				break;
				
				
			case 5:
			{
				
				float suma = 0;
				String contDepunere = "";
				String contExtragere = "";
				
				
				System.out.println("\nDin ce cont transferati bani? : ");
				contExtragere = br.readLine();
				
				
				System.out.println("\nIn ce cont transferati bani? : ");
				contDepunere = br.readLine();

				
				System.out.println("\nCe suma transferati? : ");
				suma = scanner.nextFloat();
				
				
				extragere(suma, contExtragere, banci);
				depunere(suma, contDepunere, banci);
				
			}
			
				break;
			
				
			default:
				
				System.out.println("\nOptiunea aleasa nu exista, mai incearca!");
				
				break;
			}

		} while (optiune != 0);
	}
	
	
	
	
	

	private static void adaugare(Vector<Banca> banci) throws IOException 
	{
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int optiuneMeniu = 0;
		
		
		do {
			
			System.out.println("\n1. Acceseaza banca existenta");
			System.out.println("2. Adauga banca noua");
			System.out.println("0. Intoarcere la meniul anterior");
			
			optiuneMeniu = scanner.nextInt();
			
			
			switch (optiuneMeniu) {

			case 1:
				
				
				if(banci.size() == 0) {
					// Daca lista este goala
					System.out.println("\nLista de banci este goala.");
					break;
				}
				
				
				// Daca lista nu este goala procesam cererea
				System.out.println("\nMeniul carei banci vreti sa il accesati: ");
				
				for (int i=0;i<banci.size();i++)
					System.out.println( i + ": " + banci.elementAt(i));
				
				
				int optiuneBancaAleasa = scanner.nextInt();
				banci.elementAt(optiuneBancaAleasa).meniu();
				
				break;
				
								
			case 2:
				
				System.out.println("\nNumele bancii: ");
				String denumireBanca = buffer.readLine();			
				
				Banca banca = new Banca(denumireBanca);
				
				banci.add(banca);
				
				System.out.println("\nBanca a fost adaugata cu succes! \n   " + banca);
				
				break;
			}
			
		}while(optiuneMeniu != 0);		
	}
	
	
	private static void afisare(Vector<Banca> banci)
	{
		
		System.out.println("");
		for (int i = 0; i < banci.size(); i++) {
			
			System.out.println(banci.elementAt(i).toString());	//afisare banca
	
			Iterator<Client> itClient = banci.elementAt(i).getListClient().iterator();
			while(itClient.hasNext()) {
				
				Client client = itClient.next();
				System.out.println(client.toString());

				
				Iterator<ContBancar>itContBancar = client.getSetCont().iterator();
				while(itContBancar.hasNext()) {
					
					ContBancar cont = itContBancar.next();
					System.out.println(cont.toString());		
				}
				
				System.out.print("\n");
				
			}
			System.out.print("\n");
		}
	}
	
	
	private static void depunere(float suma, String numarCont, Vector<Banca> banci) 
	{
		
		for (int i = 0; i < banci.size(); i++) {
			
			Iterator<Client> itClient = banci.elementAt(i).getListClient().iterator();
			while(itClient.hasNext()) {
				
				Client client = itClient.next();
				
				Iterator<ContBancar>itContBancar = client.getSetCont().iterator();
				while(itContBancar.hasNext()) {
					
					ContBancar cont = itContBancar.next();
					if(cont.getNumarCont().equals(numarCont)) {
						
						cont.depunere(suma);
					}
				}
			}
		}
	}
	
	
	private static void extragere(float suma, String numarCont, Vector<Banca> banci) 
	{
		
		for (int i = 0; i < banci.size(); i++) {
			
			Iterator<Client> itClient = banci.elementAt(i).getListClient().iterator();
			while(itClient.hasNext()) {
				
				Client client = itClient.next();
				
				Iterator<ContBancar>itContBancar = client.getSetCont().iterator();
				while(itContBancar.hasNext()) {
					
					ContBancar cont = itContBancar.next();
					if(cont.getNumarCont().equals(numarCont)) {
						
						cont.extragere(suma);
					}
				}
			}
		}
	}
}