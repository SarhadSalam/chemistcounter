/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter;

import ChemistryCounter.ReactionManagers.ReactionCompounds;
import ChemistryCounter.SingleManager.ElementDetector.Universal.ChemicalName;

import java.util.ArrayList;

/**
 * Created by sarhaD on 28-Jun-16.
 * <p>
 * This is the universal detail getters and setters for any types of reactions or compounds
 */
public class UniversalGetters
{
	private ArrayList<ChemicalName> getProduct;
	private ArrayList<ChemicalName> reactant;
	private ArrayList<ReactionCompounds> getReactionCompounds;

	public ArrayList<ChemicalName> getReactant()
	{
		return reactant;
	}

	public ArrayList<ChemicalName> getProduct()
	{
		return getProduct;
	}

	public void setCn(ArrayList<ChemicalName> cn, ArrayList<ChemicalName> reactant)
	{
		this.getProduct = cn;
		this.reactant = reactant;
	}

	public ArrayList<ReactionCompounds> getReactionCompounds()
	{
		return getReactionCompounds;
	}

	public void setReactionCompounds(ArrayList<ReactionCompounds> getReactionCompounds)
	{
		this.getReactionCompounds = getReactionCompounds;
	}

}
