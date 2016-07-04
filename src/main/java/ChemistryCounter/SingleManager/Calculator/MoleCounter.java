package ChemistryCounter.SingleManager.Calculator;

import ChemistryCounter.SingleManager.Cleaners.SignificantFigures;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by sarhaD on 27-May-16.
 * <p>
 * This calculates the mole.
 */
public class MoleCounter
{
	public static Double mole(Double mass, String userInput)
	{
		Double molar = MolarMassCounter.molar(userInput);
		return mass/molar;
	}

	public static BigDecimal atomMole(BigDecimal atom)
	{
		BigDecimal avoNumber = avogadroNumber();
		int round = SignificantFigures.roundingFigures(atom);
		return atom.divide(avoNumber, 500, RoundingMode.CEILING).abs(new MathContext(round));
	}

	public static BigDecimal avogadroNumber()
	{
		return new BigDecimal("6.0221415e23").round(new MathContext(8));
	}
}
