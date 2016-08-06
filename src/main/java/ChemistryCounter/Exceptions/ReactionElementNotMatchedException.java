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
	public ReactionElementNotMatchedException() { super(); }
	public ReactionElementNotMatchedException(String message) { super(message); }
	public ReactionElementNotMatchedException(String message, Throwable cause) { super(message, cause); }
	public ReactionElementNotMatchedException(Throwable cause) { super(cause); }
}
