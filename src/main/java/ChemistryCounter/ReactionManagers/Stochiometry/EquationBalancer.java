/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.ReactionManagers.Stochiometry;

import ChemistryCounter.Exceptions.ReactionElementNotMatchedException;
import ChemistryCounter.ReactionManagers.Stochiometry.lib.GetLCM;
import ChemistryCounter.UniversalGetters;

/**
 * Created by sarhaD on 30-Jun-16.
 * <p>
 * The class EquationBalancer balanced equations which was solved using getting the lcm of certain numbers.
 *
 * @see ChemistryCounter.ReactionManagers.Manager
 * @deprecated
 */
public class EquationBalancer
{
	
	/**
	 * The method balances the equation
	 *
	 * @param u The universal getters and setters
	 *
	 * @return universal getters
	 *
	 * @throws ReactionElementNotMatchedException Reaction cannot be matched with the given input.
	 * @see ChemistryCounter.ReactionManagers.Manager
	 * @deprecated
	 */
	public static UniversalGetters balanceEquation(UniversalGetters u) throws ReactionElementNotMatchedException
	{
		u = GetLCM.getLCM(u);
		return u;
	}
	
}
