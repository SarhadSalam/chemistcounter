/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.Tools;

import java.math.BigDecimal;

/**
 * Created by sarhaD on 29-May-16.
 * <p>
 * The significant figures is set in the SignificantFigures class.
 */
public class SignificantFigures
{
	private static int decimalPlaces = 0;
	
	/**
	 * The method below rounds figures and sets rounding figures after any operation such as Multiplication or Division.
	 *
	 * @param userInput The significant figures are managed by a huge user input.
	 *
	 * @return count The rounding in significant figures.
	 */
	public static int roundingFigures(BigDecimal userInput)
	{
//		Converts to string for count
		String input = userInput.stripTrailingZeros().toPlainString();
		int count = input.length();
		count = getCount(input, count);
		return count;
	}
	
	/**
	 * The method below rounds figures and sets rounding figures after any operation such as Multiplication or Division.
	 *
	 * @param userInput The significant figures are managed by a huge user input.
	 *
	 * @return count The rounding in significant figures.
	 */
	public static int roundingFigures(Double userInput)
	{
//		Converts to string for count
		String input = String.valueOf(userInput);
		int count = input.length();
		count = getCount(input, count);
		return count;
	}
	
	/**
	 * The count for sig figs is derived from here. Chillax mate.
	 * @param input Input
	 * @param count Count
	 * @return  int
	 */
	private static int getCount(String input, int count)
	{
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
