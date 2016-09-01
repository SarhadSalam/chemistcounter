/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.SingleManager.DetailsGrabbers;

import ChemistryCounter.Exceptions.ElementNotFoundException;
import ChemistryCounter.SingleManager.ElementDetector.Universal.ChemicalName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by sarha on 26-Apr-16.
 * The file gets the element details from an external xml file and verifies whether input element exists.
 */
public class ElementDetails
{
	
	/**
	 * The array list containing the name.
	 */
	public ArrayList<String> name = new ArrayList<>();
	
	/**
	 * The method finds elements from the xml files and whether they exist. If they do not exist a new exception is
	 * thrown saying the element was not found.
	 *
	 * @param unverifiedList The unverified list that does not contain any element details and might not exist.
	 *
	 * @return A final verified list that contains all elements inputted by the user.
	 *
	 * @throws ElementNotFoundException     Element was not found and is invalid.
	 * @throws IOException                  There is no files found.
	 * @throws SAXException                 No idea what this is
	 * @throws ParserConfigurationException The xml parser failed.
	 */
	public static ArrayList<ChemicalName> findElement(ArrayList<ChemicalName> unverifiedList) throws ElementNotFoundException, ParserConfigurationException, IOException, SAXException
	{
		ArrayList<ChemicalName> finalVerifiedList = new ArrayList<>();
		
		InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("properties_initMainChart.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(in);
		
		finalVerifiedList = findElementFromList(unverifiedList, finalVerifiedList, doc);
		return finalVerifiedList;
	}
	
	/**
	 * The method for finding element from a list.
	 * @param unverifiedList    The Unverified List
	 * @param finalVerifiedList The Final Verified List
	 * @param doc   The Document
	 * @return The Final Variable Instance
	 * @throws ElementNotFoundException In case Element is not found.
	 */
	private static ArrayList<ChemicalName> findElementFromList(ArrayList<ChemicalName> unverifiedList, ArrayList<ChemicalName> finalVerifiedList, Document doc) throws ElementNotFoundException
	{
		doc.getDocumentElement().normalize();
		
		NodeList nList = doc.getElementsByTagName("element");
		for( int i = 0; i<nList.getLength(); i++ )
		{
			
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			String symbol = eElement.getElementsByTagName("symbol").item(0).getTextContent();
//				For each element
			for( ChemicalName z : unverifiedList )
			{
				ChemicalName verifiedListInstance = new ChemicalName();
				if( symbol.equals(z.getChemicalSymbol()) )
				{
//						Sets the variable data
					verifiedListInstance.setChemicalName(eElement.getElementsByTagName("name").item(0).getTextContent());
					verifiedListInstance.setAtomicWeight(Double.parseDouble(eElement.getElementsByTagName("atomic_weight").item(0).getTextContent()));
					verifiedListInstance.setChemicalSymbol(symbol);
					verifiedListInstance.setValenceElectron(z.getValenceElectron());
					finalVerifiedList.add(verifiedListInstance);
				}
			}
		}
		
		if( ( !( unverifiedList.size() == finalVerifiedList.size() ) ) )
		{
			throw new ElementNotFoundException("There is no such element in the periodic table.");
		}
		return finalVerifiedList;
	}
}
