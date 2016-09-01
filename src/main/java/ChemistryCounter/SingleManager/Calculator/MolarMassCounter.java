/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.SingleManager.Calculator;

import ChemistryCounter.Exceptions.ElementNotFoundException;
import ChemistryCounter.SingleManager.ElementDetector.Universal.ChemicalName;
import ChemistryCounter.SingleManager.Summoner;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sarhaD on 26-May-16.
 * <p>
 * The class MolarMassCounter calculates Molar Mass.
 */
public class MolarMassCounter
{
	/**
	 * The method molar below finds the molar mass of an element of compound.
	 *
	 * @param userInput The molar mass is userInput.
	 *
	 * @return molarCounter
	 *
	 * @throws IOException                  There is no files found.
	 * @throws SAXException                 No idea what this is
	 * @throws ParserConfigurationException The xml parser failed.
	 * @throws ElementNotFoundException     The element wasn't found.
	 */
	public static Double molar(String userInput) throws ParserConfigurationException, SAXException, IOException, ElementNotFoundException
	{
		ArrayList<ChemicalName> chemicalListArray = null;
		chemicalListArray = Summoner.summoner(userInput);
		return molar(chemicalListArray);
	}
	
	/**
	 * The method molarCounter below calculates molar mass in case we have impending operations with the molar mass.
	 *
	 * @param chemicalListArray The molar is counted
	 *
	 * @return molar mass
	 */
	public static Double molar(ArrayList<ChemicalName> chemicalListArray)
	{
		double molarMass = 0.0;
		for( ChemicalName item : chemicalListArray )
		{
			if( item.getValenceElectron()>1 )
			{
				molarMass = molarMass+item.getAtomicWeight()*item.getValenceElectron();
			} else
			{
				molarMass = molarMass+item.getAtomicWeight();
			}
		}
		return molarMass;
	}
}
