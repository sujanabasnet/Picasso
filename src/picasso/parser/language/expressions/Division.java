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
		double red; double green; double blue;
		if (b.getRed() == 0) {
			red = 0;
		}
		else { 
			red = a.getRed() / b.getRed();
		}
		
		if (b.getGreen() == 0) {
			green = 0;
		}
		else {
			 green = a.getGreen() / b.getGreen();
		}
		
		if (b.getBlue() == 0) {
			blue = 0;
		}
		else {
			blue = a.getBlue() / b.getBlue();
		}
		return new RGBColor(red, green, blue);
	}
	
	@Override
	public String getOperation() {
		return "/";
	}

}