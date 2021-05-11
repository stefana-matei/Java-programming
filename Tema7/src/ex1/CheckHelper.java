package ex1;

public class CheckHelper {

	
	public static void isEmpty(String str) throws NumericException 
	{
		if (str.isEmpty() || str == null) {
			throw new NumericException("\nExceptie : valoare lipsa!");
		}
	}

	
	public static void checkZero(String str) throws NumericException 
	{

		if (Integer.parseInt(str) == 0) 
		{
			throw new NumericException("\nEroare : nu se poate face impartire la zero!");
		}

	}
}
