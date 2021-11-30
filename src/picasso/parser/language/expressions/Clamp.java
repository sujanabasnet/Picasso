/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a clamping function which keeps the answers between -1 and 1
 * 
 * @author Robert C. Duvall
 * @author Sarah Martin
 * 
 */
public class Clamp extends UnaryFunction {

	/**
	 * determines the absolute value of a given expression
	 * 
	 * @param param the expression to absolute value
	 */
	public Clamp(ExpressionTreeNode param) {
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
		
		double red = result.getRed();
		double green = result.getGreen();
		double blue = result.getBlue();
		
		if (result.getRed() > 1) {
			red = 1;
		}
		if (result.getBlue() > 1) {
			blue = 1;
		}
		if (result.getGreen() > 1) {
			green = 1;
		}
		
		if (result.getRed() < -1) {
			red = -1;
		}
		if (result.getBlue() < -1) {
			blue = -1;
		}
		if (result.getGreen() < -1) {
			green = -1;
		}
		
		
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
		if (!(obj instanceof Clamp)) {
			return false;
		}
		Clamp c = (Clamp) obj;
		return param.equals(c.param);
	}

}


