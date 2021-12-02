/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author andrewmarsh
 *
 */
public class Subtraction extends BinaryOperator {

	/**
	 * @param left
	 * @param right
	 */
	public Subtraction(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
		this.operation = "-";
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor a = left.evaluate(x, y);
		RGBColor b = right.evaluate(x, y);
		double red = a.getRed() - b.getRed();
		double green = a.getGreen() - b.getGreen();
		double blue = a.getBlue() - b.getBlue();
		return new RGBColor(red, green, blue);
	}
	

	@Override
	public String getOperation() {
		return this.operation;
	}

}
