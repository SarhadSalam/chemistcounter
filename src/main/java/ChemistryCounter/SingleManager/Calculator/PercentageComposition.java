package ChemistryCounter.SingleManager.Calculator;

import ChemistryCounter.SingleManager.ElementDetector.Universal.ChemicalName;

import java.util.ArrayList;

/**
 * Created by sarhaD on 29-May-16.
 * <p>
 * This calculates the percentage composition of any compound.
 */
public class PercentageComposition
{
	public static void percentage(ArrayList<ChemicalName> compound)
	{
		ArrayList<Double> list = new ArrayList<>();
		Double molarMass = MolarMassCounter.molarCounter(compound);

		for( ChemicalName item : compound )
		{
			Double compositionPercent = ((item.getAtomicWeight()*item.getValenceElectron())/molarMass)*100;
			item.setComposition(compositionPercent);
		}
	}
}
