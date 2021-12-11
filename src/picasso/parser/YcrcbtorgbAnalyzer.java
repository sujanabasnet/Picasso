package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Ycrcbtorgb;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the Ycrcbtorgb function.
 * 
 * @author sarahmartin
 * 
 */
public class YcrcbtorgbAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		return new Ycrcbtorgb(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
