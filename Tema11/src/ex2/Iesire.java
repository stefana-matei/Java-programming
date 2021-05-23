package ex2;

public class Iesire extends Thread {
	
	private Parcare parcare;
	
	
	public Iesire(Parcare parcare)
	{
		this.parcare = parcare;
	}
	
	
	public void run()
	{
		
		for(int i = 0; i < 4; i++) {
			
			parcare.iesire();
		}
	}

}
