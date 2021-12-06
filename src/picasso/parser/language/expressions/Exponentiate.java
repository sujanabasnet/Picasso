
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author Praise Apata
 *
 */
public class Exponentiate extends BinaryOperator {

	/**
	 * @param left
	 * @param right
	 */
	public Exponentiate(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
		this.operation = "^";
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor a = left.evaluate(x, y);
		RGBColor b = right.evaluate(x, y);
		double red = Math.pow(a.getRed(), b.getRed());
		double green = Math.pow(a.getGreen(), b.getGreen());
		double blue = Math.pow(a.getBlue(), b.getBlue());
		return new RGBColor(red, green, blue);
	}
	
	@Override
	public String getOperation() {
		return this.operation;
	}

}
