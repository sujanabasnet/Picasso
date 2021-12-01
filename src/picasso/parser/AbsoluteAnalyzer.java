/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Absolute;
import picasso.parser.tokens.Token;

/**
 * @author sarahmartin
 *
 */
public class AbsoluteAnalyzer extends UnaryFunctionAnalyzer {

	/**
	 * 
	 */

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		return new Absolute(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}

}