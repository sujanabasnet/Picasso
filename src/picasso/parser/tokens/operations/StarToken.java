package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the star or multiplication sign token
 * 
 */
public class StarToken extends CharToken implements OperationInterface {
	public StarToken() {
		super(CharConstants.STAR);
	}
}
