package ChemistryCounter.ReactionManagers.Stochiometry;

import ChemistryCounter.UniversalGetters;
import com.google.common.math.IntMath;

/**
 * Created by sarhaD on 30-Jun-16.
 */
public class EquationBalancer
{
	public static UniversalGetters balanceEquation(UniversalGetters u)
	{
		try{
			u = getLCM(u);
			return u;
		}
		catch( NullPointerException e)
		{
			throw new NullPointerException();
		}
	}

	private static UniversalGetters getLCM(UniversalGetters u)
	{
		int productAtom,reactantAtom;

		for( int i = 0; i<u.getReactant().size(); i++ )
		{
			productAtom = u.getReactant().get(i).getValenceElectron();
			reactantAtom = u.getProduct().get(i).getValenceElectron();

			int max, min;
			boolean productMax;

			if( productAtom>reactantAtom )
			{
				max = productAtom;
				min = reactantAtom;
				productMax = true;
			} else
			{
				max = reactantAtom;
				min = productAtom;
				productMax = false;
			}

			int gcd = IntMath.gcd(max, min);
			int minTemp = min;

//			This deals if there are other compounds that are not in the equation.

			if( !u.getReactant().get(i).getChemicalName().equals(u.getProduct().get(i).getChemicalName()) )
			{
				throw new NullPointerException();
			}

//			Well cause the lcm is max*min divided by the gcd
			min = (max*min)/gcd;
			max = (max*minTemp)/gcd;
			u.getProduct().get(i).reactionsRelation = true;
			u.getReactant().get(i).reactionsRelation = true;
			if( productMax )
			{
				u.getProduct().get(i).setReactionBalance(max);
				u.getReactant().get(i).setReactionBalance(min);
			} else
			{
				u.getReactant().get(i).setReactionBalance(max);
				u.getProduct().get(i).setReactionBalance(min);
			}
		}
		return u;
	}
}
