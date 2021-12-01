/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the log function in the Picasso language.
 * 
 * @author Robert C. Duvall
 * @author Sarah Martin
 * 
 */
public class Absolute extends UnaryFunction {

	/**
	 * determines the absolute value of a given expression
	 * 
	 * @param param the expression to absolute value
	 */
	public Absolute(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the absolute value of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the floor of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.abs(result.getRed());
		double green = Math.abs(result.getGreen());
		double blue = Math.abs(result.getBlue());
		return new RGBColor(red, green, blue);
	}

	/*
	 * 
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Absolute)) {
			return false;
		}
		Absolute av = (Absolute) obj;
		return param.equals(av.param);
	}

}


