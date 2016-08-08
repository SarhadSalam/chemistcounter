/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.SingleManager.Cleaners;

import ChemistryCounter.SingleManager.ElementDetector.Universal.ChemicalName;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by sarhaD on 01-Jul-16.
 * <p>
 * The class sorts the elements in the array list in alphabetical order.
 */
public class AlphabeticalOrder
{
	
	/**
	 * The method sorts the elements in the array list in alphabetical order.
	 *
	 * @param uncategorizedList The list is not alphabeticaly categorized.
	 *
	 * @return categorizedList
	 */
	public static ArrayList<ChemicalName> alphabeticalOrder(ArrayList<ChemicalName> uncategorizedList)
	{
		Collections.sort(uncategorizedList, (chemicalName1, chemicalName2) -> chemicalName1.getChemicalSymbol().compareTo(chemicalName2.getChemicalSymbol()));
		return uncategorizedList;
	}
}