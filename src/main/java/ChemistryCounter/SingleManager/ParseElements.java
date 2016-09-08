/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.SingleManager;

import ChemistryCounter.Exceptions.ElementNotFoundException;
import ChemistryCounter.Exceptions.ParsingErrorException;
import ChemistryCounter.SingleManager.Cleaners.AtomCounter;
import ChemistryCounter.SingleManager.ElementInformation.ElementInformation;
import ChemistryCounter.SingleManager.ElementParser.ElementManager;
import ChemistryCounter.SingleManager.ElementParser.Universal.ElementDetails;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sarhaD on 14-May-16.
 * The class parseElements is where all elements and compounds are sent using the userInput param.
 * <p>
 * The atom is counted, the entire list is alphabetically organized.
 */

public class ParseElements
{
	/**
	 * The class parseElements is where all elements and compounds are sent using the userInput param.
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
	public static ArrayList<ElementDetails> parseElements(String userInput) throws ElementNotFoundException, IOException, SAXException, ParserConfigurationException, ParsingErrorException
	{
		ArrayList<ElementDetails> managedElements = ElementManager.elements(userInput);
		ArrayList<ElementDetails> elementName = ElementInformation.findElement(managedElements);
		return AtomCounter.atomCounter(elementName);
	}
}
