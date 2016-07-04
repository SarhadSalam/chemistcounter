package ChemistryCounter.ReactionManagers.Stochiometry;

import ChemistryCounter.ReactionManagers.Stochiometry.lib.GetLCM;
import ChemistryCounter.ReactionManagers.Stochiometry.lib.InsertBalance;
import ChemistryCounter.UniversalGetters;

/**
 * Created by sarhaD on 30-Jun-16.
 */
public class EquationBalancer
{
	public static String balanceEquation(UniversalGetters u)
	{
		try
		{
			u = GetLCM.getLCM(u);
			return InsertBalance.insertBalance(u);
		} catch( NullPointerException e )
		{
			throw new NullPointerException();
		}
	}

}
