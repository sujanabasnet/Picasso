package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the assignment functionality.
 * 
 * @author andrew marsh, sujanabasnet
 * 
 */
public class EqualsAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		ExpressionTreeNode expr = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		System.out.println(tokens);
		if (!tokens.isEmpty()) {
			if (tokens.peek() instanceof IdentifierToken) {
				IdentifierToken t = (IdentifierToken) tokens.pop();
				String id = t.getName();
				if (!(id.equals("x") || id.equals("y"))) {
					IdentifierAnalyzer.idToExpression.put(t.getName(), expr);
					return expr;
				}
				throw new ParseException("Variable name cannot be x or y.");

			}
			throw new ParseException("Variable name cannot be a number, color, or function.");
		}
		throw new ParseException("Expected a variable name.");
	}

}