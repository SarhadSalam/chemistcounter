/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.SingleManager.Cleaners;

import java.math.BigDecimal;

/**
 * Created by sarhaD on 29-May-16.
 * <p>
 * The class ScientificNotation converts the input to scientific notation.
 */
public class ScientificNotation
{
	
	/**
	 * The method below converts a normal input into scientific notation.
	 *
	 * @param input The input to be converted to user input to big decimal
	 *
	 * @return BigDecimal(input)  the Big Decimal is inputted in Scientific Notation.
	 */
	public static BigDecimal convertUserInput(String input)
	{
		if( input.contains("^") )
		{
			input = input.replaceAll("[\\^]", "e");
		}
		return new BigDecimal(input);
	}
}
