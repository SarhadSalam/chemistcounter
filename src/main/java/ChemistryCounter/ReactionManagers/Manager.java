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
import ChemistryCounter.SingleManager.Summoner;
import ChemistryCounter.UniversalGetters;

import java.util.ArrayList;

/**
 * Created by sarhaD on 27-Jun-16.
 * <p>
 * This class Manager is the reaction manager algorithm. It forwards on the user input to ManageReactions. This class is
 * built on several classes. I am not going to mention all classes which were built from here.
 *
 * @see ManageReactions
 */
public class Manager
{
	
	/**
	 * The method will be deleted cause its main. It's used for only dev purposes.
	 *
	 * @param args The main args
	 */
	public static void main(String[] args)
	{
		String[] sample = {"KI + KClO3 + HCl = I2H + H2O + KCl", "Na+Cl2=NaCl", "C2+O2->CO2", "C2+O2->CO", "FeS2 + HNO3 = Fe2(SO4)3 + NO + H2SO4"};
		System.out.println("Unbalanced Equation: "+sample[1]);
		
		String balanced;
		try
		{
			balanced = balance(sample[1]);
			System.out.println("Balanced Equation: "+balanced);
		} catch( ReactionElementNotMatchedException|ReactionNotBalancableException|ElementNotFoundException e )
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * The method balance balances the equation with the help of matrices.
	 *
	 * @param input The user input
	 *
	 * @return equation
	 *
	 * @throws ReactionElementNotMatchedException Reaction cannot be matched with the given elements and compounds.
	 * @throws ReactionNotBalancableException     Reaction cannot be balanced.
	 * @throws ElementNotFoundException           Element wasn't found in the periodic table.
	 * @see ManageReactions
	 */
	private static String balance(String input) throws ReactionElementNotMatchedException, ReactionNotBalancableException, ElementNotFoundException
	{
//		The real logic
		UniversalGetters splitReaction = findElementInReactions(ManageReactions.splitReactions(input));
		Double[] d = ManageReactions.setMatrix(splitReaction);

//		The beautify and return
		return BeautifyReaction.balancedEquation(splitReaction, d);
	}
	
	/**
	 * The method findElementInReactions below finds elements in a reaction with the help of the summoner class.
	 *
	 * @param compoundsArrayList The array list containing compound.
	 *
	 * @return universal
	 *
	 * @throws ElementNotFoundException           Element wasn't found in the periodic table.
	 * @throws ReactionElementNotMatchedException Element and or Compound weren't matched.
	 * @see Summoner
	 */
	private static UniversalGetters findElementInReactions(ArrayList<ReactionCompounds> compoundsArrayList) throws ElementNotFoundException, ReactionElementNotMatchedException
	{
		UniversalGetters universal = new UniversalGetters();
		ArrayList<ChemicalName> reactant = Summoner.summoner(ManageReactions.getReactant);
		ArrayList<ChemicalName> product = Summoner.summoner(ManageReactions.getProduct);
		
		verification(reactant, product);
		
		universal.setCn(product, reactant);
		universal.setReactionCompounds(compoundsArrayList);
		return universal;
	}
	
	/**
	 * The method  verification verifies whether the reactions are properly parsed.
	 *
	 * @param reactant The reactant
	 * @param product  The product
	 *
	 * @throws ReactionElementNotMatchedException Reaction cannot be matched with the given elements and compounds.
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
