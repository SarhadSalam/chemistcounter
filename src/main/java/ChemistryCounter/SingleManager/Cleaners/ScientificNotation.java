package ChemistryCounter.SingleManager.Cleaners;

import java.math.BigDecimal;

/**
 * Created by sarhaD on 29-May-16.
 * <p>
 * This returns numbers in scientific notations
 */
public class ScientificNotation
{
	public static BigDecimal convertUserInput(String input)
	{
		int caretPosition = 0;
		if( input.contains("^") )
		{
			input = input.replaceAll("[\\^]", "e");
		}
		BigDecimal bd = new BigDecimal(input);
		System.out.println(bd);
		return bd;
	}
}
