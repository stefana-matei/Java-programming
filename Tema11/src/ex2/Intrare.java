package ex2;

public class Intrare extends Thread {
	
	private int intrare;
	private Parcare parcare;
	
	
	public Intrare(Parcare parcare, int intrare)
	{
		this.parcare = parcare;
		this.intrare = intrare;
	}
	
	
	public void run()
	{
		
		for(int i = 0; i < 3; i++) {
			
			parcare.intrare(intrare);
		}
	}
}
