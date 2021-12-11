package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * 
 * Represents the backslash or slash as the division sign for its token
 * @author Jared Cordova
 */
public class SlashToken extends CharToken implements OperationInterface {
	public SlashToken() {
		super(CharConstants.SLASH);
	}
}
