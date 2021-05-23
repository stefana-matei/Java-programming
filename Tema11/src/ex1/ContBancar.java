package ex1;

public class ContBancar {

	
	private int sumaCont;
	
	
	public ContBancar(int sumaCont)
	{
		this.sumaCont = sumaCont;
	}
	
	
	public synchronized void extragere(int sumaExtrasa)
	{
		
		while (sumaExtrasa > this.sumaCont) {
			
			try {
				
				wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			
		}
		
		
		if (sumaExtrasa <= this.sumaCont) {
			
			this.sumaCont -= sumaExtrasa;
			System.out.printf("\n-- A fost extrasa suma de " + sumaExtrasa + " RON si in cont au ramas " + sumaCont +" RON\n");
		}
		
		notify();
	}
	
	
	public synchronized void depunere(int sumaDepusa)
	{
		
		this.sumaCont += sumaDepusa;
		System.out.printf("\n++ A fost depusa suma de " + sumaDepusa + " RON, in cont sunt : " + sumaCont + " RON\n");
		notify();
	}

}