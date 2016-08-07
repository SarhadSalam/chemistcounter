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
	/**
	 * The method elements below determines whether its polyatomic or normal and forwards it to Polyatomic manager of Normal manager.
	 *
	 * @param chemicalCompound The chemical compound that was inputted by the user, which is forwarded by the summoner.
	 * @return elementsList
	 */
	public static ArrayList<ChemicalName> elements(String chemicalCompound)
	{
		ArrayList<ChemicalName> elementsList;
//		If polyatomic
		if( chemicalCompound.matches(".*\\(+.*")||chemicalCompound.matches(".*\\)+.*") )
		{
			elementsList = Polyatomic.manager(chemicalCompound);
		}

//		If normal
		else
		{
			elementsList = Normal.manager(chemicalCompound);
		}
		return elementsList;
	}
}