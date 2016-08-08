/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.ReactionManagers.Stochiometry.lib;

import ChemistryCounter.Exceptions.ReactionElementNotMatchedException;
import ChemistryCounter.UniversalGetters;
import com.google.common.math.IntMath;

/**
 * Class Details:-
 * Author: Sarhad
 * User: sarha
 * Date: 04-Jul-16
 * Time : 2:15 AM
 * Project Name: chemistsCounter
 * Class Name: GetLCM
 * The class GetLCM gets the LCM. The class is currently deprecated.
 *
 * @deprecated
 */
public class GetLCM
{
	
	/**
	 * The method getLCM below gets the LCM.
	 * <p>
	 * Euclid's way of getting LCM is used.
	 *
	 * @param u The universal getters and setters
	 *
	 * @return UniversalGetters
	 *
	 * @throws ReactionElementNotMatchedException Reaction cannot be matched with the given elements and compounds.
	 * @deprecated The method presently is useless.
	 */
	public static UniversalGetters getLCM(UniversalGetters u) throws ReactionElementNotMatchedException
	{
		int productAtom, reactantAtom;
		
		if( u.getProduct().size() != u.getReactant().size() )
		{
			throw new ReactionElementNotMatchedException();
		}
		
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
				throw new ReactionElementNotMatchedException();
			}
			
			//			Well cause the lcm is max*min divided by the gcd
			min = ( max*min )/gcd;
			max = ( max*minTemp )/gcd;
		}
		return u;
	}
}
