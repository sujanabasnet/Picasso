package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.PerlinBW;
import picasso.parser.tokens.Token;

/**
 * Handles parsing of the PerlinBW Function.
 * 
 
 */
public class PerlinBWAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Remove the plus token
		// the parameters are the next tokens on the stack.
		// But, they need to be processed
		ExpressionTreeNode expr2 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode expr1 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		return new  PerlinBW(expr1, expr2);
	}

}
