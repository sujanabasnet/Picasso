package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Exponentiate;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the exponent or "exponent function".
 * 
 * @author Robert C. Duvall
 * @author Praise Apata
 * 
 */
public class ExponentiateAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Remove the star token
		// the parameters are the next tokens on the stack.
		// But, they need to be processed
		ExpressionTreeNode second = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode first = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		return new Exponentiate(first, second);
	}

}
