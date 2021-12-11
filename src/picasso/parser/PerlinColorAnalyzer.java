package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.PerlinColor;
import picasso.parser.tokens.Token;

/**
 * Handles parsing of the PerlinColor Function.
 * 
 
 */
public class PerlinColorAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Remove the plus token
		// the parameters are the next tokens on the stack.
		// But, they need to be processed
		ExpressionTreeNode expr2 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode expr1 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		return new  PerlinColor(expr1, expr2);
	}

}
