/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.SingleManager.ElementParser.lib;

import ChemistryCounter.Exceptions.ElementNotFoundException;
import ChemistryCounter.SingleManager.ElementParser.Universal.ElementDetails;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sarhaD on 20-May-16. The file deals with several instances of polyatomic compounds and passes on to the
 * Normal Manager to solve the normal compounds.
 */
public class Polyatomic
{
	
	/**
	 * The method below manages the polyatomic compounds by simplifying it to a normal compound so that it can be
	 * further processed by the normal class.
	 *
	 * @param chemicalCompound The Chemical Compound which is polyatomic
	 *
	 * @return The polyatomic elements list.
	 *
	 * @throws IOException                  There is no files found.
	 * @throws SAXException                 No idea what this is
	 * @throws ParserConfigurationException The xml parser failed.
	 * @throws ElementNotFoundException     The element wasn't found.
	 * @see Normal
	 */
	public static ArrayList<ElementDetails> manager(String chemicalCompound) throws ElementNotFoundException, SAXException, ParserConfigurationException, IOException
	{
		ArrayList<String> polyatomicElements = new ArrayList<>();
//		Separate the polyatomic compound and the normal compounds
		Pattern removePolyatomic = Pattern.compile("\\((.*?)\\)\\d*");
		Matcher polyatomicMatcher = removePolyatomic.matcher(chemicalCompound);
		
		while( polyatomicMatcher.find() )
		{
			polyatomicElements.add(polyatomicMatcher.group());
		}
		ArrayList<ElementDetails> polyatomicElementsList = bracketManager(polyatomicElements);

//		Deals with the non-polyatomic part
		String[] split = chemicalCompound.split("\\((.*?)\\)\\d*");
		
		String nonPolyatomicCompound = "";
		for( String i : split )
		{
			nonPolyatomicCompound = nonPolyatomicCompound+i;
		}
		
		if( !nonPolyatomicCompound.equals("") )
		{
			//		Sends of the non polyatomic to normal manager
			ArrayList<ElementDetails> nonPolyatomicElementsListName = Normal.manager(nonPolyatomicCompound);

//		Adds to the long list of elements in this single compound
			polyatomicElementsList.addAll(nonPolyatomicElementsListName);
		}
		return polyatomicElementsList;
	}
	
	/**
	 * The method bracketManager manages and terminates the brackets which helps the polyatomic manager.
	 *
	 * @param polyatomicElements Polyatomic elements is minmised by the managing method.
	 *
	 * @return Element List
	 *
	 * @throws IOException                  There is no files found.
	 * @throws SAXException                 No idea what this is
	 * @throws ParserConfigurationException The xml parser failed.
	 * @throws ElementNotFoundException     The element wasn't found.
	 * @see Polyatomic
	 */
	private static ArrayList<ElementDetails> bracketManager(ArrayList<String> polyatomicElements) throws ElementNotFoundException, SAXException, ParserConfigurationException, IOException
	{
		ArrayList<ElementDetails> chemicalListContainer = new ArrayList<>();
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
				ArrayList<ElementDetails> elements;
				elements = Normal.manager(polyatomicValenceArrayFinal.get(0));
//			All kinds of magical thing goes on down there
				for( ElementDetails valenceElement : elements )
				{
					int valenceElectronCount = valenceElement.getValenceElectron();
					int polyatomicValenceElectron = Integer.parseInt(polyatomicValenceArrayFinal.get(1));
					valenceElectronCount = valenceElectronCount*polyatomicValenceElectron;
					valenceElement.setValenceElectron(valenceElectronCount);
				}
				chemicalListContainer.addAll(elements);
			} else
			{
//				In case polyatomic valence is not available in the input
				ArrayList<ElementDetails> elements = Normal.manager(polyatomicValenceArrayFinal.get(0));
				chemicalListContainer.addAll(elements);
				
			}
		}
		return chemicalListContainer;
	}
}
