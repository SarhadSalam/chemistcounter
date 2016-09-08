/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.ReactionManagers.Stochiometry;

import ChemistryCounter.Exceptions.ElementNotFoundException;
import ChemistryCounter.Exceptions.ParsingErrorException;
import ChemistryCounter.ReactionManagers.ReactionCompounds;
import ChemistryCounter.Calculators.MolarMassCounter;
import ChemistryCounter.ReactionManagers.ReactionContainer;
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
	 * The method findMoleOfSpecificCompound is used to find mole of specific compound.
	 *
	 * @param mass The mass of the compound in the reaction.
	 * @param u    The universal getter
	 * @param name The name of the compound the user wants
	 *
	 * @return u ReactionContainer
	 *
	 * @throws IOException                  There is no files found.
	 * @throws SAXException                 No idea what this is
	 * @throws ParserConfigurationException The xml parser failed.
	 * @throws ElementNotFoundException     Element was not found.
	 */
	public static ReactionContainer findMoleOfCompound(Double mass, ReactionContainer u, String name) throws ElementNotFoundException, ParserConfigurationException, SAXException, IOException, ParsingErrorException
	{
		u = findMolarMass(u);
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
	 * The method findMolarMass is used for finding the molar mass of all the compounds in reaction.
	 *
	 * @param u The parameter from ReactionContainer u
	 *
	 * @throws IOException                  There is no files found.
	 * @throws SAXException                 No idea what this is
	 * @throws ParserConfigurationException The xml parser failed.
	 * @throws ElementNotFoundException     The element wasn't found.
	 */
	public static ReactionContainer findMolarMass(ReactionContainer u) throws IOException, SAXException, ParserConfigurationException, ElementNotFoundException, ParsingErrorException
	{
		for( ReactionCompounds rc : u.getReactionCompounds() )
		{
			rc.setMolarMassOfCompound(MolarMassCounter.molar(rc.getName()));
		}
		return u;
	}
	
	/**
	 * The method findMoleByRatiosFromMoles finds the mole of atoms from the basic stochiometric ratios fom the moles.
	 * <p>
	 * Each of the methods in class Stochiometry is linked to each other.
	 *
	 * @param u    ReactionContainer containing details
	 * @param name Name of the element or compound we want to find.
	 *
	 * @return u ReactionContainer.
	 *
	 * @throws ElementNotFoundException The element wasn't found.
	 */
	private static ReactionContainer findMoleByRatiosFromMoles(ReactionContainer u, String name) throws ElementNotFoundException
	{
		Double mole;
		Double balance;
		Double basicRatio = 0.0;
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
					}
				}
			}
		}
		return u;
	}
}

