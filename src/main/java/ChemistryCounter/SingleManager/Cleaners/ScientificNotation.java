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
		if( input.contains("^") )
		{
			input = input.replaceAll("[\\^]", "e");
		}
		return new BigDecimal(input);
	}
}
