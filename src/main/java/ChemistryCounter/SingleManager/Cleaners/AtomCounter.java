package ChemistryCounter.SingleManager.Cleaners;

import ChemistryCounter.SingleManager.ElementDetector.Universal.ChemicalName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by sarhaD on 24-May-16.
 * The file handles Atom Count by creating a HashMap and comparing the values in the HashMap.
 */
public class AtomCounter
{
	public static ArrayList<ChemicalName> atomCounter(ArrayList<ChemicalName> uncountedList)
	{
		ArrayList<ChemicalName> countedList = new ArrayList<>();
		ArrayList<String> counter = new ArrayList<>();
		HashSet<String> resultsHasMap = new HashSet<>();

//		Creates a list counter for each chemical symbol
		for( ChemicalName item : uncountedList )
		{
			counter.add(item.getChemicalSymbol());
		}

//		Each uncounted list gets sorted and properly translated
		for( ChemicalName item : uncountedList )
		{
//			Calculates Frequency of each occurence
			int count = Collections.frequency(counter, item.getChemicalSymbol());
//			Creates a unique set.
			if( !resultsHasMap.contains(item.getChemicalSymbol()) )
			{
				countedList.add(item);
				resultsHasMap.add(item.getChemicalSymbol());
				item.setCount(count);
			}

//			Calculates total valency 
			if( resultsHasMap.contains(item.getChemicalSymbol()) )
			{
				int multivalence = item.getValenceElectron();
				for( ChemicalName multiValenceSolver : countedList )
				{
					if( multiValenceSolver.getChemicalSymbol().equals(item.getChemicalSymbol()) )
					{
						multiValenceSolver.setMultiValenceElectron(multivalence);
					}
				}
			}
		}
		return countedList;
	}
}
