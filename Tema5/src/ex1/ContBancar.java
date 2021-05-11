package ex1;

import java.util.Calendar;

public class ContBancar implements Operatiuni {

	private String numarCont;
	private float suma;
	private String moneda;
	private Calendar data_deschiderii;
	private Calendar data_ultimei_operatiuni;

	
	public ContBancar(String numarCont, float suma, String moneda, Calendar data_deschiderii, Calendar data_ultimei_operatiuni) 
	{
		this.numarCont = numarCont;
		this.suma = suma;
		this.moneda = moneda;
		this.data_deschiderii = data_deschiderii;
		this.data_ultimei_operatiuni = data_ultimei_operatiuni;
	}

	
	public String getNumarCont() 
	{
		return numarCont;
	}

	
	public float getSuma() 
	{
		return suma;
	}

	
	public String getMoneda() 
	{
		return moneda;
	}

	
	public Calendar getDataDeschiderii() 
	{
		return data_deschiderii;
	}

	
	public Calendar getDataUltimeiOperatiuni() 
	{
		return data_ultimei_operatiuni;
	}

	
	public String toString() 
	{
		return "Numar cont : " + numarCont + " Suma : " + suma + " Moneda : " + moneda + " Data deschiderii : "
				+ data_deschiderii.get(Calendar.DAY_OF_MONTH) + "." + (data_deschiderii.get(Calendar.MONTH) + 1) + "."
				+ data_deschiderii.get(Calendar.YEAR) + " Data ultimei operatiuni : "
				+ data_ultimei_operatiuni.get(Calendar.DAY_OF_MONTH) + "."
				+ (data_ultimei_operatiuni.get(Calendar.MONTH) + 1) + "." + data_ultimei_operatiuni.get(Calendar.YEAR);
	}

	
	public float calculeaza_dobanda() 
	{
		
		float dobanda = 0;

		long millis = Calendar.getInstance().getTimeInMillis()  - data_ultimei_operatiuni.getTimeInMillis();
		long zile = millis / 86400000;

		switch (moneda) {

		case "RON":

			if (suma < 500)
				dobanda = (float) (0.3 * zile);
			else
				dobanda = (float) (0.8 * zile);

			break;

			
		case "EUR":

			dobanda = (float) (0.1 * zile);

			break;

			
		default:
			System.out.println("\nNu exista aceasta moneda, se accepta doar RON si EUR!");
			break;
		}

		
		return dobanda;
	}

	
	public float actualizare_suma() 
	{

		this.suma = this.suma + calculeaza_dobanda();
		data_ultimei_operatiuni = Calendar.getInstance();

		return this.suma;
	}

	
	public void depunere(float suma) 
	{
		this.actualizare_suma();
		this.suma = this.suma + suma;
		data_ultimei_operatiuni = Calendar.getInstance();
	}

	
	public void extragere(float suma) 
	{
		this.actualizare_suma();
		this.suma = this.suma - suma;
		data_ultimei_operatiuni = Calendar.getInstance();
	}
}