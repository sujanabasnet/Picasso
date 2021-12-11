package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Rgbtoycrcb;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the Rgbtoycrcb function.
 * 
 * @author sarahmartin
 * 
 */
public class RgbtoycrcbAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		return new Rgbtoycrcb(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}

}