/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.ReactionManagers;

/**
 * Created by sarhaD on 27-Jun-16.
 * <p>
 * This class is returns and sets the reaction compounds.
 */
public class ReactionCompounds
{
	/**
	 * The name is stored below
	 */
	private String name;

	/**
	 * The compoundStatus is stored below
	 */
	private String compoundStatus;

	/**
	 * The originalName is stored below
	 */
	private String originalName = "";

	/**
	 * The reactionBalance is stored below
	 */
	private int reactionBalance;

	/**
	 * The method gets reactions balance.
	 *
	 * @return reaction balance
	 */
	public int getReactionBalance()
	{
		return reactionBalance;
	}

	/**
	 * The method sets reactions balance
	 *
	 * @param reactionBalance The reaction balance
	 */
	public void setReactionBalance(int reactionBalance)
	{
		this.reactionBalance = reactionBalance;
	}

	/**
	 * The method gets name
	 *
	 * @return name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * The method sets the reaction name
	 *
	 * @param name The name of reaction name.
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * The method sets the compound status.
	 *
	 * @return compoundStatus
	 */
	public String getCompoundStatus()
	{
		return compoundStatus;
	}

	/**
	 * The method sets the compound status.
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
	 * @see ChemistryCounter.SingleManager.ElementDetector.lib.Polyatomic
	 * @see ChemistryCounter.SingleManager.ElementDetector.lib.Normal
	 * @see ChemistryCounter.Summoner
	 * @see ChemistryCounter.ReactionManagers.ReactionDetector.ManageReactions
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
