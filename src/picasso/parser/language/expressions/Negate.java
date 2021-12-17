/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;
/**
 * Represents the negate unary operator.
 * @author Jared Cordova
 *
 */
public class Negate extends UnaryOperator {

	/**
	 * @param
	 * 
	 */
	public Negate(ExpressionTreeNode param) {
		super(param);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor c = param.evaluate(x, y);
		return new RGBColor(-c.getRed(), -c.getGreen(), -c.getBlue());
	}

	@Override
	public String getOperation() {
		return "!";
	}

}
