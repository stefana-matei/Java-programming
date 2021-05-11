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

	
	public String getNume() 
	{
		return nume;
	}

	
	public void setNume(String nume) 
	{
		this.nume = nume;
	}

	
	public String getPost() 
	{
		return post;
	}

	
	public void setPost(String post) 
	{
		this.post = post;
	}

	
	public LocalDate getDataAngajarii() 
	{
		return dataAngajarii;
	}

	
	public void setDataAngajarii(LocalDate dataAngajarii) 
	{
		this.dataAngajarii = dataAngajarii;
	}

	
	public Float getSalariul() 
	{
		return salariul;
	}

	
	public void setSalariul(Float salariul) 
	{
		this.salariul = salariul;
	}

	
	public String toString() {
		return "Nume : " + this.nume + "\nPost : " + this.post + "\nData angajarii : "
				+ this.dataAngajarii.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\nSalariul : "
				+ this.salariul;
	}
}