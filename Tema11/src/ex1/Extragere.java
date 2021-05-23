package ex1;

public class Extragere {

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
		}
	}
	
}
