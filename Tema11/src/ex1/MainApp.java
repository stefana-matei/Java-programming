package ex1;

public class MainApp {

	public static void main(String[] args) {

		ContBancar contBancar = new ContBancar(0);
		Depunere depunere = new Depunere(contBancar);
		Extragere extragere = new Extragere(contBancar);
		
		
		depunere.start();
		extragere.start();
	}
}