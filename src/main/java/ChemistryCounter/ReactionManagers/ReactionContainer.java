/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.ReactionManagers;

import ChemistryCounter.SingleManager.ElementParser.Universal.ElementDetails;

import java.util.ArrayList;

/**
 * Created by sarhaD on 28-Jun-16.
 * <p>
 * This is the universal detail getters and setters for any type of reactions or compounds. The class helps in managing
 * reactions.
 * <p>
 * The basic idea behind stochiometry is developed from the getters and setters in this class.
 */
public class ReactionContainer
{
	
	/**
	 * The variable getProduct stores the product as an array list.
	 */
	private ArrayList<ElementDetails> getProduct;
	
	/**
	 * The variable getReactant stores the product as an array list.
	 */
	private ArrayList<ElementDetails> getReactant;
	
	/**
	 * The variable getReactionCompounds stores the product as an array list.
	 */
	private ArrayList<ReactionCompounds> getReactionCompounds;
	
	/**
	 * The method getReactant gets the reactant in ArrayList.
	 *
	 * @return Reactant as an array list.
	 */
	public ArrayList<ElementDetails> getReactant()
	{
		return getReactant;
	}
	
	/**
	 * The method getProduct gets the product.
	 *
	 * @return Product Gets the product as an array list
	 */
	public ArrayList<ElementDetails> getProduct()
	{
		return getProduct;
	}
	
	/**
	 * The method getReactionCompounds gets the compounds in a reaction.
	 *
	 * @return Reaction Compounds
	 */
	public ArrayList<ReactionCompounds> getReactionCompounds()
	{
		return getReactionCompounds;
	}
	
	/**
	 * The method sets the list of entire compounds in a reaction.
	 *
	 * @param getReactionCompounds The list of entire compounds in a reaction.
	 */
	public void setReactionCompounds(ArrayList<ReactionCompounds> getReactionCompounds)
	{
		this.getReactionCompounds = getReactionCompounds;
	}
	
	/**
	 * The method sets chemical name involved in a reaction.
	 *
	 * @param getProduct  The product of an equation.
	 * @param getReactant The reactant of an equation.
	 */
	public void setCn(ArrayList<ElementDetails> getProduct, ArrayList<ElementDetails> getReactant)
	{
		this.getProduct = getProduct;
		this.getReactant = getReactant;
	}
	
}
