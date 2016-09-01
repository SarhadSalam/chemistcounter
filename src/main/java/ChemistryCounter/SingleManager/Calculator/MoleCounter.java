/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.SingleManager.Calculator;

import ChemistryCounter.Converters.MassConverter;
import ChemistryCounter.Exceptions.ElementNotFoundException;
import ChemistryCounter.SingleManager.Cleaners.SignificantFigures;
import ChemistryCounter.SingleManager.ElementDetector.Universal.ChemicalName;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * Created by sarhaD on 27-May-16.
 * <p>
 * The class MoleCounter calculates the mole of a substance.
 */
public class MoleCounter
{
	
	/**
	 * The method mole converts the user input into moles in a given mass.
	 *
	 * @param mass      The mass of the element/compound for which mole to be calculated.
	 * @param userInput The user input is the element/compound.
	 * @param massUnit  The massUnit.
	 *
	 * @return The mole.
	 *
	 * @throws IOException                  There is no files found.
	 * @throws SAXException                 No idea what this is
	 * @throws ParserConfigurationException The xml parser failed.
	 * @throws ElementNotFoundException     The element was not found.
	 */
	public static BigDecimal mole(Double mass, String userInput, String massUnit) throws IOException, SAXException, ParserConfigurationException, ElementNotFoundException
	{
		Double molar = MolarMassCounter.molar(userInput);
		return getMoleBigDecimal(mass, molar, massUnit);
	}
	
	/**
	 * The Method to find mole.
	 *
	 * @param mass     The mass
	 * @param cn       The preformatted ChemicalName ArrayList
	 * @param massUnit The String massUnit
	 *
	 * @return The Mole in BigDecimals.
	 */
	public static BigDecimal mole(Double mass, ArrayList<ChemicalName> cn, String massUnit)
	{
		Double molar = MolarMassCounter.molar(cn);
		return getMoleBigDecimal(mass, molar, massUnit);
	}
	
	/**
	 * The method refactored to prevent code rewriting.
	 *
	 * @param mass     The mass
	 * @param molar    The molar mass.
	 * @param massUnit The massUnit String.
	 *
	 * @return BigDecimalMole
	 */
	private static BigDecimal getMoleBigDecimal(Double mass, Double molar, String massUnit)
	{
		
		mass = MassConverter.findOperation(massUnit, mass);
		BigDecimal bd = new BigDecimal(mass);
		int round = SignificantFigures.roundingFigures(bd);
		return new BigDecimal(mass/molar).abs(new MathContext(round));
	}
	
	/**
	 * The method atomMole finds the mole in atoms of the element/compound.
	 *
	 * @param atom The amount of moles in an atom.
	 *
	 * @return The moles in an atom.
	 */
	public static BigDecimal atomMole(BigDecimal atom)
	{
		BigDecimal avoNumber = avogadroNumber();
		int round = SignificantFigures.roundingFigures(atom);
		return atom.divide(avoNumber, 500, RoundingMode.CEILING).abs(new MathContext(round));
	}
	
	/**
	 * The method avogadroNumber just fetches the avogadro number. A separate method was created just because I found it
	 * to be amusing. I am such a huge dork.
	 *
	 * @return Avogadro's Number
	 */
	private static BigDecimal avogadroNumber()
	{
		return new BigDecimal("6.0221415e23").round(new MathContext(8));
	}
}
