package picasso.parser;
import picasso.parser.tokens.operations.*;
import picasso.parser.tokens.functions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import picasso.parser.tokens.StringToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.chars.CharToken;

/**
 * Handle an identifier token 
 * 
 * @author sarahmartin
 *
 */
public class StringAnalyzer { //implements SemanticAnalyzerInterface{

	static Map<String, ExpressionTreeNode> idToExpression = new HashMap<String, ExpressionTreeNode>();
	static Map<String, ExpressionTreeNode> charToExpression = new HashMap<String, ExpressionTreeNode>();
	Random rand;
	//Array() = new Array(new Addition(t, peek),
	//error says i need a semantic analyzer, but then i have to extend the interface and use tokens
	//public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {return null;}

	static {
		// We always have x and y defined.
		idToExpression.put("x", new X());
		idToExpression.put("y", new Y());
		
		//all characters
		//lowercase letter
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
		//uppercase letters
		charToExpression.put("A", new Sin(new Y()));
		charToExpression.put("B", new Cos(new X()));
		charToExpression.put("C", new Tan(new X()));
		charToExpression.put("D", new Atan(new X()));
		charToExpression.put("E", new Abs(new Subtraction(new X(), new Y())));
		charToExpression.put("F", new Ceil(new Exponentiate(new Y(), new X())));
		charToExpression.put("G", new Floor(new Addition(new Y(), new X())));
		charToExpression.put("H", new Log(new Mod(new Y(), new X())));
		charToExpression.put("I", new PerlinBW(new Addition(new X(), new Y()), new Y()));
		charToExpression.put("J", new Ycrcbtorgb(new Exponentiate(new Y(), new X())));
		charToExpression.put("K", new Rgbtoycrcb(new Mod(new Y(), new X())));
		charToExpression.put("L", new Exp(new Division(new X(), new Y())));
		charToExpression.put("M", new Cos(new PerlinColor(new X(), new Y())));
		charToExpression.put("N", new Atan(new Subtraction(new Floor(new Y()), new X())));
		charToExpression.put("O", new Addition(new Subtraction(new Y(), new X()), new PerlinColor(new X(), new Ceil(new Y()))));
		charToExpression.put("P", new Multiplication(new Exponentiate(new X(), new Y()), new Ycrcbtorgb( new X())));
		charToExpression.put("Q", new Division(new Addition(new X(), new Y()), new Y()));
		charToExpression.put("R", new Exp(new Mod(new Y(), new Ycrcbtorgb(new X()))));
		charToExpression.put("S", new Rgbtoycrcb(new Multiplication(new X(), new Floor(new Y()))));
		charToExpression.put("T", new Exp(new Division(new Y(), new X())));
		charToExpression.put("U", new Division(new Mod(new Y(), new X()), new Atan(new Y())));
		charToExpression.put("V", new Cos(new Rgbtoycrcb(new Y())));
		charToExpression.put("W", new Multiplication(new Subtraction(new X(), new Y()), new Y()));
		charToExpression.put("X", new Exponentiate(new Sin(new X()), new Y()));
		charToExpression.put("Y", new PerlinColor(new Multiplication(new X(), new Y()), new Y()));
		charToExpression.put("Z", new Log(new Division(new Y(), new X())));
		
		
		
		
	}

