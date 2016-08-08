/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.ReactionManagers.ReactionDetector;

import ChemistryCounter.Exceptions.ElementNotFoundException;
import ChemistryCounter.Exceptions.ReactionElementNotMatchedException;
import ChemistryCounter.Exceptions.ReactionNotBalancableException;
import ChemistryCounter.ReactionManagers.ReactionCompounds;
import ChemistryCounter.SingleManager.ElementDetector.Universal.ChemicalName;
import ChemistryCounter.SingleManager.Summoner;
import ChemistryCounter.UniversalGetters;
import org.ejml.factory.SingularMatrixException;
import org.ejml.simple.SimpleMatrix;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sarhaD on 29-Jun-16.
 * <p>
 * The class ManageReactions is the algorithm used to balance reactions.
 */
public class ManageReactions
{
	
	/**
	 * The reactants are stored in the string getReactant.
	 */
	public static String getReactant = "";
	
	/**
	 * The products are stored in the string getProduct.
	 */
	public static String getProduct = "";
	
	/**
	 * The entire compound is stored in entireCompound.
	 */
	private static ArrayList<ReactionCompounds> entireCompound = new ArrayList<>();
	
	/**
	 * The method splitReactions below splits the reaction.
	 *
	 * @param input The user input
	 *
	 * @return the entire compound
	 */
	public static ArrayList<ReactionCompounds> splitReactions(String input)
	{
		input = input.replace(" ", "");
		for( int i = 0; i<input.length(); i++ )
		{
			if( input.charAt(i) == '-' && input.charAt(i+1) == '>' )
			{
				input = input.replace("-", "");
				input = input.replace(">", "=");
			}
		}
		setProduct(input);
		setReactant(input);
		return entireCompound;
	}
	
	/**
	 * The method setProduct below sets the product.
	 *
	 * @param input The user input
	 *
	 * @return product
	 */
	private static String setProduct(String input)
	{
		String product = "";
		for( int i = 0; i<input.length(); i++ )
		{
			if( input.charAt(i) == '=' )
			{
				product = input.substring(i+1);
			}
		}
		String[] compoundReactants = product.split("\\+");
		for( String i : compoundReactants )
		{
			ReactionCompounds rc = new ReactionCompounds();
			if( Character.isDigit(i.charAt(0)) )
			{
				rc.setOriginalName(i);
				i = fixCoefficent(i);
			}
			rc.setName(i);
			getProduct = getProduct+i;
			rc.setCompoundStatus("Product");
			entireCompound.add(rc);
		}
		return getProduct;
	}
	
	/**
	 * The method setReactant sets the reactant/
	 *
	 * @param input The input which is to be given only the reactant
	 *
	 * @return getReactant which contains the reactant
	 */
	private static String setReactant(String input)
	{
		String reactant = "";
		for( int i = 0; i<input.length(); i++ )
		{
			if( input.charAt(i) == '=' )
			{
				reactant = input.substring(0, i);
			}
		}
		String[] compoundProducts = reactant.split("\\+");
		for( String i : compoundProducts )
		{
			ReactionCompounds rc = new ReactionCompounds();
			if( Character.isDigit(i.charAt(0)) )
			{
				rc.setOriginalName(i);
				i = fixCoefficent(i);
			}
			rc.setName(i);
			getReactant = getReactant+i;
			rc.setCompoundStatus("Reactant");
			entireCompound.add(rc);
		}
		return getReactant;
	}
	
	/**
	 * The method below returns the compound in polyatomic form to avoid rewriting code. E.g. 2H2 would become (H2)2.
	 *
	 * @param element The element to get the coefficient
	 *
	 * @return compound in a polyatomic form.
	 *
	 * @see ChemistryCounter.SingleManager.ElementDetector.lib.Polyatomic
	 * @see Summoner
	 * @see ChemistryCounter.SingleManager.ElementDetector.lib.Normal
	 */
	private static String fixCoefficent(String element)
	{
		String compound;
		int polytaomic = 0;
		compound = element.replaceFirst("[\\d]*", "");
		Pattern pattern = Pattern.compile("[\\d]*");
		Matcher matcher = pattern.matcher(element);
		if( matcher.find() )
		{
			polytaomic = Integer.parseInt(matcher.group(0));
		}
		compound = "("+compound+")"+polytaomic;
		return compound;
	}
	
