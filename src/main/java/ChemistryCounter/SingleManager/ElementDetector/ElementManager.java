/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.SingleManager.ElementDetector;

import ChemistryCounter.SingleManager.ElementDetector.Universal.ChemicalName;
import ChemistryCounter.SingleManager.ElementDetector.lib.Normal;
import ChemistryCounter.SingleManager.ElementDetector.lib.Polyatomic;

import java.util.ArrayList;

/**
 * Created by sarha on 26-Apr-16.
 * Just handles on whether it's polyatomic of normal.
 */
public class ElementManager
{
	public static ArrayList<ChemicalName> elements(String chemicalCompound)
	{
		ArrayList<ChemicalName> polyatomicElementsList;
//		If polyatomic
		if( chemicalCompound.matches(".*\\(+.*")||chemicalCompound.matches(".*\\)+.*") )
		{
			polyatomicElementsList = Polyatomic.manager(chemicalCompound);
		}

//		If normal
		else
		{
			polyatomicElementsList = Normal.manager(chemicalCompound);
		}
		return polyatomicElementsList;
	}
}