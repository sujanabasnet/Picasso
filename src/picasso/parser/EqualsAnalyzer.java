package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Equals;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the plus or "addition function".
 * 
 * @author andrew marsh
 * 
 */
public class EqualsAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		System.out.print(tokens);
		tokens.pop(); 
		ExpressionTreeNode expr = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		System.out.print(tokens);
		if (tokens.peek() instanceof IdentifierToken) {
			IdentifierToken t = (IdentifierToken) tokens.pop();
			String id = t.getName();
			return new Equals(id, expr);
		}
		throw new ParseException("Expected a variable name.");
		
	}

}