/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.ReactionManagers;

import ChemistryCounter.ReactionManagers.ReactionDetector.ReactionManager;
import ChemistryCounter.SingleManager.ParseElements;

/**
 * Created by sarhaD on 27-Jun-16.
 * <p>
 * This class ReactionCompounds returns and sets the reaction compounds.
 */
public class ReactionCompounds
{
	
	/**
	 * The name is stored in name
	 */
	private String name;
	
	/**
	 * The compoundStatus is stored in compoundStatus
	 */
	private String compoundStatus;
	
	/**
	 * The originalName is stored in originalName
	 */
	private String originalName = "";
	
	/**
	 * The mole of a compound is stored as a double.
	 */
	private double moleOfCompound;
	
	/**
	 * The reactionBalance is stored in reactionBalance
	 */
	private int reactionBalance;
	/**
	 * The limiting reagent of a reactant is stored in limitingReagent.
	 */
	private boolean limitingReagent = false;
	/**
	 * The variable below sets the molar mass of a compound.
	 */
	private double molarMassOfCompound;
	
	public boolean isLimitingReagent()
	{
		return limitingReagent;
	}
	
	public void setLimitingReagent(boolean limitingReagent)
	{
		this.limitingReagent = limitingReagent;
	}
	
	/**
	 * The method getMolarMassOfCompound gets the molar mass of a compound.
	 *
	 * @return The molar mass of a compound.
	 */
	public double getMolarMassOfCompound()
	{
		return molarMassOfCompound;
	}
	
	/**
	 * The method setMolarMassOfCompound sets the molar mass of a compound.
	 *
	 * @param molarMassOfCompound The molar mass of a compound.
	 */
	public void setMolarMassOfCompound(double molarMassOfCompound)
	{
		this.molarMassOfCompound = molarMassOfCompound;
	}
	
	/**
	 * The method getMoleOfCompound gets the moles of compounds.
	 *
	 * @return The moles of compounds.
	 */
	public double getMoleOfCompound()
	{
		return moleOfCompound;
	}
	
	/**
	 * The method setMoleOfCompound sets the moles of compounds.
	 *
	 * @param moleOfCompound The mole of a compound
	 */
	public void setMoleOfCompound(double moleOfCompound)
	{
		this.moleOfCompound = moleOfCompound;
	}
	
	/**
	 * The method getReactionBalance gets reactions balance.
	 *
	 * @return reaction balance
	 */
	public int getReactionBalance()
	{
		return reactionBalance;
	}
	
	/**
	 * The method setReactionBalance sets reactions balance
	 *
	 * @param reactionBalance The reaction balance
	 */
	public void setReactionBalance(int reactionBalance)
	{
		this.reactionBalance = reactionBalance;
	}
	
	/**
	 * The method getName gets element or compound name
	 *
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * The method setName sets the element or compound name
	 *
	 * @param name The name of reaction name.
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * The method getCompoundStatus sets the compound status.
	 *
	 * @return compoundStatus
	 */
	public String getCompoundStatus()
	{
		return compoundStatus;
	}
	
	/**
	 * The method setCompoundStatus sets the compound status (whether its a product or reactant).
	 *
	 * @param compoundStatus The compound status
	 */
	public void setCompoundStatus(String compoundStatus)
	{
		this.compoundStatus = compoundStatus;
	}
	
	/**
	 * The method is not always used however is used in case the original name is 2H2 and is converted to (H2)2.
	 *
	 * @return originalName
	 *
	 * @see ChemistryCounter.SingleManager.ElementParser.lib.Polyatomic
	 * @see ChemistryCounter.SingleManager.ElementParser.lib.Normal
	 * @see ParseElements
	 * @see ReactionManager
	 */
	public String getOriginalName()
	{
		return originalName;
	}
	
	/**
	 * The method sets the original names.
	 *
	 * @param originalName The original names
	 */
	public void setOriginalName(String originalName)
	{
		this.originalName = originalName;
	}
}
