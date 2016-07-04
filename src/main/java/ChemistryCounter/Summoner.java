/*
 * Copyright (c) 2016. Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued..
 */

package ChemistryCounter;

import ChemistryCounter.SingleManager.Cleaners.AtomCounter;
import ChemistryCounter.SingleManager.DetailsGrabbers.ElementDetails;
import ChemistryCounter.SingleManager.ElementDetector.ElementManager;
import ChemistryCounter.SingleManager.ElementDetector.Universal.ChemicalName;

import java.util.ArrayList;

/**
 * Created by sarhaD on 14-May-16.
 * The super class through which any and all elements will be passed through. BOOM BIATCH!
 */

public class Summoner
{
	public static ArrayList<ChemicalName> summoner(String userInput)
	{
		System.out.println("The compound in use presently is: "+userInput);
		try
		{
			ArrayList<ChemicalName> managedElements = ElementManager.elements(userInput);
			ArrayList<ChemicalName> elementName = ElementDetails.findElement(managedElements);
			ArrayList<ChemicalName> counted = AtomCounter.atomCounter(elementName);
			return counted;
		} catch( NullPointerException e )
		{
			throw new NullPointerException();
		}
	}
}
