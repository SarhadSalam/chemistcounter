/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.Sorters;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class Details:-
 * Author: Sarhad
 * User: sarha
 * Date: 19-Aug-16
 * Time : 7:16 PM
 * Project Name: chemistsCounter
 * Class Name: SortList
 *
 * The class sortList sorts the calculator created for android.
 */
public class SortList
{
	
	/**
	 * The method functions sorts the List on functions
	 * @return  name TO array.
	 */
	public static String[] functions()
	{
		ArrayList<String> name = new ArrayList<>();
		
		name.add("Percentage Composition");
		name.add("Molar Mass");
		name.add("Mole");
		
		Collections.sort(name);
		
		return name.toArray(new String[0]);
	}
}
