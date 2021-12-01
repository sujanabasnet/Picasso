package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Cosine;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the Cosine function.
 * 
 * @author Jared Cordova
 * 
 */
public class CosineAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		return new Cosine(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
