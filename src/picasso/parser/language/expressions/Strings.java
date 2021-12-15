/**
 * 
 */
package picasso.parser.language.expressions;

import javax.swing.text.html.HTMLEditorKit.Parser;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Strings function in the Picasso language.
 * 
 * @author sarahmartin
 *
 */
public class Strings extends StringFunction {
	ExpressionTreeNode node;
	/**
	 * Create a string expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to sine
	 */
	public Strings(String s) {
		super(s);
		this.node = stringToEtn(s);
	}

	/**
	 * 
	 * 
	 * @return the color 
	 */
	
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = node.evaluate(x, y);
		double red = result.getRed();
		double green = result.getGreen();
		double blue = result.getBlue();

		return new RGBColor(red, green, blue);
	}
	

}








/*
/**
 * 
 
package picasso.parser.language.expressions;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author sarahmartin
 *
 
public class Strings extends StringFunction{
	/*
	static Map<String, ExpressionTreeNode> charToExpression = new HashMap<String, ExpressionTreeNode>();
	Random rand;
	static {
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
	*/
	
		
	
	
	/*
	 * 
	 
	public Strings(String s) {
		super(s);
		
	}
	
	
	public RGBColor evaluate(double x, double y) {
		ExpressionTreeNode result = super.parser(s);
		RGBColor resultant = result.evaluate(x, y);
		
		double red = resultant.getRed();
		double green = resultant.getGreen();
		double blue = resultant.getBlue();

		return new RGBColor(red, green ,blue);
	}

}*/
