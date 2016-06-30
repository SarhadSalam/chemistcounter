/*
 * Copyright (c) 2016. Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued..
 */

package ChemistryCounter.SingleManager.ElementDetector.lib;

import ChemistryCounter.SingleManager.ElementDetector.Universal.ChemicalName;

import java.util.ArrayList;

/**
 * Created by sarhaD on 23-May-16.
 * The file manages all kinds of elements when they are sorted out and gone through the algorithm.
 */
public class Normal
{
	public static ArrayList<ChemicalName> manager(String chemicalCompound)
	{
//		Split Based on capital letters
		String[] splitElement = chemicalCompound.split("(?=[A-Z])");
		ArrayList<ChemicalName> chemicalList = new ArrayList<>();
//			Detects compounds
		for( int i = 0; i < splitElement.length; i++ )
		{
			String elementName = splitElement[i];
			ChemicalName element = new ChemicalName();
//			If Element does not have valence electron
			if( !elementName.matches(".*\\d+.*") )
			{
				element.setChemicalSymbol(elementName);
				element.setValenceElectron(1);
				chemicalList.add(element);
			}

//			If element has valence electron.
			if( elementName.matches(".*\\d+.*") )
			{
				String[] valencyElements = elementName.split("(?<=[\\w&&\\D])(?=\\d)");
				element.setChemicalSymbol(valencyElements[0]);
				element.setValenceElectron(Integer.parseInt(valencyElements[1]));
				chemicalList.add(element);
			}
		}
		return chemicalList;
	}
}