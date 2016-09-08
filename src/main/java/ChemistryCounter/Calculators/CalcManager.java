/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.Calculators;

import ChemistryCounter.Exceptions.CalculatorNotFoundException;

/**
 * Class Details:-
 * Author: Sarhad
 * User: sarha
 * Date: 19-Aug-16
 * Time : 6:55 PM
 * Project Name: chemistsCounter
 * Class Name: CalcManager
 * <p>
 * The CalcManager class gets what the calculation operation should do.
 */
public class CalcManager
{
	
	/**
	 * The method calcManager verifies if any such calculator exists.
	 * @param tag   The calculator name
	 * @return  Boolean
	 * @throws CalculatorNotFoundException  If no CalculatorWasFound
	 */
	public static Boolean calcManager(String tag) throws CalculatorNotFoundException
	{
		if( ( tag.equals("Percentage Composition") ) || tag.equals("Molar Mass") )
		{
			return false;
		} else if( ( tag.equals("Mole") ) )
		{
			return true;
		}
		throw new CalculatorNotFoundException("Not Found Any Such Calculators.");
	}
}
