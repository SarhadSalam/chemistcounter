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
	
	/**
	 * The variable getProduct stores the product as an array list.
	 */
	private ArrayList<ChemicalName> getProduct;
	
	/**
	 * The variable getReactant stores the product as an array list.
	 */
	private ArrayList<ChemicalName> getReactant;
	
	/**
	 * The variable getReactionCompounds stores the product as an array list.
	 */
	private ArrayList<ReactionCompounds> getReactionCompounds;
	
	/**
	 * The method getProduct gets the reactant in ArrayList.
	 *
	 * @return getReactant.
	 */
	public ArrayList<ChemicalName> getReactant()
	{
		return getReactant;
	}
	
	/**
	 * The method getProduct gets the product in ArrayList.
	 *
	 * @return getProduct.
	 */
	public ArrayList<ChemicalName> getProduct()
	{
		return getProduct;
	}
	
	/**
	 * The method getProduct gets the compounds in a reaction in ArrayList.
	 *
	 * @return getReactionCompounds.
	 */
	public ArrayList<ReactionCompounds> getReactionCompounds()
	{
		return getReactionCompounds;
	}
	
	/**
	 * The method sets the list of entire compounds.
	 *
	 * @param getReactionCompounds The list of entire compounds in a reaction.
	 */
	public void setReactionCompounds(ArrayList<ReactionCompounds> getReactionCompounds)
	{
		this.getReactionCompounds = getReactionCompounds;
	}
	
	/**
	 * The method sets chemical name.
	 *
	 * @param getProduct  The product of an equation.
	 * @param getReactant The reactant of an equation.
	 */
	public void setCn(ArrayList<ChemicalName> getProduct, ArrayList<ChemicalName> getReactant)
	{
		this.getProduct = getProduct;
		this.getReactant = getReactant;
	}
	
}
