/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.SingleManager.Cleaners;

import ChemistryCounter.SingleManager.ElementParser.Universal.ElementDetails;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
	public static ArrayList<ElementDetails> alphabeticalOrder(ArrayList<ElementDetails> uncategorizedList)
	{
		Collections.sort(uncategorizedList, new Comparator<ElementDetails>()
		{
			@Override
			public int compare(ElementDetails o1, ElementDetails o2)
			{
				return o1.getChemicalSymbol().compareTo(o2.getChemicalSymbol());
			}
		});
		return uncategorizedList;
	}
}