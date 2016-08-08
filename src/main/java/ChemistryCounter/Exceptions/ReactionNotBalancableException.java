/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.Exceptions;

/**
 * Class Details:-
 * Author: Sarhad
 * User: sarha
 * Date: 07-Aug-16
 * Time : 1:55 AM
 * Project Name: chemistsCounter
 * Class Name: ReactionNotBalancableException
 */
public class ReactionNotBalancableException extends Exception
{
	
	/**
	 * The exception when Reaction cannot be balanced.
	 */
	public ReactionNotBalancableException()
	{
		super();
	}
	
	/**
	 * The exception when Reaction cannot be balanced.
	 *
	 * @param message The reason behind exception.
	 */
	public ReactionNotBalancableException(String message)
	{
		super(message);
	}
	
	/**
	 * The exception when Reaction cannot be balanced.
	 *
	 * @param message The reason behind exception.
	 * @param cause   The cause behind exception.
	 */
	public ReactionNotBalancableException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	/**
	 * The exception when Reaction cannot be balanced.
	 *
	 * @param cause The cause behind exception.
	 */
	public ReactionNotBalancableException(Throwable cause)
	{
		super(cause);
	}
}
