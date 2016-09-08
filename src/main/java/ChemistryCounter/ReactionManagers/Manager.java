/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.ReactionManagers;

import ChemistryCounter.Exceptions.ElementNotFoundException;
import ChemistryCounter.Exceptions.ParsingErrorException;
import ChemistryCounter.Exceptions.ReactionElementNotMatchedException;
import ChemistryCounter.Exceptions.ReactionNotBalancableException;
import ChemistryCounter.ReactionManagers.ReactionDetector.BeautifyOutputReaction;
import ChemistryCounter.ReactionManagers.ReactionDetector.ReactionManager;
import ChemistryCounter.SingleManager.ElementParser.Universal.ElementDetails;
import ChemistryCounter.SingleManager.ParseElements;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sarhaD on 27-Jun-16.
 * <p>
 * This class Manager is the reaction manager algorithm. It forwards on the user input to ReactionManager. This class is
 * built on several classes. I am not going to mention all classes which were built from here.
 *
 * @see ReactionManager
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
	 * @see ReactionManager
	 */
	public static ReactionContainer balance(String input) throws ReactionElementNotMatchedException, ReactionNotBalancableException, ElementNotFoundException, IOException, SAXException, ParserConfigurationException, ParsingErrorException
	{
//		The real logic
		ReactionContainer splitReaction = findElementInReactions(ReactionManager.splitReactions(input));
		ReactionManager.setMatrix(splitReaction);
		
		return splitReaction;
	}
	
	/**
	 * The method converts the ReactionContainer to splitReaction
	 * @param splitReaction ReactionContainer
	 * @return  String
	 * @throws ReactionNotBalancableException   ReactionCannotbeBalanced
	 */
	public static String convertToEquation(ReactionContainer splitReaction) throws ReactionNotBalancableException
	{
		return BeautifyOutputReaction.balancedEquation(splitReaction);
	}
	
	/**
	 * The method converts the ReactionContainer to splitReaction
	 * @param input ReactionContainer
	 * @return  String
	 * @throws ReactionNotBalancableException   ReactionCannotbeBalanced
	 */
	public static String convertToEquation(String input) throws ReactionNotBalancableException, ReactionElementNotMatchedException, SAXException, ParserConfigurationException, ElementNotFoundException, IOException, ParsingErrorException
	{
		return BeautifyOutputReaction.balancedEquation(balance(input));
	}
	
	/**
	 * The method findElementInReactions below finds elements in a reaction with the help of the parseElements class.
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
	 * @see ParseElements
	 */
	private static ReactionContainer findElementInReactions(ArrayList<ReactionCompounds> compoundsArrayList) throws ElementNotFoundException, ReactionElementNotMatchedException, ParserConfigurationException, SAXException, IOException, ParsingErrorException
	{
		ReactionContainer universal = new ReactionContainer();
		ArrayList<ElementDetails> reactant = ParseElements.parseElements(ReactionManager.getReactant);
		ArrayList<ElementDetails> product = ParseElements.parseElements(ReactionManager.getProduct);
		
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
	private static void verification(ArrayList<ElementDetails> reactant, ArrayList<ElementDetails> product) throws ReactionElementNotMatchedException
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