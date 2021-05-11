package ex1;

public class NumericException extends Exception {

	private static final long serialVersionUID = -7414879991188956577L;

	public NumericException(String mesaj) 
	{
		super(mesaj);
	}
	
	
	public String toString()
	{
		return this.getMessage();
	}
}