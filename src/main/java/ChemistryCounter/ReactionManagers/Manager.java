/*
 * Copyright (c) 2016. Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued..
 */

package ChemistryCounter.ReactionManagers;

import ChemistryCounter.DevelopmentPurposes.TestingPrint;
import ChemistryCounter.Exceptions.ElementNotFoundException;
import ChemistryCounter.ReactionManagers.ReactionDetector.ManageReactions;
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
		String input = "H2+O2=H";
		UniversalGetters balanced = balance(input);
	}

	private static UniversalGetters balance(String input)
	{

		try
		{
			UniversalGetters splitReaction = findElementInReactions(ManageReactions.splitReactions(input));
			UniversalGetters solveEquations = ManageReactions.setMatrix(splitReaction);
			return solveEquations;
		} catch( NullPointerException e )
		{
			throw new NullPointerException();
		}
	}

	private static UniversalGetters findElementInReactions(ArrayList<ReactionCompounds> compoundsArrayList)
	{
		UniversalGetters universal = new UniversalGetters();
		ArrayList<ChemicalName> reactant = null;
		ArrayList<ChemicalName> product = null;
		try
		{
			reactant = Summoner.summoner(ManageReactions.getReactant);
			product = Summoner.summoner(ManageReactions.getProduct);
		} catch( ElementNotFoundException e )
		{
			e.printStackTrace();
		}

//		Checks if they are equal and same

		universal.setCn(product, reactant);
		universal.setReactionCompounds(compoundsArrayList);
		return universal;
	}

}
