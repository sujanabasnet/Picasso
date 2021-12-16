/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.ImageClip;
import picasso.parser.language.expressions.PicassoString;
import picasso.parser.tokens.StringToken;
import picasso.parser.tokens.Token;

/**
 * @author sujanabasnet
 *
 */
public class StringAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		StringToken token = (StringToken) tokens.pop();
		String fileName = token.getName();
		
		return new PicassoString(fileName);

	}

}
