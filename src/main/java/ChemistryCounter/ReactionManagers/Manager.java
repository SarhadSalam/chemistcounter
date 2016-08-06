/*
 * Copyright (c) 2016. Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued..
 */

package ChemistryCounter.ReactionManagers;

import ChemistryCounter.Exceptions.ElementNotFoundException;
import ChemistryCounter.Exceptions.ReactionElementNotMatchedException;
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
		String input = "H2+O2=H2O";
		balance(input);
	}

	private static UniversalGetters balance(String input)
	{

		try
		{
			UniversalGetters splitReaction = findElementInReactions(ManageReactions.splitReactions(input));
			return ManageReactions.setMatrix(splitReaction);
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

		verification(reactant, product);

		universal.setCn(product, reactant);
		universal.setReactionCompounds(compoundsArrayList);
		return universal;
	}

	private static void verification(ArrayList<ChemicalName> reactant, ArrayList<ChemicalName> product)
	{
		//		Checks if they are equal and same
		if( reactant.size() != product.size() )
		{
			try
			{
				throw new ReactionElementNotMatchedException();
			} catch( ReactionElementNotMatchedException e )
			{
				e.printStackTrace();
			}
		} else
		{
			for( int i = 0; i<reactant.size(); i++ )
			{
				if( !reactant.get(i).getChemicalSymbol().equals(product.get(i).getChemicalSymbol()) )
				{
					try
					{
						throw new ReactionElementNotMatchedException();
					} catch( ReactionElementNotMatchedException e )
					{
						e.printStackTrace();
					}
				}
			}
		}
	}

}
