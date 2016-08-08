/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.Exceptions;

/**
 * Class Details:-
 * Author: Sarhad
 * User: sarha
 * Date: 06-Aug-16
 * Time : 6:05 PM
 * Project Name: chemistsCounter
 * Class Name: ElementNotFoundException
 */
public class ElementNotFoundException extends Exception
{
	
	/**
	 * The exception is thrown when Element is invalid.
	 */
	public ElementNotFoundException()
	{
		super();
	}
	
	/**
	 * The exception is thrown when Element is invalid.
	 *
	 * @param message The message for the exception.
	 */
	public ElementNotFoundException(String message)
	{
		super(message);
	}
	
	/**
	 * The exception is thrown when Element is invalid.
	 *
	 * @param message The message for the exception.
	 * @param cause   The cause for the exception
	 */
	public ElementNotFoundException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	/**
	 * The exception is thrown when Element is invalid.
	 *
	 * @param cause The cause for the exception
	 */
	public ElementNotFoundException(Throwable cause)
	{
		super(cause);
	}
}

