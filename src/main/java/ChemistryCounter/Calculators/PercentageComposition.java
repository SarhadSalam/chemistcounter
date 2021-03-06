/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.Calculators;

import ChemistryCounter.SingleManager.ElementParser.Universal.ElementDetails;

import java.util.ArrayList;

/**
 * Created by sarhaD on 29-May-16.
 * <p>
 * The percentage compostion in a compound is found out in this method.
 */
public class PercentageComposition
{
	
	/**
	 * The percentage compostion in a compound is found out in this method.
	 *
	 * @param compound The element in a compound to find the composition
	 *
	 * @return compound P
	 */
	public static ArrayList<ElementDetails> percentage(ArrayList<ElementDetails> compound)
	{
		Double molarMass = MolarMassCounter.molar(compound);
		
		for( ElementDetails item : compound )
		{
			Double compositionPercent = ( ( item.getAtomicWeight()*item.getValenceElectron() )/molarMass )*100;
			item.setComposition(compositionPercent);
		}
		return compound;
	}
}
