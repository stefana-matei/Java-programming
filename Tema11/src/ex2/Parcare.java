package ex2;

public class Parcare {

	private int capacitateParcare;
	private int numarLocuriOcupate;

	
	public Parcare(int numarTotalLocuri, int numarLocuriOcupate) 
	{
		this.capacitateParcare = numarTotalLocuri;
		this.numarLocuriOcupate = numarLocuriOcupate;
	}

	
	public synchronized void iesire() 
	{
		
		if(this.numarLocuriOcupate <= 0) {
			
			try {
				
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
			
		this.numarLocuriOcupate--;
		System.out.printf("\n- A iesit o masina. In parcare sunt " + numarLocuriOcupate + " masini\n");
		notify();
	}

	
	public synchronized void intrare(int intrare) 
	{

		while (this.numarLocuriOcupate >= capacitateParcare) {

			try {
				
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}

		this.numarLocuriOcupate++;
		System.out.printf("\n+ A intrat o masina pe intrarea " + intrare + ". In parcare sunt " + numarLocuriOcupate
					+ " masini.\n");
		notify();
	}
}