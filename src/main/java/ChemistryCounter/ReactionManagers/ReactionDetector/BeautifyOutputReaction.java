/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.ReactionManagers.ReactionDetector;

import ChemistryCounter.Exceptions.ReactionNotBalancableException;
import ChemistryCounter.ReactionManagers.ReactionCompounds;
import ChemistryCounter.ReactionManagers.ReactionContainer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class Details:-
 * Author: Sarhad
 * User: sarha
 * Date: 07-Aug-16
 * Time : 9:09 PM
 * Project Name: chemistsCounter
 * Class Name: BeautifyOutputReaction
 * The class BeautifyOutputReaction beautifies the reaction.
 */
public class BeautifyOutputReaction
{
	/**
	 * The method balancedEquation beautifies the reaction after balancing is done.
	 *
	 * @param splitReaction the reaction solved which remains to be beautified.
	 *
	 * @return equation
	 *
	 * @throws ReactionNotBalancableException Reaction cannot be balanced.
	 * @see ChemistryCounter.ReactionManagers.Manager
	 */
	public static String balancedEquation(ReactionContainer splitReaction) throws ReactionNotBalancableException
	{
		String product = "";
		String reactant = "";
		String equation;
		
		for( int i = 0; i<splitReaction.getReactionCompounds().size(); i++ )
		{
			ReactionCompounds eq = splitReaction.getReactionCompounds().get(i);
			
			if( eq.getCompoundStatus().equals("Reactant") )
			{
				reactant = getEquation(reactant, eq);
			}
			
			if( eq.getCompoundStatus().equals("Product") )
			{
				product = getEquation(product, eq);
			}
		}
		reactant = reactant.substring(0, reactant.length()-3);
		product = product.substring(0, product.length()-3);
		
		equation = reactant+" -> "+product;
		
		return equation;
	}
	
	/**
	 * The method getEquation below beautifies several equation details.
	 *
	 * @param givenName The original names given by the used
	 * @param eq        The eq which is a ReactionCompounds
	 *
	 * @return givenName
	 *
	 * @throws ReactionNotBalancableException Reaction cannot be balanced.
	 */
	private static String getEquation(String givenName, ReactionCompounds eq) throws ReactionNotBalancableException
	{
		String name = eq.getName();
		String nonPolyatomicName = "";
		
		int reactionBalance = eq.getReactionBalance();
		
		if( !eq.getOriginalName().equals("") )
		{
			name = eq.getOriginalName();
			nonPolyatomicName = eq.getOriginalName().replaceFirst("[\\d]*", "");
			Pattern pattern = Pattern.compile("[\\d]*");
			Matcher matcher = pattern.matcher(name);
			if( matcher.find() )
			{
				reactionBalance = reactionBalance*Integer.parseInt(matcher.group(0));
			}
		}
		
		if( eq.getReactionBalance() == 1 )
		{
//			given name can be put[utted with 1 by uncommenting the line below
//			givenName = givenName+"1"+name+" + ";
			givenName = givenName+name+" + ";
		} else if( eq.getReactionBalance() == 0 )
		{
			throw new ReactionNotBalancableException("The reaction cannot take place with the given compounds.");
		} else
		{
			if( !nonPolyatomicName.equals("") )
			{
				givenName = givenName+reactionBalance+nonPolyatomicName+" + ";
			} else
			{
				givenName = givenName+reactionBalance+name+" + ";
			}
		}
		return givenName;
	}
	
	/**
	 * The method below uglifies the equation which is used in verification and development processes. It will be
	 * removed in future versions while cleaning up code.
	 *
	 * @param splitReaction The universal information containing split reaction.
	 * @param d             The double transpose balanced valence electron.
	 *
	 * @return String of uglified equation
	 *
	 * @see BeautifyOutputReaction
	 * @deprecated
	 */
	public static String uglifyEquation(ReactionContainer splitReaction, Double[] d)
	{
		String product = "";
		String reactant = "";
		String equation = "";
		
		for( int i = 0; i<splitReaction.getReactionCompounds().size(); i++ )
		{
			ReactionCompounds rc = splitReaction.getReactionCompounds().get(i);
			String name = rc.getName();
			if( rc.getCompoundStatus().equals("Reactant") )
			{
				reactant = reactant+rc.getReactionBalance()+name+" + ";
			} else
			{
				product = product+rc.getReactionBalance()+name+" + ";
			}
		}
		equation = reactant+" = "+product;
		return equation;
	}
}
