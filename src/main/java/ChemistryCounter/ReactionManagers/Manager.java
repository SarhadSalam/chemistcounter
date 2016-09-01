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
import ChemistryCounter.Universal.UniversalGetters;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
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
	 * The method balance balances the equation with the help of matrices.
	 *
	 * @param input The user input
	 *
	 * @return equation
	 *
	 * @throws ReactionElementNotMatchedException Reaction cannot be matched with the given elements and compounds.
	 * @throws ReactionNotBalancableException     Reaction cannot be balanced.
	 * @throws ElementNotFoundException           Element wasn't found in the periodic table.
	 * @throws IOException                        There is no files found.
	 * @throws SAXException                       No idea what this is
	 * @throws ParserConfigurationException       The xml parser failed.
	 * @see ManageReactions
	 */
	public static UniversalGetters balance(String input) throws ReactionElementNotMatchedException, ReactionNotBalancableException, ElementNotFoundException, IOException, SAXException, ParserConfigurationException
	{
//		The real logic
		UniversalGetters splitReaction = findElementInReactions(ManageReactions.splitReactions(input));
		ManageReactions.setMatrix(splitReaction);
		
		return splitReaction;
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
	 * @throws IOException                        There is no files found.
	 * @throws SAXException                       No idea what this is
	 * @throws ParserConfigurationException       The xml parser failed.
	 * @see Summoner
	 */
	private static UniversalGetters findElementInReactions(ArrayList<ReactionCompounds> compoundsArrayList) throws ElementNotFoundException, ReactionElementNotMatchedException, ParserConfigurationException, SAXException, IOException
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
	
	public static String equation(UniversalGetters splitReaction) throws ReactionNotBalancableException
	{
		return BeautifyReaction.balancedEquation(splitReaction);
	}
}