/*
 * Copyright (c) 2016. Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued..
 */

package ChemistryCounter.ReactionManagers;

import ChemistryCounter.ReactionManagers.ReactionDetector.ManageReactions;
import ChemistryCounter.ReactionManagers.Stochiometry.EquationBalancer;
import ChemistryCounter.ReactionManagers.Stochiometry.lib.InsertBalance;
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
	public static void main(String[] args)
	{
		String input = "H21 + O2 -> H2O";
		UniversalGetters balanced = balance(input);
//		The old system
		String s = InsertBalance.insertBalance(balanced);
		String eq = InsertBalance.equations(balanced, input);
	}

	private static UniversalGetters balance(String input)
	{
		try
		{
			UniversalGetters u = findElementInReactions(ManageReactions.splitReactions(input));
			return ManageReactions.setMatrix(u);
		} catch( NullPointerException e )
		{
			throw new NullPointerException();
		}
	}

	private static UniversalGetters findElementInReactions(ArrayList<ReactionCompounds> compoundsArrayList)
	{
		UniversalGetters universal = new UniversalGetters();
		ArrayList<ChemicalName> reactant = Summoner.summoner(ManageReactions.getReactant);
		ArrayList<ChemicalName> product = Summoner.summoner(ManageReactions.getProduct);
		universal.setCn(product, reactant);
		universal.setReactionCompounds(compoundsArrayList);
		return universal;
	}

}
