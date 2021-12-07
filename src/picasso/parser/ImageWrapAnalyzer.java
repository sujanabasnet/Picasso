/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.ImageWrap;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;

/**
 * @author sujanabasnet
 *
 */
public class ImageWrapAnalyzer implements SemanticAnalyzerInterface {


	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		
		ExpressionTreeNode expr2 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode expr1 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		
		IdentifierToken token = (IdentifierToken) tokens.pop();
		String fileName = token.getName();
		
		return new ImageWrap(fileName, expr1, expr2);

	}

}
