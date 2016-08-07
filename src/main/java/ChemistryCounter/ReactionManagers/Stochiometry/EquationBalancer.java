/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.ReactionManagers.Stochiometry;

import ChemistryCounter.Exceptions.ReactionElementNotMatchedException;
import ChemistryCounter.ReactionManagers.Stochiometry.lib.GetLCM;
import ChemistryCounter.UniversalGetters;

/**
 * Created by sarhaD on 30-Jun-16.
 */
public class EquationBalancer
{
	public static UniversalGetters balanceEquation(UniversalGetters u) throws ReactionElementNotMatchedException
	{

		u = GetLCM.getLCM(u);
		return u;

	}

}
