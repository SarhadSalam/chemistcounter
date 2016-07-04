/*
 * Copyright (c) 2016. Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued..
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
		String tabs = "\t\t\t\t";
		System.out.println("Chemical Symbol\t Chemical Name\t Atomic weight\t Valence Electron\t Atom Count\t Composition \t Reaction Balance\t");
		for( ChemicalName s : list )
		{
			System.out.println(s.getChemicalSymbol()+tabs+s.getChemicalName()+tabs+s.getAtomicWeight()+tabs+s.getValenceElectron()+tabs+s.getCount()+tabs+s.getComposition()+tabs+s.getReactionBalance());
		}
	}

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
		String tabs = "\t\t\t\t";
		for( ReactionCompounds r : reactionCompoundNames )
		{
			System.out.println(r.getName()+tabs+r.getCompoundStatus()+tabs);
		}

	}

	public static void printEquations(UniversalGetters u)
	{
		System.out.println("Prodcuts");
		TestingPrint.printCompounds(u.getProduct());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\t````````````````");
		System.out.println("Reactants");
		TestingPrint.printCompounds(u.getReactant());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\t````````````````");
		System.out.println("Reaction Compounds");
		TestingPrint.printReactions(u.getReactionCompounds());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\t````````````````");
	}
}