	/**
	 * The method setMatrix sets the complicated Matrix to balance the equation.
	 *
	 * @param u The universal matrix required to set the matrix. Later it is solved
	 *
	 * @return Solve matrix
	 *
	 * @throws ReactionNotBalancableException     Reaction cannot be balanced.
	 * @throws ReactionElementNotMatchedException Reaction cannot be matched with the given elements and compounds.
	 */
	public static Double[] setMatrix(UniversalGetters u) throws ReactionNotBalancableException, ReactionElementNotMatchedException
	{
		ArrayList<String> productList = new ArrayList<>();
		ArrayList<String> compounds = new ArrayList<>();

//		The steps below are verification steps
		for( ChemicalName product : u.getProduct() )
		{
			productList.add(product.getChemicalSymbol());
		}

//		The real tricks begin here
		for( ReactionCompounds rc : entireCompound )
		{
			compounds.add(rc.getName());
		}
		
		double[][] matrixRaw = new double[productList.size()][compounds.size()];

//		As this is complex logic for me, I will start writing doc here.
//		compounds contains all the compounds in the reaction. I will handle the negatives soon.
//		At this point, product list is equal to reactant list.
		
		for( int i = 0; i<productList.size(); i++ )
		{
			String symbol = productList.get(i);
			for( int j = 0; j<entireCompound.size(); j++ )
			{
				ArrayList<ChemicalName> cn = new ArrayList<>();
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
							matrixRaw[i][j] = ( chemicalName.getValenceElectron() );
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
	
	/**
	 * The method solveMatrix solves the matrix by inverting it.
	 *
	 * @param matrixRaw The 2D arrays containing matrixRaw.
	 *
	 * @return balanced matrix
	 *
	 * @throws ReactionNotBalancableException Reaction cannot be balanced.
	 */
	private static Double[] solveMatrix(double[][] matrixRaw) throws ReactionNotBalancableException
	{
		
		//		The matrix relationship for each equation will start at this point.
		int compound = matrixRaw[0].length;
		int element = matrixRaw.length;
		
		Double[] balanced;
		
		if( compound == element )
		{
			balanced = squareMatrix(matrixRaw, compound);
		} else
		{
			balanced = nullspaceMatrix(matrixRaw, compound, element);
		}
		
		return balanced;
	}
	
	/**
	 * The method square matrix is called in case the matrix created by the user input is a square matrix.
	 *
	 * @param matrixRaw The matrix raw which is double format
	 * @param compound  The compound length
	 *
	 * @return Balanced Nullspace Matrix
	 *
	 * @throws ReactionNotBalancableException The reaction could not be balanced.
	 */
	private static Double[] squareMatrix(double[][] matrixRaw, int compound) throws ReactionNotBalancableException
	{
		
		return balanceNullspaceMatrix(compound, matrixRaw);
	}
	
	private static Double[] nullspaceMatrix(double[][] matrixRaw, int compound, int element) throws ReactionNotBalancableException
	{
		//		The matrix int conversion to double.
		double[][] matrixRawDouble = new double[element+1][compound];
		
		for( int i = 0; i<element; i++ )
		{
			System.arraycopy(matrixRaw[i], 0, matrixRawDouble[i], 0, compound);
		}
		matrixRawDouble[element][compound-1] = 1;
		
		return balanceNullspaceMatrix(compound, matrixRawDouble);
	}
	
	/**
	 * The method balanceNullspaceMatrix below balances the nullspace matrix.
	 *
	 * @param compound        The compound amount
	 * @param matrixRawDouble The 2D Double Matrix Raw
	 *
	 * @return Transpose nullspace vector
	 *
	 * @throws ReactionNotBalancableException Reaction cannot be balanced.
	 */
	private static Double[] balanceNullspaceMatrix(int compound, double[][] matrixRawDouble) throws ReactionNotBalancableException
	{
		SimpleMatrix simpleMatrix = new SimpleMatrix(matrixRawDouble);
		SimpleMatrix inverted;
		try
		{
			inverted = simpleMatrix.invert();
		} catch( IllegalArgumentException e )
		{
			throw new ReactionNotBalancableException("There is an infinite amount of ways to solve this equation.");
		} catch( SingularMatrixException e )
		{
			for( int i = 0; i<simpleMatrix.numCols()-1; i++ )
			{
				simpleMatrix.set(simpleMatrix.numRows()-1, i, 0);
			}
			inverted = simpleMatrix.invert();
		}
		Double[] transpose = new Double[compound];
		for( int i = 0; i<compound; i++ )
		{
			transpose[i] = ( inverted.get(i, compound-1) );
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

//		The sum list is created to verify whether the reaction is balancable
		
		for( int i = 0; i<transpose.length; i++ )
		{
			transpose[i] = transpose[i]/minTranpose;
			transpose[i] = (double) Math.round(transpose[i]);
		}
		
		return transpose;
	}
}
