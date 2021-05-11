package ex2;

public class Carte {
	
	private String titlu,autor;
	private int anulAparitiei;
	
	
	public Carte(String titlu, String autor, int anulAparitiei)
	{
		this.titlu = titlu;
		this.autor = autor;
		this.anulAparitiei = anulAparitiei;
	}
	
	
	public String getTitlu()
	{
		return this.titlu;
	}
	
	
	public String getAutor()
	{
		return this.autor;
	}
	
	
	public int getAnulAparitiei()
	{
		return this.anulAparitiei;
	}
	
	
	public void setTitlu(String newTitlu)
	{
		this.titlu = newTitlu;
	}
	
	
	public void setAutor(String newAutor)
	{
		this.autor = newAutor;
	}
	
	
	public void setAn(int newAnAparitie)
	{
		this.anulAparitiei = newAnAparitie;
	}
	
	
	public String toString()
	{
		return "\nTitlul cartii : " + titlu + "\nNume autor : " + autor + "\nAn aparitie : " + anulAparitiei;
	}
}