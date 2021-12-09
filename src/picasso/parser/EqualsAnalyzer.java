package picasso.parser;

import java.util.Stack;

import javax.swing.JOptionPane;

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
		tokens.pop(); 
		ExpressionTreeNode expr = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		if (expr == null) {
			JOptionPane.showMessageDialog(null, "Expression doesn't exist in the Picasso language.", "Error Notification", JOptionPane.ERROR_MESSAGE);
		}
		while (!tokens.empty() ) {
			if (tokens.peek() instanceof IdentifierToken) {
				IdentifierToken t = (IdentifierToken) tokens.pop();
				String id = t.getName();
				return new Equals(id, expr);
		}	
		}
		throw new ParseException("Expected a variable name.");
	}

}