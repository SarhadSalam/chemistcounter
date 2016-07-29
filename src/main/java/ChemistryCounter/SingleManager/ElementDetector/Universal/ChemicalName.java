/*
 * Copyright (c) 2016. Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued..
 */

package ChemistryCounter.SingleManager.ElementDetector.Universal;

/**
 * Created by sarhaD on 23-May-16.
 * The place where all the magic happens. Creates an ArrayList data type. The methods in this file speak for themselves.
 */

public class ChemicalName
{
	public boolean reactionsRelation = false;
	private String symbol;
	private String chemicalName;
	private double atomicWeight;
	private int valenceElectron;
	private int count;
	private int multiValenceElectron;
	private double composition;
	private int reactionBalance;

	public String getChemicalSymbol()
	{
		return symbol;
	}

	public void setChemicalSymbol(String symbol)
	{
		this.symbol = symbol;
	}

	public int getValenceElectron()
	{

		if( multiValenceElectron != 0 )
		{
			return multiValenceElectron;
		}
		return valenceElectron;
	}

	public void setValenceElectron(int valenceElectron)
	{
		this.valenceElectron = valenceElectron;
	}

	public int getCount()
	{
		return count;
	}

	public void setCount(int count)
	{
		this.count = count;
	}

	public String getChemicalName()
	{
		return chemicalName;
	}

	public void setChemicalName(String chemicalName)
	{
		this.chemicalName = chemicalName;
	}

	public double getAtomicWeight()
	{
		return atomicWeight;
	}

	public void setAtomicWeight(double atomicWeight)
	{
		this.atomicWeight = atomicWeight;
	}

	public void setMultiValenceElectron(int multiValenceElectron)
	{
		this.multiValenceElectron = multiValenceElectron+this.multiValenceElectron;
	}

	public Double getComposition()
	{
		return composition;
	}

	public void setComposition(Double composition)
	{
		this.composition = composition;
	}

	public int getReactionBalance()
	{
		if( reactionsRelation )
		{
			return reactionBalance;
		}
		return 0;
	}

	public void setReactionBalance(int reactionBalance)
	{
		if( reactionsRelation )
		{
			this.reactionBalance = reactionBalance;
		}
	}
}
