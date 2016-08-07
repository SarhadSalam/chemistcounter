/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.ReactionManagers.Stochiometry.lib;

import ChemistryCounter.UniversalGetters;

/**
 * Class Details:-
 * Author: Sarhad
 * User: sarha
 * Date: 04-Jul-16
 * Time : 2:17 AM
 * Project Name: chemistsCounter
 * Class Name: InsertBalance
 */
public class InsertBalance
{
	/**
	 * This method inserts the balance.
	 *
	 * @param u UniversalGetters u which is the universal get and set.
	 * @return equation
	 * @see ChemistryCounter.ReactionManagers.ReactionDetector.ManageReactions
	 * @deprecated insertBalance is no longer used since 1.0-ALPHA.
	 */
	public static String insertBalance(UniversalGetters u)
	{
//		All error handling was done before so now I can just implement new methods directly.
		String reactant = "";
		String product = "";
		for( int i = 0; i<u.getReactant().size(); i++ )
		{

//			This is just extra case in case I screw up, cause you know I screw up. Code screws up. Life sometimes is not fair.
			if( !u.getReactant().get(i).getChemicalSymbol().equals(u.getProduct().get(i).getChemicalSymbol()) )
			{
				return null;
			}

			reactant = reactant+u.getReactant().get(i).getChemicalSymbol();
			product = product+u.getProduct().get(i).getChemicalSymbol();

		}
		String equation = reactant+"="+product;
		return equation;
	}

	/**
	 * @param u     The universalgetter is passed to remove the spaces
	 * @param input the user input
	 * @return null
	 * @see ChemistryCounter.ReactionManagers.ReactionDetector.ManageReactions
	 * @deprecated no longer used since 1.0-ALPHA
	 */
	public static String equations(UniversalGetters u, String input)
	{
		input = input.replaceAll("\\s", "");
		return null;
	}
}
