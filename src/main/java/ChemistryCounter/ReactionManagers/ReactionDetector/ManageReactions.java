/*
 * Copyright (c) 2016. Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued..
 */

package ChemistryCounter.ReactionManagers.ReactionDetector;

import ChemistryCounter.ReactionManagers.Manager;
import ChemistryCounter.ReactionManagers.ReactionCompounds;

import java.util.ArrayList;

/**
 * Created by sarhaD on 29-Jun-16.
 * <p>
 * This class is the algorithm used to manage reactions.
 */
public class ManageReactions
{
	public static ArrayList<ReactionCompounds> manageReactions(String input)
	{
		input = input.replaceAll("\\s", "");
		ArrayList<ReactionCompounds> reactionCompoundNames = new ArrayList<>();
		if( input.matches(".*\\++.*")||input.matches(".*=+.*")||input.matches(".*-+.*")||input.matches(".*>+.*") )
		{
			int equalPosition = 0;
			for( int i = 0; i<input.length(); i++ )
			{
				if( input.charAt(i) == '=' )
				{
					equalPosition = i;
				}
			}
			String reactants = input.substring(0, equalPosition);
			String[] leftSideOfReaction = reactants.split("\\+");
			for( String i : leftSideOfReaction )
			{
				ReactionCompounds reactionCompounds = new ReactionCompounds();
				reactionCompounds.setName(i);
				reactionCompounds.setCompoundStatus("Reactant");
				reactionCompoundNames.add(reactionCompounds);
				Manager.products = Manager.products+i;
			}
			String products = input.substring(equalPosition+1);
			String[] rightSideOfReaction = products.split("\\+");
			for( String i : rightSideOfReaction )
			{
				ReactionCompounds reactionCompounds = new ReactionCompounds();
				reactionCompounds.setName(i);
				reactionCompounds.setCompoundStatus("Product");
				reactionCompoundNames.add(reactionCompounds);
				Manager.reactants = Manager.reactants+i;
			}
		}
		return reactionCompoundNames;
	}
}
