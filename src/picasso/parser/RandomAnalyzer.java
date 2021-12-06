package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Randomizer;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the random function
 * @author sarahmartin
 
 */
public class RandomAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		return new Randomizer();
	}

}
