/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.Exceptions;

/**
 * Class Details:-
 * Author: Sarhad
 * User: sarha
 * Date: 06-Aug-16
 * Time : 6:24 PM
 * Project Name: chemistsCounter
 * Class Name: ReactionElementNotMatchedException
 */
public class ReactionElementNotMatchedException extends Exception
{
	
	/**
	 * The exception when Reaction cannot be matched.
	 */
	public ReactionElementNotMatchedException()
	{
		super();
	}
	
	/**
	 * The exception when Reaction cannot be matched.
	 *
	 * @param message The reason behind exception.
	 */
	public ReactionElementNotMatchedException(String message)
	{
		super(message);
	}
	
	/**
	 * The exception when Reaction cannot be matched.
	 *
	 * @param message The reason behind exception.
	 * @param cause   The cause behind exception.
	 */
	public ReactionElementNotMatchedException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	/**
	 * The exception when Reaction cannot be matched.
	 *
	 * @param cause The cause behind exception.
	 */
	public ReactionElementNotMatchedException(Throwable cause)
	{
		super(cause);
	}
}
