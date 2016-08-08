/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.SingleManager.ElementDetector.Universal;

/**
 * Created by sarhaD on 23-May-16.
 * The place where all the magic happens. Creates an ArrayList data type. The methods in this file speak for themselves.
 */

public class ChemicalName
{
	
	/**
	 * The chemical symbol is stored.
	 */
	private String symbol;
	
	/**
	 * The chemical name is stored.
	 */
	private String chemicalName;
	
	/**
	 * The atomic weight is stored as double.
	 */
	private double atomicWeight;
	
	/**
	 * The valence electron is stored as int.
	 */
	private int valenceElectron;
	
	/**
	 * The atom count is stored as int
	 */
	private int count;
	
	/**
	 * The multivalenceelectron is set as int.
	 */
	private int multiValenceElectron;
	
	/**
	 * The composition is set in a compound.
	 */
	private double composition;
	
	/**
	 * The method gets chemical symbol
	 *
	 * @return Chemical Symbol
	 */
	public String getChemicalSymbol()
	{
		return symbol;
	}
	
	/**
	 * The method sets chemical name
	 *
	 * @param symbol The chemical symbol is passed in.
	 */
	public void setChemicalSymbol(String symbol)
	{
		this.symbol = symbol;
	}
	
	/**
	 * The method gets valence electron.
	 *
	 * @return valenceElectron
	 */
	public int getValenceElectron()
	{
		
		if( multiValenceElectron != 0 )
		{
			return multiValenceElectron;
		}
		return valenceElectron;
	}
	
	/**
	 * The method sets the valence electron of the element.
	 *
	 * @param valenceElectron valence electron of the element
	 */
	public void setValenceElectron(int valenceElectron)
	{
		this.valenceElectron = valenceElectron;
	}
	
	/**
	 * The method gets the count of atoms in a reaction and or compound.
	 *
	 * @return count
	 */
	public int getCount()
	{
		return count;
	}
	
	/**
	 * The method sets count.
	 *
	 * @param count The count of atoms
	 */
	public void setCount(int count)
	{
		this.count = count;
	}
	
	/**
	 * The method gets the element of the chemical name.
	 *
	 * @return Name of the element
	 */
	public String getChemicalName()
	{
		return chemicalName;
	}
	
	/**
	 * The method sets the chemical name.
	 *
	 * @param chemicalName Name of an element
	 */
	public void setChemicalName(String chemicalName)
	{
		this.chemicalName = chemicalName;
	}
	
	/**
	 * The method below gets the atomic weight.
	 *
	 * @return Atomic Weight
	 */
	public double getAtomicWeight()
	{
		return atomicWeight;
	}
	
	/**
	 * The method below sets the atomic weight.
	 *
	 * @param atomicWeight Atomic weight of the element
	 */
	public void setAtomicWeight(double atomicWeight)
	{
		this.atomicWeight = atomicWeight;
	}
	
	/**
	 * The method below sets the multi valence electron.
	 *
	 * @param multiValenceElectron Multi Valence Electron.
	 */
	public void setMultiValenceElectron(int multiValenceElectron)
	{
		this.multiValenceElectron = multiValenceElectron+this.multiValenceElectron;
	}
	
	/**
	 * The method below gets the composition.
	 *
	 * @return composition of the element in the compound
	 */
	public Double getComposition()
	{
		return composition;
	}
	
	/**
	 * The method below sets the composition.
	 *
	 * @param composition Composition
	 */
	public void setComposition(Double composition)
	{
		this.composition = composition;
	}
}
