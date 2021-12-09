package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Multiplication;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the star or "multiplication function".
 * 
 * @author Robert C. Duvall
 * @author Sarah Martin
 * 
 */
public class StarAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Remove the star token
		ExpressionTreeNode second = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode first = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		return new Multiplication(first, second);
	}

}
