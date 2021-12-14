/**
 * 
 */
package picasso.parser.language.expressions;

import helper.MathHelp;
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
	 * determines the clamped value of a given expression
	 * 
	 * @param param the expression to clamp
	 */
	public Clamp(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the clamping of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the clamp value of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		
		double red = MathHelp.clamp(result.getRed());
		double green = MathHelp.clamp(result.getGreen());
		double blue = MathHelp.clamp(result.getBlue());
	
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
		if (!(obj instanceof Clamp)) {
			return false;
		}
		Clamp c = (Clamp) obj;
		return param.equals(c.param);
	}

}


