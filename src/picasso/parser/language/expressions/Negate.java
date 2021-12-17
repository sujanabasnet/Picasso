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
		/**
		 * This inverts the colors from RGB to YUV.
		 */
		public RGBColor evaluate(RGBColor param, RGBColor unused) {
			return new RGBColor(-param.getRed(), -param.getGreen(), -param.getBlue());
		}

	@Override
	public String getOperation() {
		return "!";
	}
	@Override
	public RGBColor evaluate(double x, double y) {
		return null;
	}

}
