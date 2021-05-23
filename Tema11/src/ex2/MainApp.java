package ex2;

public class MainApp {

	public static void main(String[] args) {
		
		Parcare parcare = new Parcare(10, 0);
		Intrare intrare1 = new Intrare(parcare, 1);
		Intrare intrare2 = new Intrare(parcare, 2);
		Intrare intrare3 = new Intrare(parcare, 3);
		Iesire iesire = new Iesire(parcare);
		
		
		intrare1.start();
		intrare2.start();
		intrare3.start();
		iesire.start();
		
		System.out.printf("GATA MAIN");
	}

}