	public ExpressionTreeNode generateExpressionTree( String s) {
		rand = new Random();
		//String s = "abc";
		
		//I think we need char token facotry,
		//problem here is that we have madet the 'char to expression' map a string to an expression
		//not a char to an expression
		
		//StringToken t;
		//StringToken t2;
		//Token[] binoptokens = {new StarToken() , new SlashToken(), new PlusToken(), new ModToken(), new MinusToken(), new ExponentiateToken()};
		//ArrayList l = new List(StarToken, SlashToken, PlusToken, ModToken, MinusToken, ExponentiateToken);
		if (s.length() % 2 == 0) {
			ExpressionTreeNode total = null;
			for (int i = 0; i < s.length(); i = i + 2) {
				
				String splice = s.substring(i, i + 1);
				String splice2 = s.substring(i+1, i+2);
				
				int randnum = rand.nextInt(7);
	
				 
				if (randnum == 1) {
					ExpressionTreeNode etm =  new Multiplication(charToExpression.get(splice), charToExpression.get(splice2));
					total = new Addition(total, etm);
					}
				if (randnum == 2) {
					ExpressionTreeNode etd =  new Division(charToExpression.get(splice), charToExpression.get(splice2));
					total = new Addition(total, etd);
					}
				if (randnum == 3) {
					ExpressionTreeNode eta =  new Addition(charToExpression.get(splice), charToExpression.get(splice2));
					total = new Addition(total, eta);
					}
				if (randnum == 4) {
					ExpressionTreeNode etmod =  new Mod(charToExpression.get(splice), charToExpression.get(splice2));
					total = new Addition(total, etmod);
					}				
				
				if (randnum == 5) {
					ExpressionTreeNode ets =  new Subtraction(charToExpression.get(splice), charToExpression.get(splice2));
					total = new Addition(total, ets);
					}
				if (randnum == 6) {
					ExpressionTreeNode ete =  new Exponentiate(charToExpression.get(splice), charToExpression.get(splice2));
					total = new Addition(total, ete);}
				
				
			}
			return total;
		}
		else {
			ExpressionTreeNode total = null;
			for (int i = 0; i < s.length() - 1; i += 2) {
				
				String splice = s.substring(i, i + 1);
				String splice2 = s.substring(i+1, i+2);
				
				int randnum = rand.nextInt(7);
	
				
				if (randnum == 1) {
					ExpressionTreeNode etm =  new Multiplication(charToExpression.get(splice), charToExpression.get(splice2));
					total = new Addition(total, etm);
					}
				if (randnum == 2) {
					ExpressionTreeNode etd =  new Division(charToExpression.get(splice), charToExpression.get(splice2));
					total = new Addition(total, etd);
					}
				if (randnum == 3) {
					ExpressionTreeNode eta =  new Addition(charToExpression.get(splice), charToExpression.get(splice2));
					total = new Addition(total, eta);
					}
				if (randnum == 4) {
					ExpressionTreeNode etmod =  new Mod(charToExpression.get(splice), charToExpression.get(splice2));
					total = new Addition(total, etmod);
					}				
				
				if (randnum == 5) {
					ExpressionTreeNode ets =  new Subtraction(charToExpression.get(splice), charToExpression.get(splice2));
					total = new Addition(total, ets);
					}
				if (randnum == 6) {
					ExpressionTreeNode ete =  new Exponentiate(charToExpression.get(splice), charToExpression.get(splice2));
					total = new Addition(total, ete);}
				
			
			}
			String secondtofinalsplice = s.substring(s.length() - 2, s.length() - 1);
			String finalsplice = s.substring(s.length() - 1, s.length());
			ExpressionTreeNode finalet =  new Addition(charToExpression.get(secondtofinalsplice), charToExpression.get(finalsplice));
			total = new Addition(total, finalet);
			
			return total;
		
			
		}
	}
}
			//StringToken t = (StringToken) strings.pop();
			//String id1 = t.getName();
			//StringToken t2 = (StringToken) strings.pop();
			//String id2 = t2.getName();
			
			
			

			//return new Subtraction(t, tokens.pop());
			
			//ExpressionTreeNode mapped = charToExpression.get(s);
			//if (mapped != null) {
				//return mapped;
			
		
			
		
		
		//String id = t.getName();
		//if (t >= 97 && t <= 122) {
			//if (tokens.peek() == lowercase) {
				
			//}
		
		//ExpressionTreeNode mapped = charToExpression.get(id);
		//if (mapped != null) {
		//	return mapped;
		//}

		// TODO : What should we do if we don't recognize the identifier?
		// Is that an error? Or, could there a valid reason?


