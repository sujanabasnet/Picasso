package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * @author Jared Cordova
 * Represents the backslash or slash as the division sign for its token
 * 
 */
public class SlashToken extends CharToken implements OperationInterface {
	public SlashToken() {
		super(CharConstants.SLASH);
	}
}
