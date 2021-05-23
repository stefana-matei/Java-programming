package ex1;

public class Depunere extends Thread {
	
	private ContBancar contBancar;
	
	
	public Depunere(ContBancar contBancar)
	{
		this.contBancar = contBancar;
	}
	
	
	public void run()
	{
		int sumaDepusa = 0;
		
		
		while (true) {
			
			sumaDepusa = (int) (Math.random() * 1000);
			contBancar.depunere(sumaDepusa);
			
			try {
				
				sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
}