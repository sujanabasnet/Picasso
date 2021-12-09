package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Mod;
import picasso.parser.tokens.Token;

/**
 * Handles parsing of the mod function.
 * 
 * @author Robert C. Duvall
 * @author Sarah Martin
 * 
 */
public class ModAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Remove the mod token
		ExpressionTreeNode second = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode first = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		return new Mod(first, second);
	}

}
