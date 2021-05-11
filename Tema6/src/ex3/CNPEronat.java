package ex3;

public class CNPEronat extends Exception {

	
	private static final long serialVersionUID = 3953354454746367200L;
	
	
	private String CNP;
	
	
	public CNPEronat(String mesaj, String CNP)
	{
		super(mesaj);
		this.CNP = CNP;
	}

	
	public String getCNP() 
	{
		return CNP;
	}
}