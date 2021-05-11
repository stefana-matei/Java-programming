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
		return "Nume : " + this.nume + "\nPost : " + this.post + "\nData angajarii : "
				+ this.dataAngajarii.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\nSalariul : "
				+ this.salariul;
	}
}