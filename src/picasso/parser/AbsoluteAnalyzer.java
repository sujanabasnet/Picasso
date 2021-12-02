/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Absolute;
import picasso.parser.tokens.Token;

/**
 * Handles Parsing the Absolute Value Function
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