/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Absolute Value function in the Picasso language.
 * 
 * @author Robert C. Duvall
 * @author Sarah Martin
 * 
 */
public class Abs extends UnaryFunction {

	/**
	 * determines the absolute value of a given expression
	 * 
	 * @param param the expression to absolute value
	 */
	public Abs(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the absolute value of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the absolute value of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.abs(result.getRed());
		double green = Math.abs(result.getGreen());
		double blue = Math.abs(result.getBlue());
		return new RGBColor(red, green, blue);
	}

	/**
	 * Returns a boolean on if the given objects are equal
	 * @param Object obj
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Abs)) {
			return false;
		}
		Abs av = (Abs) obj;
		return param.equals(av.param);
	}

}


