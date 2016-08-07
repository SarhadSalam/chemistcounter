/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.ReactionManagers.ReactionDetector;

import ChemistryCounter.Exceptions.ReactionNotBalancableException;
import ChemistryCounter.ReactionManagers.ReactionCompounds;
import ChemistryCounter.UniversalGetters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class Details:-
 * Author: Sarhad
 * User: sarha
 * Date: 07-Aug-16
 * Time : 9:09 PM
 * Project Name: chemistsCounter
 * Class Name: BeautifyReaction
 */
public class BeautifyReaction
{
	/**
	 * The method balancedEquation beautifies the method/
	 *
	 * @param splitReaction the reaction solved which remains to be beautified.
	 * @param d             2D Double
	 * @return equation
	 * @throws ReactionNotBalancableException	Reaction cannot be balanced.
	 */
	public static String balancedEquation(UniversalGetters splitReaction, Double[] d) throws ReactionNotBalancableException
	{
		String product = "";
		String reactant = "";
		String equation;

		for( int i = 0; i<splitReaction.getReactionCompounds().size(); i++ )
		{
			ReactionCompounds eq = splitReaction.getReactionCompounds().get(i);
			eq.setReactionBalance((int) Math.round(Math.abs(d[i])));

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
	 * The method below gets the equation.
	 *
	 * @param givenName The original names given by the used
	 * @param eq        The eq which is a ReactionCompounds
	 * @return givenName
	 * @throws ReactionNotBalancableException	Reaction cannot be balanced.
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
}
