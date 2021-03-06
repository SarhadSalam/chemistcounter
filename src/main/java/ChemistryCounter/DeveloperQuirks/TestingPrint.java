/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.DeveloperQuirks;

import ChemistryCounter.ReactionManagers.ReactionCompounds;
import ChemistryCounter.SingleManager.ElementParser.Universal.ElementDetails;
import ChemistryCounter.ReactionManagers.ReactionContainer;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by sarhaD on 26-May-16.
 * This is the development purposes for looping prints.
 */
public class TestingPrint
{
	
	/**
	 * The method printEquations below prints equations.
	 *
	 * @param u Universal getters
	 */
	public static void printEquations(ReactionContainer u)
	{
		System.out.println("Prodcuts:-");
		TestingPrint.printCompounds(u.getProduct());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\t````````````````");
		System.out.println("Reactants:-");
		TestingPrint.printCompounds(u.getReactant());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\t````````````````");
		System.out.println("Reaction Compounds:-");
		TestingPrint.printReactions(u.getReactionCompounds());
		System.out.println();
	}
	
	/**
	 * The method printCompounds prints compounds.
	 *
	 * @param list The list.
	 */
	public static void printCompounds(ArrayList<ElementDetails> list)
	{
		ArrayList<String> methods = new ArrayList<>();
		Class c = ElementDetails.class;
		Method[] n = c.getDeclaredMethods();
		for( Method i : n )
		{
			if( i.getName().contains("get") && i.getTypeParameters().length == 0 )
			{
				methods.add(i.getName());
			}
		}
		System.out.println();
		System.out.format("%10s%15s%15s%20s%15s%20s", "Chemical Symbol", "Chemical Name", "Atomic weight", "Valence Electron", "Atom Count", "Composition");
		for( ElementDetails s : list )
		{
			System.out.println();
			System.out.format("%10s%15s%15s%20d%15s%20s", s.getChemicalSymbol(), s.getChemicalName(), s.getAtomicWeight(), s.getValenceElectron(), s.getCount(), s.getComposition());
		}
		System.out.println("\n");
	}
	
	/**
	 * The method printReactions prints reactions.
	 *
	 * @param reactionCompoundNames The list.
	 */
	public static void printReactions(ArrayList<ReactionCompounds> reactionCompoundNames)
	{
		ArrayList<String> methods = new ArrayList<>();
		Class c = ReactionCompounds.class;
		Method[] n = c.getDeclaredMethods();
		for( Method i : n )
		{
			if( i.getName().contains("get") && i.getTypeParameters().length == 0 )
			{
				methods.add(i.getName());
			}
		}
		System.out.format("%10s%20s%20s%20s%20s%20s", "Name", "Original", "Reaction Balance", "Compound Status", "Molar Mass", "Mole");
		for( ReactionCompounds r : reactionCompoundNames )
		{
			System.out.println();
			System.out.format("%10s%20s%20d%20s%20s%20s", r.getName(), r.getOriginalName(), r.getReactionBalance(), r.getCompoundStatus(), r.getMolarMassOfCompound(), r.getMoleOfCompound());
		}
	}
}
