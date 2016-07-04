/*
 * Copyright (c) 2016. Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued..
 */

package ChemistryCounter.ReactionManagers;

import ChemistryCounter.ReactionManagers.ReactionDetector.ManageReactions;
import ChemistryCounter.ReactionManagers.Stochiometry.EquationBalancer;
import ChemistryCounter.SingleManager.ElementDetector.Universal.ChemicalName;
import ChemistryCounter.Summoner;
import ChemistryCounter.UniversalGetters;

import java.util.ArrayList;

/**
 * Created by sarhaD on 27-Jun-16.
 * <p>
 * This is the reaction manager algorithm.
 */
public class Manager
{
	public static String mixedName = "";
	public static String reactants = "";
	public static String products = "";

	public static void main(String[] args)

	{
		String input = "H=H10N4FCa21";
		try
		{
			UniversalGetters u = findElementInReactions(ManageReactions.manageReactions(input));
			 u = EquationBalancer.balanceEquation(u);
		}
		catch( NullPointerException e )
		{
			System.out.println("There is something wrong with this equation. Please check it.");
			throw new NullPointerException();
		}
	}

	private static UniversalGetters findElementInReactions(ArrayList<ReactionCompounds> compoundsArrayList)
	{
		mixedName = products + reactants;
		UniversalGetters universal = new UniversalGetters();
		ArrayList<ChemicalName> product = Summoner.summoner(products);
		ArrayList<ChemicalName> reactant= Summoner.summoner(reactants);
		universal.setCn(product, reactant);
		universal.setReactionCompounds(compoundsArrayList);
		return universal;
	}

}
