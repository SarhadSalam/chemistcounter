/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.SingleManager;

import ChemistryCounter.Exceptions.ElementNotFoundException;
import ChemistryCounter.SingleManager.Cleaners.AtomCounter;
import ChemistryCounter.SingleManager.DetailsGrabbers.ElementDetails;
import ChemistryCounter.SingleManager.ElementDetector.ElementManager;
import ChemistryCounter.SingleManager.ElementDetector.Universal.ChemicalName;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
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
			Summoner.summoner("H2O");
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
	
	public static InputStream getInputStream()
	{
		return inputStream;
	}
	
	private static InputStream inputStream = null;
	
	public static void setInputStream(InputStream inputStream)
	{
		Summoner.inputStream = inputStream;
	}
	
	/**
	 * /**
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
		ArrayList<ChemicalName> elementName = null;
		if(inputStream == null)
		{
			ArrayList<ChemicalName> managedElements = ElementManager.elements(userInput);
			elementName = ElementDetails.findElement(managedElements);
		} else {
			ArrayList<ChemicalName> managedElements = ElementManager.elements(userInput);
			elementName = ElementDetails.findElement(managedElements, inputStream);
		}
		return AtomCounter.atomCounter(elementName);
	}
}
