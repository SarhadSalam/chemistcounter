/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.SingleManager;

import ChemistryCounter.Exceptions.ElementNotFoundException;
import ChemistryCounter.Exceptions.ReactionElementNotMatchedException;
import ChemistryCounter.Exceptions.ReactionNotBalancableException;
import ChemistryCounter.ReactionManagers.Manager;
import ChemistryCounter.SingleManager.Cleaners.AtomCounter;
import ChemistryCounter.SingleManager.DetailsGrabbers.ElementDetails;
import ChemistryCounter.SingleManager.ElementDetector.ElementManager;
import ChemistryCounter.SingleManager.ElementDetector.Universal.ChemicalName;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sarhaD on 14-May-16.
 * The class Summoner is where all elements and compounds are sent using the userInput param.
 * <p>
 * The atom is counted, the entire list is alphabetically organized.
 */

public class Summoner
{
	
	public static void main(String[] args)
	{
		try
		{
			System.out.println(Manager.equation(Manager.balance("H2+O2=H2O")));
		} catch( ReactionElementNotMatchedException e )
		{
			e.printStackTrace();
		} catch( ReactionNotBalancableException e )
		{
			e.printStackTrace();
		} catch( ElementNotFoundException e )
		{
			e.printStackTrace();
		} catch( IOException e )
		{
			e.printStackTrace();
		} catch( SAXException e )
		{
			e.printStackTrace();
		} catch( ParserConfigurationException e )
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * The class Summoner is where all elements and compounds are sent using the userInput param.
	 * <p>
	 * The class solves the element name.
	 *
	 * @param userInput The string that contains the user input to simplify
	 *
	 * @return ArrayList elementDetails
	 *
	 * @throws ElementNotFoundException     The Element wasn't found.
	 * @throws IOException                  There is no files found.
	 * @throws SAXException                 No idea what this is
	 * @throws ParserConfigurationException The xml parser failed.
	 */
	public static ArrayList<ChemicalName> summoner(String userInput) throws ElementNotFoundException, IOException, SAXException, ParserConfigurationException
	{
		ArrayList<ChemicalName> managedElements = ElementManager.elements(userInput);
		ArrayList<ChemicalName> elementName = ElementDetails.findElement(managedElements);
		return AtomCounter.atomCounter(elementName);
	}
}
