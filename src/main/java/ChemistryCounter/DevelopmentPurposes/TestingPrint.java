/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.DevelopmentPurposes;

import ChemistryCounter.ReactionManagers.ReactionCompounds;
import ChemistryCounter.SingleManager.ElementDetector.Universal.ChemicalName;
import ChemistryCounter.UniversalGetters;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by sarhaD on 26-May-16.
 * This is the development purposes for looping prints.
 */
public class TestingPrint
{
	/**
	 * The method print compound print compounds.
	 *
	 * @param list The list.
	 */
	public static void printCompounds(ArrayList<ChemicalName> list)
	{
		ArrayList<String> methods = new ArrayList<>();
		Class c = ChemicalName.class;
		Method[] n = c.getDeclaredMethods();
		for( Method i : n )
		{
			if( i.getName().contains("get")&&i.getTypeParameters().length == 0 )
			{
				methods.add(i.getName());
			}
		}
		System.out.println();
		System.out.format("%10s%15s%15s%20s%15s%15s%20s", "Chemical Symbol", "Chemical Name", "Atomic weight", "Valence Electron", "Atom Count", "Composition", "Reaction Balance");
		for( ChemicalName s : list )
		{
			System.out.println();
			System.out.format("%10s%15s%15s%20d%15s%20s", s.getChemicalSymbol(), s.getChemicalName(), s.getAtomicWeight(), s.getValenceElectron(), s.getCount(), s.getComposition());
		}
		System.out.println("\n");
	}

	/**
	 * The method print compound print reactions.
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
			if( i.getName().contains("get")&&i.getTypeParameters().length == 0 )
			{
				methods.add(i.getName());
			}
		}
		for( ReactionCompounds r : reactionCompoundNames )
		{
			System.out.println();
			System.out.format("%10s%10s%20s", r.getName(), r.getOriginalName(), r.getCompoundStatus());
		}
	}

	/**
	 * The method below prints equations.
	 *
	 * @param u Univer getters
	 */
	public static void printEquations(UniversalGetters u)
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
}
