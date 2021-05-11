package program;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Angajat {

	private String nume;
	private String post;
	private LocalDate dataAngajarii;
	private Float salariul;

	
	// constructor
	public Angajat(String nume, String post, LocalDate dataAngajarii, Float salariul) 
	{
		this.setNume(nume);
		this.setPost(post);
		this.setDataAngajarii(dataAngajarii);
		this.setSalariul(salariul);
	}

	
	//get nume
	public String getNume() 
	{
		return nume;
	}

	
	//set nume
	public void setNume(String nume) 
	{
		this.nume = nume;
	}

	
	//get post
	public String getPost() 
	{
		return post;
	}

	
	//set post
	public void setPost(String post) 
	{
		this.post = post;
	}

	
	//get dataAngajarii
	public LocalDate getDataAngajarii() 
	{
		return dataAngajarii;
	}

	
	//set dataAngajarii
	public void setDataAngajarii(LocalDate dataAngajarii) 
	{
		this.dataAngajarii = dataAngajarii;
	}

	
	//get salariul
	public Float getSalariul() 
	{
		return salariul;
	}

	
	//set salariul
	public void setSalariul(Float salariul) 
	{
		this.salariul = salariul;
	}

	
	//afisare date angajati
	public String toString() 
	{
		return this.nume + ", " + this.post + ", "
				+ this.dataAngajarii.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", "
				+ this.salariul + "\n";
	}
	
	
	//functie ce verifica daca angajatul are salariul mai mare decat o valoare data
	public boolean hasSalaryBiggerThan(float value)
	{
		return this.salariul > value;
	}
	
	
	//functie ce verifica daca stringul post contine "sef" sau "director"
	public boolean hasLeadingPosition()
	{
		return this.post.contains("Sef") || this.post.contains("Director");
	}
	
	
	//functie ce verifica daca luna angajarii e egala cu valorea data
	public boolean isMonthOfEmployment(int value)
	{
		return this.dataAngajarii.getMonthValue() == value;
	}
	
	
	//functie ce verifica daca anul angajarii e egal cu valoarea data
	public boolean isYearOfEmployment(int value)
	{
		return this.dataAngajarii.getYear() == value;
	}
}