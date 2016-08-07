/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.SingleManager.Cleaners;

import java.math.BigDecimal;

/**
 * Created by sarhaD on 29-May-16.
 * <p>
 * This returns numbers in scientific notations
 */
public class ScientificNotation
{
	/**
	 * The method below converts and sets in scientific notation.
	 *
	 * @param input The input converts user input to big decimal
	 * @return in Scientific Notation.
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
