package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Negate;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the slash or division function.
 * 
 * @author Robert C. Duvall
 * @author Jared Cordova
 * 
 */
public class BangAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Remove the slash token
		// the parameters are the next tokens on the stack.
		// But, they need to be processed
		ExpressionTreeNode param = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		return new Negate(param);
	}

}
