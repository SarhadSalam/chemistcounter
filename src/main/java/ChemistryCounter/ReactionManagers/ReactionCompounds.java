/*
 * Copyright (c) 2016. Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued..
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
	private int atomReactantOccurences;
	private int atomProductOccurences;

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

	public void setAtomReactantOccurences(int atomReactantOccurences)
	{
		this.atomReactantOccurences = atomReactantOccurences;
	}

	public int getAtomReactantOccurences()
	{

		return atomReactantOccurences;
	}

	public void setAtomProductOccurences(int atomProductOccurences)
	{
		this.atomProductOccurences = atomProductOccurences;
	}

	public int getAtomProductOccurences()
	{
		return atomProductOccurences;
	}
}
