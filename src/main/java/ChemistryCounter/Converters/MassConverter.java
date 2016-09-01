/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.Converters;

/**
 * Class Details:-
 * Author: Sarhad
 * User: sarha
 * Date: 02-Sep-16
 * Time : 2:15 AM
 * Project Name: chemistsCounter
 * Class Name: MassConverters
 *
 * The Class responsible for mass conversions.
 */
public class MassConverter
{
	
	/**
	 * Find the operation to convert it to.
	 *
	 * @param massUnit The mass unit to be determined.
	 * @param mass     The mass in Double.
	 *
	 * @return Returns the proper mass.
	 */
	public static Double findOperation(String massUnit, Double mass)
	{
//		The switch statement starts at char at 0. The Kilogram for e.g. is k.
		switch( massUnit.charAt(0) )
		{
			case 'K':
				return kgToGram(mass);
			case 'G':
				return mass;
//			In case it's M, there is Micro or Milli therefore another nested switch statement.
			case 'M':
				switch( massUnit.charAt(2) )
				{
					case 'c':
						return microToGram(mass);
					case 'l':
						return mgToGram(mass);
					default:
						return mass;
				}
			case 'N':
				return nanoToGram(mass);
			default:
				return mass;
		}
	}
	
	/**
	 * Converts kg to gram.
	 * @param mass  The mass.
	 * @return  mass in grams.
	 */
	private static Double kgToGram(Double mass)
	{
		return mass*1e3;
	}
	
	/**
	 * Converts milligram to gram.
	 * @param mass  The mass.
	 * @return mass in grams.
	 */
	private static Double mgToGram(Double mass)
	{
		return mass/1e-3;
	}
	
	/**
	 * Converts nanogram to gram.
	 * @param mass The mass.
	 * @return  mass in grams.
	 */
	private static Double nanoToGram(Double mass)
	{
		return mass/1e-9;
	}
	
	/**
	 * Converts microgram to gram.
	 * @param mass The mass.
	 * @return mass in grams.
	 */
	private static Double microToGram(Double mass)
	{
		return mass/1e-6;
	}
}
