/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.SingleManager.Cleaners;

import ChemistryCounter.SingleManager.ElementParser.Universal.ElementDetails;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by sarhaD on 24-May-16.
 * <p>
 * The file handles Atom Count by creating a HashMap and comparing the values in the HashMap. The atom count is later
 * saved in the ArrayList containing chemical name.
 */
public class AtomCounter
{
	
	/**
	 * The method below counts the number of atoms in a compound or reaction.
	 *
	 * @param uncountedList The uncounted list which has no atom counter.
	 *
	 * @return counted The counted list contains the number of atoms.
	 */
	public static ArrayList<ElementDetails> atomCounter(ArrayList<ElementDetails> uncountedList)
	{
		ArrayList<ElementDetails> countedList = new ArrayList<>();
		ArrayList<String> counter = new ArrayList<>();
		HashSet<String> resultsHasMap = new HashSet<>();

//		Creates a list counter for each chemical symbol
		for( ElementDetails item : uncountedList )
		{
			counter.add(item.getChemicalSymbol());
		}

//		Each uncounted list gets sorted and properly translated
		for( ElementDetails item : uncountedList )
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
				for( ElementDetails multiValenceSolver : countedList )
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
