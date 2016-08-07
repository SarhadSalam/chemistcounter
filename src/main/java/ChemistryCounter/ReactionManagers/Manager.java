/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.ReactionManagers;

import ChemistryCounter.Exceptions.ElementNotFoundException;
import ChemistryCounter.Exceptions.ReactionElementNotMatchedException;
import ChemistryCounter.Exceptions.ReactionNotBalancableException;
import ChemistryCounter.ReactionManagers.ReactionDetector.BeautifyReaction;
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
	/**
	 * The method will be deleted cause its main lel.
	 *
	 * @param args The main args
	 */
	public static void main(String[] args)
	{
		String[] samples = {"KI + KClO3 + HCl = I2H + H2O + KCl", "H2F+O2=H2OF", "Na+Cl=NaCl", "C2+O2->CO2", "C2+O2->CO", "FeS2 + HNO3 = Fe2(SO4)3 + NO + H2SO4"};
		String working = "H2+2O2= 2H2O";

		System.out.println("Unbalanced: "+working);

		String balanced = null;
		try
		{
			balanced = balance(working);
		} catch( ReactionElementNotMatchedException|ReactionNotBalancableException e )
		{
			e.printStackTrace();
		}

		System.out.println("Balanced: "+balanced);
	}

	/**
	 * The method balances the equation.
	 *
	 * @param input The user input
	 * @return equation
	 * @throws ReactionElementNotMatchedException	Reaction cannot be matched with the given elements and compounds.
	 * @throws ReactionNotBalancableException	Reaction cannot be balanced.
	 */
	private static String balance(String input) throws ReactionElementNotMatchedException, ReactionNotBalancableException
	{
//		The real logic
		UniversalGetters splitReaction = findElementInReactions(ManageReactions.splitReactions(input));
		Double[] d = ManageReactions.setMatrix(splitReaction);

//		The beautify
		String equation = BeautifyReaction.balancedEquation(splitReaction, d);

		return equation;
	}

	/**
	 * The method below finds elements in a reaction.
	 *
	 * @param compoundsArrayList The array list containing compound.
	 * @return universal
	 */
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

		try
		{
			verification(reactant, product);
		} catch( ReactionElementNotMatchedException e )
		{
			e.printStackTrace();
		}

		universal.setCn(product, reactant);
		universal.setReactionCompounds(compoundsArrayList);
		return universal;
	}

	/**
	 * The method verifies whether the reactions are properly parsed.
	 *
	 * @param reactant The reactant
	 * @param product  The product
	 * @throws ReactionElementNotMatchedException	Reaction cannot be matched with the given elements and compounds.
	 */
	private static void verification(ArrayList<ChemicalName> reactant, ArrayList<ChemicalName> product) throws ReactionElementNotMatchedException
	{
		//		Checks if they are equal and same
		if( reactant.size() != product.size() )
		{
			throw new ReactionElementNotMatchedException("The elements in the reactants and products do not match.");

		} else
		{
			for( int i = 0; i<reactant.size(); i++ )
			{
				if( !reactant.get(i).getChemicalSymbol().equals(product.get(i).getChemicalSymbol()) )
				{
					throw new ReactionElementNotMatchedException("The elements in the reactants are different from the products.");
				}
			}
		}
	}

}
