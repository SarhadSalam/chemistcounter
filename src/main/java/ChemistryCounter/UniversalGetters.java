/*
 * Copyright (c) 2016. Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued..
 */

package ChemistryCounter;

import ChemistryCounter.ReactionManagers.ReactionCompounds;
import ChemistryCounter.SingleManager.ElementDetector.Universal.ChemicalName;

import java.util.ArrayList;

/**
 * Created by sarhaD on 28-Jun-16.
 * <p>
 * This is the universal detail getters and setters for any types of reactions or compounds
 */
public class UniversalGetters
{
	private ArrayList<ChemicalName> cn;
	private ArrayList<ReactionCompounds> rc;

	public ArrayList<ChemicalName> getCn()
	{
		return cn;
	}

	public void setCn(ArrayList<ChemicalName> cn)
	{
		this.cn = cn;
	}

	public ArrayList<ReactionCompounds> getRc()
	{
		return rc;
	}

	public void setRc(ArrayList<ReactionCompounds> rc)
	{
		this.rc = rc;
	}

}
