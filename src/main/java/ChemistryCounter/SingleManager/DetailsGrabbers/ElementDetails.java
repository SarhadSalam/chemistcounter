/*
 * Copyright (c) 2016. Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued..
 */

package ChemistryCounter.SingleManager.DetailsGrabbers;

import ChemistryCounter.SingleManager.ElementDetector.Universal.ChemicalName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by sarha on 26-Apr-16.
 * The file gets the element details from an external xml file and verifies whether input element exists.
 */
public class ElementDetails
{
	public static ArrayList<ChemicalName> findElement(ArrayList<ChemicalName> unverifiedList)
	{
		ArrayList<ChemicalName> finalVerifiedList = new ArrayList<>();
		try
		{
			File molarMass = new File("W:\\lol\\src\\main\\resources\\properties_initMainChart.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(molarMass);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("element");

			for( int i = 0; i < nList.getLength(); i++ )
			{

				Node nNode = nList.item(i);
				Element eElement = (Element) nNode;
				String symbol = eElement.getElementsByTagName("symbol").item(0).getTextContent();
//				For each element
				for( int z = 0; z < unverifiedList.size(); z++ )
				{
					ChemicalName verifiedListInstance = new ChemicalName();
					ChemicalName chemicalNameInstance = unverifiedList.get(z);
					if( symbol.equals(chemicalNameInstance.getChemicalSymbol()) )
					{
//						Sets the variable data

						verifiedListInstance.setChemicalName(eElement.getElementsByTagName("name").item(0).getTextContent());
						verifiedListInstance.setAtomicWeight(Double.parseDouble(eElement.getElementsByTagName("atomic_weight").item(0).getTextContent()));
						verifiedListInstance.setChemicalSymbol(symbol);
						verifiedListInstance.setValenceElectron(chemicalNameInstance.getValenceElectron());
						finalVerifiedList.add(verifiedListInstance);
					}
				}
			}

		} catch( Exception e )
		{
			e.printStackTrace();
		}
		return finalVerifiedList;
	}
}
