/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.ReactionManagers.Stochiometry;

import ChemistryCounter.Exceptions.ElementNotFoundException;
import ChemistryCounter.Exceptions.ReactionElementNotMatchedException;
import ChemistryCounter.ReactionManagers.ReactionCompounds;
import ChemistryCounter.Universal.UniversalGetters;

import java.util.ArrayList;

/**
 * The class LimitingReagent is still in development. The class will temporarily will be discounted as I start working
 * on the android app.
 */

public class LimitingReagent
{
	
	/**
	 * The following method putInObject converts the name and mass inputted by the user into an Object[][].
	 * <p>
	 * The method is probably useless. Using the name and mass after sorting is probably a better choice.
	 *
	 * @param name The name of the limiting compounds
	 * @param mass The mass of the compounds.
	 *
	 * @return The details array containing the mass and name.
	 *
	 * @deprecated
	 */
	private static Object[][] putInObject(String[] name, Double[] mass)
	{
		Object[][] details = new Object[name.length][2];
		
		for( int i = 0; i<name.length; i++ )
		{
			details[i][0] = name[i];
			details[i][1] = mass[i];
		}
		return details;
	}
	
	/**
	 * The method findLimitingReagent  finds the limiting reagent in a reaction.
	 * <p>
	 * The method is still in development and incomplete.
	 *
	 * @param details The object contains the mass, name of several reactants. Object[x][y]  where x is the list of
	 *                products inputted by the user. Which is ignored cause who cares about the user lel. The y is the
	 *                mass and name.
	 * @param u       The universal getter.
	 * @throws ReactionElementNotMatchedException The Reaction Element was not matched.
	 * @throws  ElementNotFoundException The Element wasn't found.
	 * @return The universal getter with limiting reagent.
	 */
	public static UniversalGetters findLimitingReagent(Object[][] details, UniversalGetters u) throws ReactionElementNotMatchedException, ElementNotFoundException
	{
		ArrayList<Double> limitingReagent = new ArrayList<>();
		ArrayList<String> s = new ArrayList<>();
		for( ReactionCompounds rc : u.getReactionCompounds() )
		{
			if( rc.getCompoundStatus().equals("Reactant") )
			{
				s.add(rc.getName());
//				s.parallelStream().sorted(String::compareTo(rc.getName()));
//				if( String.valueOf(s.forEach()).equals(rc.getName()) || String.valueOf(s.stream().findAny()).equals(rc.getOriginalName()) )
//				{
//					System.out.println(true);
//					findMoleOfSpecificCompound((double) details[i][1], u, s.get(i));
//					System.out.println("LOL");
//				}
				
			}
		}
		
		if( details.length != s.size() )
		{
			throw new ReactionElementNotMatchedException("Reaction element not matched");
		}
		
		for( int i = 0; i<u.getReactionCompounds().size(); i++ )
		{
			ReactionCompounds rc = u.getReactionCompounds().get(i);
			
		}
		
		return u;
	}
}
