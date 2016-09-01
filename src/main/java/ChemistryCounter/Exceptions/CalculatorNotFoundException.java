/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.Exceptions;

/**
 * Class Details:-
 * Author: Sarhad
 * User: sarha
 * Date: 19-Aug-16
 * Time : 7:02 PM
 * Project Name: chemistsCounter
 * Class Name: CalculatorNotFoundException
 * <p>
 * The class throws CalculatorNotFoundException
 */
public class CalculatorNotFoundException extends Exception
{
	
	/**
	 * The method CalculatorNotFoundException throws if no such calculator is not found.
	 */
	public CalculatorNotFoundException()
	{
		super();
	}
	
	/**
	 * The method CalculatorNotFoundException throws if no such calculator is not found.
	 *
	 * @param message The message for errors
	 */
	public CalculatorNotFoundException(String message)
	{
		super(message);
	}
	
	/**
	 * The method CalculatorNotFoundException throws if no such calculator is not found.
	 *
	 * @param message The message for errors
	 * @param cause   The cause for error
	 */
	public CalculatorNotFoundException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	/**
	 * The method CalculatorNotFoundException throws if no such calculator is not found.
	 *
	 * @param cause The cause for error
	 */
	public CalculatorNotFoundException(Throwable cause)
	{
		super(cause);
	}
	
	/**
	 * The method CalculatorNotFoundException throws if no such calculator is not found.
	 *
	 * @param message            The message for errors
	 * @param cause              The cause for error
	 * @param enableSuppression  Enable Supression of error
	 * @param writableStackTrace Enable if its writable
	 */
	protected CalculatorNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
