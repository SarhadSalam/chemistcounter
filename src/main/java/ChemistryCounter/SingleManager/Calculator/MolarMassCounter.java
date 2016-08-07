/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.SingleManager.Calculator;

import ChemistryCounter.Exceptions.ElementNotFoundException;
import ChemistryCounter.SingleManager.ElementDetector.Universal.ChemicalName;
import ChemistryCounter.Summoner;

import java.util.ArrayList;

/**
 * Created by sarhaD on 26-May-16.
 * <p>
 * This calculates Molar Mass.
 */
public class MolarMassCounter
{
	public static Double molar(String userInput)
	{
		ArrayList<ChemicalName> chemicalListArray = null;
		try
		{
			chemicalListArray = Summoner.summoner(userInput);
		} catch( ElementNotFoundException e )
		{
			e.printStackTrace();
		}
		return molarCounter(chemicalListArray);
	}

	public static Double molarCounter(ArrayList<ChemicalName> chemicalListArray)
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
