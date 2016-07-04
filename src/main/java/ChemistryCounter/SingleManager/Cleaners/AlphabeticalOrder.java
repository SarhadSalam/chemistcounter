package ChemistryCounter.SingleManager.Cleaners;

import ChemistryCounter.DevelopmentPurposes.TestingPrint;
import ChemistryCounter.SingleManager.ElementDetector.Universal.ChemicalName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by sarhaD on 01-Jul-16.
 */
public class AlphabeticalOrder
{
	public static ArrayList<ChemicalName> alphabeticalOrder(ArrayList<ChemicalName> uncategorizedList)
	{
		Collections.sort(uncategorizedList, new Comparator<ChemicalName>() {
			public int compare(ChemicalName chemicalName1, ChemicalName chemicalName2) {
				return chemicalName1.getChemicalSymbol().compareTo(chemicalName2.getChemicalSymbol());
			}
		});
		return uncategorizedList;
	}
}