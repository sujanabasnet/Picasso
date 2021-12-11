/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Division binary operator.
 * @author Jared Cordova
 *
 */
public class Division extends BinaryOperator {

	/**
	 * @param left
	 * @param right
	 */
	public Division(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
	
	}
	/** 
	 * This provides the code for the division binary operator
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor a = left.evaluate(x, y);
		RGBColor b = right.evaluate(x, y);
		double red = a.getRed() / b.getRed();
		double green = a.getGreen() / b.getGreen();
		double blue = a.getBlue() / b.getBlue();
		return new RGBColor(red, green, blue);
	}
	
	@Override
	public String getOperation() {
		return "/";
	}

}