/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.SingleManager.Cleaners;

import java.math.BigDecimal;

/**
 * Created by sarhaD on 29-May-16.
 */
public class SignificantFigures
{
	public static int decimalPlaces = 0;

	public static int roundingFigures(BigDecimal userInput)
	{
//		Converts to string for count
		String input = userInput.stripTrailingZeros().toPlainString();
		int count = input.length();
//		The position of a decimal
		int position = 0;

//		Counts the entire length
		for( int i = 0; i<count; i++ )
		{
			char c = input.charAt(i);
			if( c == '.' )
			{
				position = i;
				count = count-1;
			}
		}

//		Counts number of decimal places
		if( position != 0 )
		{
			for( int i = position; i<count; i++ )
			{
				decimalPlaces = decimalPlaces+1;
			}
		}
		return count;
	}
}
