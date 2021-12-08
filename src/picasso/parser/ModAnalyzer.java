package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Mod;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the modulo.
 * @author Praise Apata
 * 
 */
public class ModAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Remove the star token
		// the parameters are the next tokens on the stack.
		// But, they need to be processed
		ExpressionTreeNode second = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode first = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		return new Mod(first, second);
	}

}
