/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.ReactionManagers.Stochiometry;

import ChemistryCounter.Exceptions.ElementNotFoundException;
import ChemistryCounter.Exceptions.ReactionElementNotMatchedException;
import ChemistryCounter.Exceptions.ReactionNotBalancableException;
import ChemistryCounter.ReactionManagers.Manager;
import ChemistryCounter.ReactionManagers.ReactionCompounds;
import ChemistryCounter.SingleManager.Calculator.MolarMassCounter;
import ChemistryCounter.Universal.UniversalGetters;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Class Details:-
 * Author: Sarhad
 * User: sarha
 * Date: 09-Aug-16
 * Time : 2:40 PM
 * Project Name: chemistsCounter
 * Class Name: Stochiometry
 * <p>
 * The class stochiometry is used for stochiometry tricks after balancing an equation.
 */

public class Stochiometry
{
	
	/**
	 * The method convertString converts the user input to a balanced reaction.
	 *
	 * @param reactionUserInput The user input containing the reaction to apply stochiometric rules to.
	 *
	 * @return Balanced Input
	 *
	 * @throws ElementNotFoundException           Element was not found
	 * @throws ReactionNotBalancableException     Reaction cannot be balanced.
	 * @throws ReactionElementNotMatchedException Element and or Compound cannot be balanced.
	 */
	public static UniversalGetters convertString(String reactionUserInput) throws ElementNotFoundException, ReactionNotBalancableException, ReactionElementNotMatchedException, ParserConfigurationException, SAXException, IOException
	{
		return Manager.balance(reactionUserInput);
	}
	
	/**
	 * The method findMolarMass is used for finding the molar mass of all the compounds in reaction.
	 *
	 * @param u The parameter from UniversalGetters u
	 */
	private static void findMolarMass(UniversalGetters u) throws IOException, SAXException, ParserConfigurationException, ElementNotFoundException
	{
		for( ReactionCompounds rc : u.getReactionCompounds() )
		{
			rc.setMolarMassOfCompound(MolarMassCounter.molar(rc.getName()));
		}
	}
	
	/**
	 * The method findMoleOfSpecificCompound is used to find mole of specific compound.
	 *
	 * @param mass The mass of the compound in the reaction.
	 * @param u    The universal getter
	 * @param name The name of the compound the user wants
	 *
	 * @return u UniversalGetters
	 *
	 * @throws ElementNotFoundException Element was not found.
	 */
	public static UniversalGetters findMoleOfSpecificCompound(Double mass, UniversalGetters u, String name) throws ElementNotFoundException, ParserConfigurationException, SAXException, IOException
	{
		findMolarMass(u);
		boolean exists = false;
		for( ReactionCompounds rc : u.getReactionCompounds() )
		{
			if( rc.getName().replaceAll("\\s+", "").equalsIgnoreCase(name.replaceAll("\\s+", "")) || rc.getOriginalName().replaceAll("\\s+", "").equalsIgnoreCase(name.replaceAll("\\s+", "")) )
			{
				rc.setMoleOfCompound(mass/rc.getMolarMassOfCompound());
				exists = true;
			}
		}
		if( !exists )
		{
			throw new ElementNotFoundException("Element was not found in the reaction. ");
		} else
		{
			for( ReactionCompounds rc : u.getReactionCompounds() )
			{
				findMoleByRatiosFromMoles(u, rc.getName());
			}
			return u;
		}
	}
	
	/**
	 * The method findMoleByRatiosFromMoles finds the mole of atoms from the basic stochiometric ratios fom the moles.
	 * <p>
	 * Each of the methods in class Stochiometry is linked to each other.
	 *
	 * @param u    UniversalGetters containing details
	 * @param name Name of the element or compound we want to find.
	 */
	public static UniversalGetters findMoleByRatiosFromMoles(UniversalGetters u, String name) throws ElementNotFoundException
	{
		Double mole;
		Double balance;
		Double basicRatio = 0.0;
		boolean worked = false;
		for( ReactionCompounds rc : u.getReactionCompounds() )
		{
			if( rc.getMoleOfCompound() != 0.0 )
			{
				mole = rc.getMoleOfCompound();
				balance = (double) rc.getReactionBalance();
				basicRatio = mole/balance;
			} else
			{
				if( rc.getName().replaceAll("\\s+", "").equalsIgnoreCase(name.replaceAll("\\s+", "")) || rc.getOriginalName().replaceAll("\\s+", "").equalsIgnoreCase(name.replaceAll("\\s+", "")) )
				{
					if( basicRatio != 0 )
					{
						rc.setMoleOfCompound(basicRatio*rc.getReactionBalance());
						worked = true;
					}
				}
			}
		}
		if( !worked )
		{
			throw new ElementNotFoundException("The element wasn't found in the reaction or the developer just fucked up. Let me tell you why: I plucked my wisdom teeth and it hurts, but I have to code cause the code life chose me.");
		} else
		{
			return u;
		}
	}
}

