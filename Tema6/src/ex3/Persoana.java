package ex3;

import java.util.Calendar;

public class Persoana {

	private String nume;
	private String CNP;

	
	public Persoana(String nume, String CNP) throws CNPEronat 
	{
		
		if (CNP.length() != 13) {
			throw new CNPEronat("\n\nEroare! => CNP -ul trebuie sa aiba strict 13 caractere!", CNP);
		}
		else if(isCifra(CNP) == false) {
			throw new CNPEronat("\nEroare! => CNP-ul trebuie sa contina doar cifre!", CNP);
		}
		else if(isCifraSex(CNP) == false) {
			throw new CNPEronat("\nEroare! => Prima cifra ce codifica sex-ul trebuie sa fie cuprinsa intre 1 si 6!", CNP);
		}
		else if(isCifraLuna(CNP) == false) {
			throw new CNPEronat("\nEroare! => Cifrele ce codifica luna trebuie sa fie cuprinse intre 1 si 12!", CNP);
		}
		else if(isCifraZiua(CNP) == false) {
			throw new CNPEronat("\nEroare! => Cifrele ce codifica ziua trebuie sa fie cuprinse intre 1 si 31!", CNP);
		}
		else {
			
			this.nume = nume;
			this.CNP = CNP;
		}
	}

	
	public String getNume() 
	{
		return nume;
	}


	public String getCNP() 
	{
		return CNP;
	}
	
	
	public String toString()
	{
		return "\nNume : " + nume + "\nCNP : " + CNP;
	}


	Boolean isCifra(String s) 
	{

		for (int i = 0; i < s.length(); i++)

			if (Character.isDigit(s.charAt(i)) == false)
				return false;

		return true;
	}
	
	
	Boolean isCifraSex(String str)
	{
		int cifraSex = Character.getNumericValue(str.charAt(0));
		
		if(cifraSex > 6 || cifraSex == 0) {
			
			System.out.println("Cifra ce codifica sex-ul este " + cifraSex + "\n");
			return false;
		}
		
		return true;
	}
	
	
	Boolean isCifraLuna(String str)
	{
		
		int luna = convertireCifre(str.charAt(3),str.charAt(4));
		
		if(luna > 12 || luna == 0) {
			
			System.out.println("Cifrele ce codifica luna sunt " + luna + "\n");
			return false;
		}
	
		return true;
	}
	
	
	Boolean isCifraZiua(String str)
	{
		
		int ziua = convertireCifre(str.charAt(5),str.charAt(6));
		
		if(ziua > 31 || ziua == 0) {
			
			System.out.println("Cifrele ce codifica ziua sunt " + ziua  + "\n");

			return false;
		}
		
		return true;
	}
	
	
	void calculareVarsta(String str)
	{
		
		Calendar dataNasterii = Calendar.getInstance();
		Calendar dataCurenta = Calendar.getInstance();
		
		int cifraSex = Character.getNumericValue(str.charAt(0));

		int ziua = convertireCifre(str.charAt(5),str.charAt(6));
		int luna = convertireCifre(str.charAt(3),str.charAt(4));
		int an = convertireCifre(str.charAt(1),str.charAt(2));
		
		if(cifraSex == 1 || cifraSex == 2) {
			an += 1900;
		}else if(cifraSex == 5 || cifraSex == 6) {
			an += 2000;
		}
		
		dataNasterii.set(an, luna, ziua);
		
		long millis = dataCurenta.getTimeInMillis()  - dataNasterii.getTimeInMillis();
		long ani = millis / 31536000000L;
		

		System.out.println("\nData nasterii \nZiua :  " + ziua + "\nLuna : " + luna + "\nAn : " + an);
		System.out.println("\nVarsta : " + ani + " ani");
	}
	
	
	private static int convertireCifre(char char1, char char2)
	{
		int primaCifra = Character.getNumericValue(char1);
		int aDouaCifra = Character.getNumericValue(char2);
		
		
		return primaCifra *10 + aDouaCifra;	
	}
}