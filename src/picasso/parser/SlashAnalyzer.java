package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Division;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the slash or division function.
 * 
 * @author Robert C. Duvall
 * @author Jared Cordova
 * 
 */
public class SlashAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Remove the slash token
		// the parameters are the next tokens on the stack.
		// But, they need to be processed
		ExpressionTreeNode second = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode first = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		return new Division(first, second);
	}

}