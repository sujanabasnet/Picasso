/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.AbsoluteValue;
import picasso.parser.tokens.Token;

/**
 * @author sarahmartin
 *
 */
public class AbsoluteValueAnalyzer extends UnaryFunctionAnalyzer {

	/**
	 * 
	 */

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		return new AbsoluteValue(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}

}