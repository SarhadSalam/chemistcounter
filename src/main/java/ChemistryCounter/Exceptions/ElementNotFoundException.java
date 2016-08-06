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
	public ElementNotFoundException()
	{
		super();
	}

	public ElementNotFoundException(String message)
	{
		super(message);
	}

	public ElementNotFoundException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public ElementNotFoundException(Throwable cause)
	{
		super(cause);
	}
}

