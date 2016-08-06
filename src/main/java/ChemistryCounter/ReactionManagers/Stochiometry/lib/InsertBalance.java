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

			if( !(u.getReactant().get(i).getReactionBalance() == 1)||!(u.getProduct().get(i).getReactionBalance() == 1) )
			{
				reactant = reactant+u.getReactant().get(i).getReactionBalance()+u.getReactant().get(i).getChemicalSymbol();
				product = product+u.getProduct().get(i).getReactionBalance()+u.getProduct().get(i).getChemicalSymbol();
			} else
			{
				reactant = reactant+u.getReactant().get(i).getChemicalSymbol();
				product = product+u.getProduct().get(i).getChemicalSymbol();
			}
		}
		String equation = reactant+"="+product;
		return equation;
	}

	public static String equations(UniversalGetters u, String input)
	{
		input = input.replaceAll("\\s", "");
		return null;
	}
}
