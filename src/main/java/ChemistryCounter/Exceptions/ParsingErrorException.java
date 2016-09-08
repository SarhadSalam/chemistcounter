/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.Exceptions;

/**
 * Class Details:-
 * Author: Sarhad
 * User: sarha
 * Date: 08-Sep-16
 * Time : 1:03 PM
 * Project Name: chemistsCounter
 * Class Name: ParsingErrorException
 */
public class ParsingErrorException extends Exception
{
	
	public ParsingErrorException()
	{
		super();
	}
	
	public ParsingErrorException(String message)
	{
		super(message);
	}
	
	public ParsingErrorException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	public ParsingErrorException(Throwable cause)
	{
		super(cause);
	}
}
