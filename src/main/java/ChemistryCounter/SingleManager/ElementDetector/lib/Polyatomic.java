/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.SingleManager.ElementDetector.lib;

import ChemistryCounter.Exceptions.ElementNotFoundException;
import ChemistryCounter.SingleManager.ElementDetector.Universal.ChemicalName;
import ChemistryCounter.Summoner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sarhaD on 20-May-16.
 * The file deals with several instances of polyatomic compounds and passes on to the Normal Manager to deal with other levels of complexity.
 */
public class Polyatomic
{
	public static ArrayList<ChemicalName> manager(String chemicalCompound)
	{
		ArrayList<String> polyatomicElements = new ArrayList<>();

//		Separate the polyatomic compound and the normal compounds
		Pattern removePolyatomic = Pattern.compile("\\((.*?)\\)\\d*");
		Matcher polyatomicMatcher = removePolyatomic.matcher(chemicalCompound);

		while( polyatomicMatcher.find() )
		{
			polyatomicElements.add(polyatomicMatcher.group());
		}
		ArrayList<ChemicalName> polyatomicElementsList = bracketManager(polyatomicElements);

//		Deals with the non-polyatomic part
		String nonPolyatomicCompound = String.join("", chemicalCompound.split("\\((.*?)\\)\\d*"));
		if( !nonPolyatomicCompound.equals("") )
		{
			//		Sends of the non polyatomic to normal manager
			ArrayList<ChemicalName> nonPolyatomicElementsListName = Normal.manager(nonPolyatomicCompound);

//		Adds to the long list of elements in this single compound
			polyatomicElementsList.addAll(nonPolyatomicElementsListName);
		}
		return polyatomicElementsList;
	}

	private static ArrayList<ChemicalName> bracketManager(ArrayList<String> polyatomicElements)
	{
		ArrayList<ChemicalName> chemicalListContainer = new ArrayList<>();
//		Goes through all instances of the polyatomic compounds
		for( String valenceElectron : polyatomicElements )
		{
			//			Removes the brackets
			String[] polyatomicValenceArray = valenceElectron.split("[?=()]");
			ArrayList<String> polyatomicValenceArrayFinal = new ArrayList<>();

//			Deals with an empty array, basically just a fix.
			for( int z = 0; z<polyatomicValenceArray.length; z++ )
			{
				if( polyatomicValenceArray[z].equals("") )
				{
					polyatomicValenceArrayFinal.addAll(Arrays.asList(polyatomicValenceArray));
					polyatomicValenceArrayFinal.remove(z);
				}
			}

//			Ensures that the polyatomic compound does have a valence electron
			if( valenceElectron.matches(".*\\)\\d.*") )
			{
				ArrayList<ChemicalName> elements = Normal.manager(polyatomicValenceArrayFinal.get(0));
//				All kinds of magical thing goes on down there
				for( int z = 0; z<elements.size(); z++ )
				{
					ChemicalName valenceElement = elements.get(z);
					int valenceElectronCount = valenceElement.getValenceElectron();
					int polyatomicValenceElectron = Integer.parseInt(polyatomicValenceArrayFinal.get(1));
					valenceElectronCount = valenceElectronCount*polyatomicValenceElectron;
					valenceElement.setValenceElectron(valenceElectronCount);
					chemicalListContainer = elements;
				}

			} else
			{
//				In case polyatomic valence is not available in the input
				ArrayList<ChemicalName> elements = null;
				try
				{
					elements = Summoner.summoner(polyatomicValenceArrayFinal.get(0));
				} catch( ElementNotFoundException e )
				{
					e.printStackTrace();
				}
				chemicalListContainer.addAll(elements);
			}
		}
		return chemicalListContainer;
	}
}
