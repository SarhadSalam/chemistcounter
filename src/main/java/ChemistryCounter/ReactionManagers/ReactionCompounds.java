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
	private String name;
	private String compoundStatus;
	private String originalName = "";
	private int reactionBalance;

	public int getReactionBalance()
	{
		return reactionBalance;
	}

	public void setReactionBalance(int reactionBalance)
	{
		this.reactionBalance = reactionBalance;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCompoundStatus()
	{
		return compoundStatus;
	}

	public void setCompoundStatus(String compoundStatus)
	{
		this.compoundStatus = compoundStatus;
	}

	public String getOriginalName()
	{
		return originalName;
	}

	public void setOriginalName(String originalName)
	{
		this.originalName = originalName;
	}
}
