package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * 
 * Represents the exclamation point of negate for its token
 * @author Jared Cordova
 */
public class BangToken extends CharToken implements OperationInterface {
	public BangToken() {
		super(CharConstants.BANG);
	}
}