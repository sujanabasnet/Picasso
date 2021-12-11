/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Addition function in the Picasso language.
 * @author andrewmarsh
 *
 */
public class Addition extends BinaryOperator {

	/**
	 * @param left
	 * @param right
	 */
	public Addition(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor a = left.evaluate(x, y);
		RGBColor b = right.evaluate(x, y);
		double red = a.getRed() + b.getRed();
		double green = a.getGreen() + b.getGreen();
		double blue = a.getBlue() + b.getBlue();
		return new RGBColor(red, green, blue);
	}
	

	@Override
	public String getOperation() {
		return "+";
	}

}
