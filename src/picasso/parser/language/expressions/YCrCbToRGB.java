/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * the Ycrcbtorgb function
 * @author sarahmartin
 *
 */
public class YCrCbToRGB extends UnaryFunction {

	/**
	 * @param param
	 * 
	 */
	public YCrCbToRGB(ExpressionTreeNode param) {
		super(param);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor a = param.evaluate(x,y);
		double red = a.getRed() + a.getBlue() * 1.4022;
		double green = a.getRed() + a.getGreen() * -0.3456 + a.getBlue() * -0.7145;
		double blue = a.getRed() + a.getGreen() * 1.7710;
		return new RGBColor(red, green, blue);
	}

}
