package ex1;

public class Extragere extends Thread {

	private ContBancar contBancar;
	
	
	public Extragere(ContBancar contBancar)
	{
		this.contBancar = contBancar;
	}
	
	
	public void run()
	{
		int sumaExtrasa = 0;
		
		while(true) {
			
			sumaExtrasa = (int) (Math.random() * 1000);
			contBancar.extragere(sumaExtrasa);
			
			try {
				
				sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
}
