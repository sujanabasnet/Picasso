/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.ImageClip;
import picasso.parser.tokens.StringToken;
import picasso.parser.tokens.Token;

/**
 * @author sujanabasnet
 *
 */
public class ImageClipAnalyzer implements SemanticAnalyzerInterface {


	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		
		ExpressionTreeNode expr2 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode expr1 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		
		if ((tokens.isEmpty()) || !(tokens.peek() instanceof StringToken)) {
			throw new ParseException("Expected an image name!");
		}
		StringToken token = (StringToken) tokens.pop();
		String fileName = token.getName();
		
		return new ImageClip(fileName, expr1, expr2);

	}

}
