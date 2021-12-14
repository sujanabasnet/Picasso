package picasso.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import picasso.parser.tokens.StringToken;
import picasso.parser.tokens.Token;

/**
 * Handle an identifier token 
 * 
 * @author sarahmartin
 *
 */
public class StringAnalyzer implements SemanticAnalyzerInterface {

	static Map<String, ExpressionTreeNode> idToExpression = new HashMap<String, ExpressionTreeNode>();
	static Map<String, ExpressionTreeNode> charToExpression = new HashMap<String, ExpressionTreeNode>();
	Random rand;
	//Array() = new Array(new Addition(t, peek),

	static {
		// We always have x and y defined.
		idToExpression.put("x", new X());
		idToExpression.put("y", new Y());
		
		//all characters
		charToExpression.put("a", new Sin(new X()));
		charToExpression.put("b", new Cos(new Y()));
		charToExpression.put("c", new Tan(new X()));
		charToExpression.put("d", new Atan(new Y()));
		charToExpression.put("e", new Abs(new Addition(new X(), new Y())));
		charToExpression.put("f", new Ceil(new Mod(new Y(), new X())));
		charToExpression.put("g", new Floor(new Subtraction(new Y(), new X())));
		charToExpression.put("h", new Log(new Exponentiate(new Y(), new X())));
		charToExpression.put("i", new Mod(new Addition(new X(), new Y()), new X()));
		charToExpression.put("j", new Ycrcbtorgb(new Mod(new Y(), new X())));
		charToExpression.put("k", new Rgbtoycrcb(new Subtraction(new Y(), new X())));
		charToExpression.put("l", new Exp(new Multiplication(new X(), new Y())));
		charToExpression.put("m", new Cos(new Addition(new X(), new Y())));
		charToExpression.put("n", new Atan(new Mod(new Y(), new X())));
		charToExpression.put("o", new Subtraction(new Subtraction(new Y(), new X()), new Y()));
		charToExpression.put("p", new Mod(new Exponentiate(new X(), new Y()), new Ycrcbtorgb( new Y())));
		charToExpression.put("q", new Exponentiate(new Addition(new X(), new Y()), new X()));
		charToExpression.put("r", new Exp(new Mod(new Y(), new X())));
		charToExpression.put("s", new Rgbtoycrcb(new Division(new X(), new Y())));
		charToExpression.put("t", new Exp(new Multiplication(new Y(), new X())));
		charToExpression.put("u", new Multiplication(new Exponentiate(new Y(), new X()), new Sin(new X())));
		charToExpression.put("v", new Sin(new Rgbtoycrcb(new X())));
		charToExpression.put("w", new Division(new Addition(new X(), new Y()), new X()));
		charToExpression.put("x", new Mod(new Cos(new X()), new Y()));
		charToExpression.put("y", new PerlinColor(new Division(new X(), new Y()), new X()));
		charToExpression.put("z", new Abs(new Multiplication(new Y(), new X())));
		
		
		
		
		
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		rand = new Random();
		StringToken t;
		//while (!tokens.isEmpty()) {
		t = (StringToken) tokens.pop();
		StringToken peek = (StringToken) tokens.peek();
		//}
		
		String id = t.getName();
		//if (t >= 97 && t <= 122) {
			//if (tokens.peek() == lowercase) {
				
			//}
		
		ExpressionTreeNode mapped = charToExpression.get(id);
		if (mapped != null) {
			return mapped;
		}

		// TODO : What should we do if we don't recognize the identifier?
		// Is that an error? Or, could there a valid reason?
		return null;
	}

}
