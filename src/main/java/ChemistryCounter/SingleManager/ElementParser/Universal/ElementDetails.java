/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.SingleManager.ElementParser.Universal;

/**
 * Created by sarhaD on 23-May-16. The getters and setters in ElementInformation contain various details of specific elements.
 * <p>
 * The details which have a getter and setter in the following class contains: 1. Chemical Symbol 2. Chemical Name 3.
 * Atomic Weight 4. Valence Electron (The valence electron is rather a wrong term, because the valence electron in this
 * case is just the number of electrons the element contains according to the user input. 5. Count of atoms 6. Multi
 * valence electron takes effect in case the compound given is polyatomic. 7. Composition sets the amount in percentage
 * an element is present in a compound.
 */

public class ElementDetails
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
	 * The multi valence electron is set as int.
	 */
	private int multiValenceElectron;
	
	/**
	 * The composition is set in a compound.
	 */
	private double composition;
	
	/**
	 * The method getChemicalSymbol gets chemical symbol
	 *
	 * @return Chemical Symbol
	 */
	public String getChemicalSymbol()
	{
		return symbol;
	}
	
	/**
	 * The method setChemicalSymbol sets chemical name
	 *
	 * @param symbol The chemical symbol is passed in.
	 */
	public void setChemicalSymbol(String symbol)
	{
		this.symbol = symbol;
	}
	
	/**
	 * The method getValenceElectron gets valence electron.
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
	 * The method setValenceElectron sets the valence electron of the element.
	 *
	 * @param valenceElectron valence electron of the element
	 */
	public void setValenceElectron(int valenceElectron)
	{
		this.valenceElectron = valenceElectron;
	}
	
	/**
	 * The method getCount gets the count of atoms in a reaction and or compound.
	 *
	 * @return count
	 */
	public int getCount()
	{
		return count;
	}
	
	/**
	 * The method setCount sets count.
	 *
	 * @param count The count of atoms in an element.
	 */
	public void setCount(int count)
	{
		this.count = count;
	}
	
	/**
	 * The method getChemicalName gets the element of the chemical name.
	 *
	 * @return Name of the element
	 */
	public String getChemicalName()
	{
		return chemicalName;
	}
	
	/**
	 * The method setChemicalName sets the chemical name.
	 *
	 * @param chemicalName Name of the element
	 */
	public void setChemicalName(String chemicalName)
	{
		this.chemicalName = chemicalName;
	}
	
	/**
	 * The method getAtomicWeight below gets the atomic weight.
	 *
	 * @return Atomic Weight
	 */
	public double getAtomicWeight()
	{
		return atomicWeight;
	}
	
	/**
	 * The method setAtomicWeight below sets the atomic weight.
	 *
	 * @param atomicWeight Atomic weight of the element
	 */
	public void setAtomicWeight(double atomicWeight)
	{
		this.atomicWeight = atomicWeight;
	}
	
	/**
	 * The method setMultiValenceElectron below sets the multi valence electron.
	 *
	 * @param multiValenceElectron Multi Valence Electron in a polyatomic element.
	 */
	public void setMultiValenceElectron(int multiValenceElectron)
	{
		this.multiValenceElectron = multiValenceElectron+this.multiValenceElectron;
	}
	
	/**
	 * The method getComposition below gets the composition.
	 *
	 * @return composition of the element in the compound
	 */
	public Double getComposition()
	{
		return composition;
	}
	
	/**
	 * The method setComposition below sets the composition.
	 *
	 * @param composition Composition of the element in a compound.
	 */
	public void setComposition(Double composition)
	{
		this.composition = composition;
	}
}
