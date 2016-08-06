/*
 * Copyright (c) 2016. Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued..
 */

package ChemistryCounter.ReactionManagers.ReactionDetector;

import ChemistryCounter.Exceptions.ElementNotFoundException;
import ChemistryCounter.ReactionManagers.ReactionCompounds;
import ChemistryCounter.SingleManager.ElementDetector.Universal.ChemicalName;
import ChemistryCounter.Summoner;
import ChemistryCounter.UniversalGetters;
import org.ejml.simple.SimpleMatrix;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sarhaD on 29-Jun-16.
 * <p>
 * This class is the algorithm used to manage reactions.
 */
public class ManageReactions
{
	public static String getReactant = "";
	public static String getProduct = "";
	private static ArrayList<ReactionCompounds> entireCompound = new ArrayList<>();

	public static ArrayList<ReactionCompounds> splitReactions(String input)
	{
		input = input.replace(" ", "");
		for( int i = 0; i<input.length(); i++ )
		{
			if( input.charAt(i) == '-'&&input.charAt(i+1) == '>' )
			{
				input = input.replace("-", "");
				input = input.replace(">", "=");
			}
		}
		setProduct(input);
		setReactant(input);
		return entireCompound;
	}

	private static String setReactant(String input)
	{
		String reactant = "";
		for( int i = 0; i<input.length(); i++ )
		{
			if( input.charAt(i) == '=' )
			{
				reactant = input.substring(i+1);
			}
		}
		String[] compoundReactants = reactant.split("\\+");
		for( String i : compoundReactants )
		{
			ReactionCompounds rc = new ReactionCompounds();
			rc.setName(i);
			getReactant = getReactant+i;
			rc.setCompoundStatus("Reactant");
			entireCompound.add(rc);
		}
		return reactant;
	}

	private static String setProduct(String input)
	{
		String product = "";
		for( int i = 0; i<input.length(); i++ )
		{
			if( input.charAt(i) == '=' )
			{
				product = input.substring(0, i);
			}
		}
		String[] compoundProducts = product.split("\\+");
		for( String i : compoundProducts )
		{
			ReactionCompounds rc = new ReactionCompounds();
			rc.setName(i);
			getProduct = getProduct+i;
			rc.setCompoundStatus("Product");
			entireCompound.add(rc);
		}
		return product;
	}

	public static UniversalGetters setMatrix(UniversalGetters u)
	{
		ArrayList<String> productList = new ArrayList<>();
		ArrayList<String> reactantList = new ArrayList<>();
		ArrayList<String> compounds = new ArrayList<>();

//		The steps below are verification steps
		for( ChemicalName product : u.getProduct() )
		{
			productList.add(product.getChemicalSymbol());
		}
		for( ChemicalName reactant : u.getReactant() )
		{
			reactantList.add(reactant.getChemicalSymbol());
		}
		if( productList.size() != reactantList.size() )
		{
			return null;
		}
		for( int i = 0; i<productList.size(); i++ )
		{
			if( !(productList.get(i).equals(reactantList.get(i))) )
			{
				return null;
			}
		}

//		The real tricks begin here
//		TODO: The simple matrix will take the input productList.size and compound list.
		for( ReactionCompounds rc : entireCompound )
		{
			compounds.add(rc.getName());
		}

		int[][] matrixRaw = new int[productList.size()][compounds.size()];

//		As this is complex logic for me, I will start writing doc here.
//		compounds contains all the compounds in the reaction. I will handle the negatives soon.
//		At this point, product list is equal to reactant list.

		for( int i = 0; i<productList.size(); i++ )
		{
			String symbol = productList.get(i);
			for( int j = 0; j<entireCompound.size(); j++ )
			{
				ArrayList<ChemicalName> cn = null;
				try
				{
					cn = Summoner.summoner(entireCompound.get(j).getName());
				} catch( ElementNotFoundException e )
				{
					e.printStackTrace();
				}
				for( ChemicalName chemicalName : cn )
				{
					if( chemicalName.getChemicalSymbol().equals(symbol) )
					{
						if( entireCompound.get(j).getCompoundStatus().equals("Product") )
						{
//							matrixRaw[i][j] = -(chemicalName.getValenceElectron());
							matrixRaw[i][j] = (chemicalName.getValenceElectron());
						} else
						{
							matrixRaw[i][j] = chemicalName.getValenceElectron();
						}
					}
				}
			}
		}
		return solveMatrix(matrixRaw);
	}

	public static UniversalGetters solveMatrix(int[][] matrixRaw)
	{

		//		The matrix relationship for each equation will start at this point.
		int compound = matrixRaw[0].length;
		int element = matrixRaw.length;

		Double[] balanced = new Double[compound-1];

		if( compound == element )
		{
			System.out.println("Square matrix deal later biatch");
			return null;

//			TODO: Work with square matrices
		} else
		{
			balanced = nullspaceMatrix(matrixRaw, compound, element);
			System.out.println(Arrays.toString(balanced));
		}

		return null;
	}

	private static Double[] nullspaceMatrix(int[][] matrixRaw, int compound, int element)
	{
		//		The matrix int conversion to double.
		double[][] matrixRawDouble = new double[element+1][compound];

		for( int i = 0; i<element; i++ )
		{
			for( int j = 0; j<compound; j++ )
			{
				matrixRawDouble[i][j] = matrixRaw[i][j];
			}
		}
		matrixRawDouble[element][compound-1] = 1;

		SimpleMatrix simpleMatrix = new SimpleMatrix(matrixRawDouble);
		SimpleMatrix inverted = simpleMatrix.invert();

		Double[] transpose = new Double[compound];
		for( int i = 0; i<compound; i++ )
		{
			transpose[i] = (inverted.get(i, compound-1));
		}

//		Caclulates the minimum tranpose multi-dim vector regardless of magnitude.
		double minTranpose = 0;
		for( Double aTranspose : transpose )
		{
			double tempMin = Math.abs(aTranspose);
			if( minTranpose == 0 )
			{
				minTranpose = tempMin;
			} else
			{
				if( tempMin<minTranpose )
				{
					minTranpose = tempMin;
				}
			}
		}

		for( int i = 0; i<transpose.length; i++ )
		{
			transpose[i] = transpose[i]/minTranpose;
			transpose[i] = (double) Math.round(transpose[i]);
		}

		return transpose;
	}
}
