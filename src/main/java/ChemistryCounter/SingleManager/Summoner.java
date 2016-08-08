/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.SingleManager;

import ChemistryCounter.Exceptions.ElementNotFoundException;
import ChemistryCounter.SingleManager.Cleaners.AtomCounter;
import ChemistryCounter.SingleManager.DetailsGrabbers.ElementDetails;
import ChemistryCounter.SingleManager.ElementDetector.ElementManager;
import ChemistryCounter.SingleManager.ElementDetector.Universal.ChemicalName;

import java.util.ArrayList;

/**
 * Created by sarhaD on 14-May-16.
 * The class Summoner is where all elements and compounds are sent using the userInput param.
 * <p>
 * The atom is counted, the entire list is alphabetically organized.
 */

public class Summoner
{
	
	/**
	 * The class Summoner is where all elements and compounds are sent using the userInput param.
	 * <p>
	 * The class solves the element name.
	 *
	 * @param userInput The string that contains the user input to simplify
	 *
	 * @return ArrayList elementDetails
	 *
	 * @throws ElementNotFoundException Element was not found.
	 */
	public static ArrayList<ChemicalName> summoner(String userInput) throws ElementNotFoundException
	{
		ArrayList<ChemicalName> managedElements = ElementManager.elements(userInput);
		ArrayList<ChemicalName> elementName = ElementDetails.findElement(managedElements);
		return AtomCounter.atomCounter(elementName);
	}
}