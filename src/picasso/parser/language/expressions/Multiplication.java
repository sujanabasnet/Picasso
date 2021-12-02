/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author Sarah Martin
 *
 */
public class Multiplication extends BinaryOperator {

	/**
	 * @param left
	 * @param right
	 */
	public Multiplication(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
		this.operation = "*";
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor a = left.evaluate(x, y);
		RGBColor b = right.evaluate(x, y);
		double red = a.getRed() * b.getRed();
		double green = a.getGreen() * b.getGreen();
		double blue = a.getBlue() * b.getBlue();
		return new RGBColor(red, green, blue);
	}
	

	@Override
	public String getOperation() {
		return this.operation;
	}

}